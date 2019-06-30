package com.djgame.Card.Cards.Special;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.djgame.Card.Card2d;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

public class ZeroCostDrawTwo extends Card2d {

    public ZeroCostDrawTwo(MainGame game)
    {
        super(game);
        Texture tex = game.assets.manager.get("vinylbox.jpg", Texture.class);
        TextureRegion reg = new TextureRegion(tex);
        picreg = reg;
        ttext = "Old Classics";
        dtext = "Draw two cards";
        ftext = "";
        basecost = 0;

        rarity = Rarity.Special;
        type = CardType.Support;

        UpdateAssets();

    }

    @Override
    public Card2d clone() {
        ZeroCostDrawTwo c = new ZeroCostDrawTwo(game);
        return c;
    }

    @Override
    public boolean Play() {
        if (!Session.CostCheck(this)) return false;

        Session.DrawCard();
        Session.DrawCard();

        Session.State.watchdog.CardPlayed(this);
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }
}
