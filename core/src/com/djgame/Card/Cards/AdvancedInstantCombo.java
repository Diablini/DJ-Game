package com.djgame.Card.Cards;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.djgame.Card.Card2d;
import com.djgame.Constants;
import com.djgame.Screens.MainGame;
import com.djgame.Session;
import com.djgame.Tracks.Clip;
import com.djgame.Tracks.TrackPlaylist;


public class AdvancedInstantCombo extends Card2d {
    public AdvancedInstantCombo(MainGame game)
    {
        super(game);
        Texture tex = game.assets.manager.get("turntable.jpg", Texture.class);
        TextureRegion reg = new TextureRegion(tex);
        picreg = reg;
        ttext = "Tempo Match";
        dtext = "Instantly get points for every combo on every track level";
        ftext = "";
        basecost = 3;

        UpdateAssets();
    }

    @Override
    public Card2d clone() {
        AdvancedInstantCombo c = new AdvancedInstantCombo(game);
        return c;
    }

    @Override
    public boolean Play() {
        if (!Session.CostCheck(this)) return false;

        for (int i = 0; i < Constants.btracksize; i++)
        {
            Clip dclip, bclip, sclip;
            dclip = Session.State.getui().tracks.dtrack.GetIndex(i);
            bclip = Session.State.getui().tracks.btrack.GetIndex(i);
            sclip = Session.State.getui().tracks.strack.GetIndex(i);

            if (dclip.style != TrackPlaylist.SongStyle.EMPTY &&
                    dclip.style == bclip.style && bclip.style == sclip.style)
            {
                Session.TripleCombo(dclip.style);
            }
            else
            {
                // check for double combos
                // Drum and Bass
                if (dclip.style == bclip.style && dclip.style != TrackPlaylist.SongStyle.EMPTY){
                    Session.DoubleCombo(dclip.style);
                }
                // Drum and Synth
                if (dclip.style == sclip.style && dclip.style != TrackPlaylist.SongStyle.EMPTY){
                    Session.DoubleCombo(dclip.style);
                }
                // Bass and Synth
                if (bclip.style == sclip.style && bclip.style != TrackPlaylist.SongStyle.EMPTY){
                    Session.DoubleCombo(bclip.style);
                }
            }
        }


        Session.RefreshUI();
        Session.State.watchdog.CardPlayed();
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }

}
