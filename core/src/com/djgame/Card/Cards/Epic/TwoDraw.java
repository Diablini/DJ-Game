package com.djgame.Card.Cards.Epic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.djgame.Card.Card2d;
import com.djgame.Card.Cards.Special.ZeroCostDrawTwo;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

public class TwoDraw extends Card2d {

    public TwoDraw(MainGame game)
    {
        super(game);
        Texture tex = game.assets.manager.get("encore.jpg", Texture.class);
        TextureRegion reg = new TextureRegion(tex);
        picreg = reg;
        ttext = "Encore";
        dtext = "Shuffle two zero cost \"Draw 2\" cards into your draw pile.\nExhaust";
        ftext = "We want more!";
        basecost = 3;

        rarity = Rarity.Epic;
        type = CardType.Power;
        UpdateAssets();
    }

    @Override
    public Card2d clone() {
        TwoDraw c = new TwoDraw(game);
        return c;
    }

    @Override
    public boolean Play() {
        if (!Session.CostCheck(this)) return false;

        Card2d cardone, cardtwo;
        cardone = new ZeroCostDrawTwo(game);
        cardtwo = new ZeroCostDrawTwo(game);

        Session.State.getui().drawpile.AddCard(cardone);
        Session.State.getui().drawpile.AddCard(cardtwo);
        Session.State.getui().drawpile.Shuffle();

        Session.RefreshUI();
        Session.State.watchdog.CardPlayed(this);
        Session.PayCardCost(this);
        Session.Exhaust(this);
        return true;
    }
}
