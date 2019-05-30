package com.djgame.Card.Cards.Common;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.djgame.Card.Card2d;
import com.djgame.ChooseHandling.ChooseListener;
import com.djgame.ChooseHandling.ChooseRequest;
import com.djgame.ChooseHandling.InfoCarrier;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

public class PlayTrack extends Card2d {
    public PlayTrack(MainGame game)
    {
        super(game);
        Texture tex = game.assets.manager.get("skipicon.jpg", Texture.class);
        TextureRegion reg = new TextureRegion(tex);
        ttext = "Acapella";
        ftext = "";
        dtext = "Instantly play a track\nSpecial: Draw 1 Card";
        basecost = 0;
        picreg = reg;


        rarity = Rarity.Common;
        type = CardType.Support;
        UpdateAssets();
    }

    @Override
    public Card2d clone() {
        PlayTrack c = new PlayTrack(game);
        return c;
    }

    @Override
    public boolean Play() {

        if (!Session.CostCheck(this)) return false;

        // if there are no tracks to play skip the request
        if (!Session.State.getui().tracks.strack.HasClips() &&
            !Session.State.getui().tracks.btrack.HasClips() &&
            !Session.State.getui().tracks.dtrack.HasClips())
        {
            Session.State.watchdog.CardPlayed();
            Session.DiscardAfterPlay(this);
            return true;
        }

        ChooseRequest req = new ChooseRequest() {
            @Override
            public void callback() {
                if (!info.chosentracks.firstElement().HasClips()){
                    // place request again
                    info.chosentracks.remove(0);
                    Session.State.choose.PutRequestLast(this);
                }
                else
                {
                    info.chosentracks.firstElement().PlayNext();
                }

            }
        };
        req.info = new InfoCarrier();
        req.type = ChooseListener.ChooseRequestType.TRACK;
        req.prompt = "Choose a track to play instantly";

        Session.State.choose.PutRequestFirst(req);

        Session.State.watchdog.CardPlayed();
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }

    @Override
    public boolean PlaySpecial() {
        if (!Session.CostCheck(this)) return false;

        Session.DrawCard();

        Session.State.watchdog.CardPlayed();
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }
}
