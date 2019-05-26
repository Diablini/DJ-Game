package com.djgame.Card.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.djgame.Card.Card2d;
import com.djgame.ChooseHandling.ChooseListener;
import com.djgame.ChooseHandling.ChooseRequest;
import com.djgame.ChooseHandling.InfoCarrier;
import com.djgame.EventHandling.Watchdog;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;

public class BasicClipSwap extends Card2d {
    public BasicClipSwap(MainGame game)
    {
        super(game);
        Texture tex = game.assets.manager.get("sampler.jpg", Texture.class);
        TextureRegion reg = new TextureRegion(tex);
        basecost = 1;
        ttext = "Sampler";
        ftext = "";
        dtext = "Move the top clip of one track to another track";
        picreg = reg;

        UpdateAssets();
    }

    @Override
    public boolean Play() {
        if (!Session.CostCheck(this)) return false;

        // handle special cases - eg: what if there are no clips in the tracks?
        // what if all tracks are full and there is no space to move clip?
        if (!Session.State.getui().tracks.dtrack.HasClips() &&
                !Session.State.getui().tracks.btrack.HasClips() &&
                !Session.State.getui().tracks.strack.HasClips())
        {
            // we have no clips, cant play this card
            return false;
        }

        if (Session.State.getui().tracks.dtrack.IsFull() &&
                Session.State.getui().tracks.btrack.IsFull() &&
                Session.State.getui().tracks.strack.IsFull())
        {
            // all tracks are full, cant play this card
            return false;
        }

        ChooseRequest from = new ChooseRequest() {
            @Override
            public void callback() {
                if (!info.chosentracks.firstElement().HasClips())
                {
                    // cant get a clip from empty playlist, place request again
                    info.chosentracks.clear();
                    Session.State.choose.PutRequestAfter(this, this);
                }
                else
                {
                    // do nothing, info carrier will pass info to next request
                }
            }
        };
        from.prompt = "Choose a track\n Take top clip from it";
        from.type = ChooseListener.ChooseRequestType.TRACK;
        from.info = new InfoCarrier();

        ChooseRequest to = new ChooseRequest() {
            @Override
            public void callback() {
                // check if both chosen tracks are the same track
                // we dont want that happening
                if (info.chosentracks.lastElement().IsFull() ||
                        info.chosentracks.lastElement() == info.chosentracks.firstElement())
                {
                    // cant insert clip into empty playlist, place request again
                    info.chosentracks.remove(info.chosentracks.size() - 1);
                    Session.State.choose.PutRequestLast(this);
                }
                else
                {

                    // move top of first chosen track to top of last chosen track
                    info.chosentracks.lastElement().InsertTop(
                            info.chosentracks.firstElement().GetTop());
                    info.chosentracks.firstElement().RemoveTop();
                }
            }
        };
        to.prompt = "Choose a track\n Insert chosen clip to its top";
        to.type = ChooseListener.ChooseRequestType.TRACK;
        to.info = new InfoCarrier();

        Session.State.choose.PutRequestFirst(to);
        Session.State.choose.PutRequestFirst(from);

        Session.State.watchdog.CardPlayed();
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }
}
