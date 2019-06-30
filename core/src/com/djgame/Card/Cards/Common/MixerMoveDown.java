package com.djgame.Card.Cards.Common;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.djgame.Card.Card2d;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

public class MixerMoveDown extends Card2d {

    public MixerMoveDown(MainGame game)
    {
        super(game);
        Texture tex = game.assets.manager.get("highpass.jpg", Texture.class);
        picreg = new TextureRegion(tex);
        ttext = "Low Filter";
        dtext = "Move both mixers down";
        ftext = "";
        basecost = 1;


        rarity = Rarity.Common;
        type = CardType.Support;
        UpdateAssets();
    }

    @Override
    public Card2d clone() {
        MixerMoveDown c = new MixerMoveDown(game);
        return c;
    }

    @Override
    public boolean Play() {
        if (!Session.CostCheck(this)) return false;

        Session.State.setMixpower(Session.State.getMixpower() + 2);
        Session.State.getui().mixer.rtrack.MoveDown();
        Session.State.getui().mixer.ltrack.MoveDown();

        Session.RefreshUI();
        Session.State.watchdog.CardPlayed(this);
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }
}
