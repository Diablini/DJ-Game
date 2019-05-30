package com.djgame.Card.Cards.Common;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.djgame.Card.Card2d;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

public class MixerPoint extends Card2d {
    public MixerPoint(MainGame game){
        super(game);
        Texture tex = game.assets.manager.get("mixing-pic.jpg", Texture.class);
        picreg = new TextureRegion(tex);
        ttext = "Quick Mix";
        dtext = "+1 Mix Power";
        ftext = "";
        basecost = 1;


        rarity = Rarity.Common;
        type = CardType.Support;
        UpdateAssets();
    }

    @Override
    public Card2d clone() {
        MixerPoint c = new MixerPoint(game);
        return c;
    }

    @Override
    public boolean Play() {
        if (!Session.CostCheck(this)) return false;
        Session.State.setMixpower(Session.State.getMixpower() + 1);
        Session.RefreshUI();
        Session.State.watchdog.CardPlayed();
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }
}
