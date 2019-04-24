package com.djgame.Card.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.djgame.Card.Card2d;
import com.djgame.Session;

public class BasicMixerPoint extends Card2d {
    public BasicMixerPoint(){
        Texture tex = new Texture(Gdx.files.internal("mixing-pic.jpg"));
        picreg = new TextureRegion(tex);
        ttext = "Quick Mix";
        dtext = "+1 Mix Power";
        ftext = "";
        basecost = 1;

        UpdateAssets();
    }

    @Override
    public boolean Play() {
        if (!Session.CostCheck(this)) return false;
        Session.State.setMixpower(Session.State.getMixpower() + 1);
        Session.RefreshUI();
        Session.State.watchdog.CardPlayed();
        Session.DiscardAfterPlay(this);
        return true;
    }
}
