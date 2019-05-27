package com.djgame.Card.Cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.djgame.Card.Card2d;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

public class AdvancedTwoDraw extends Card2d {

    public AdvancedTwoDraw(MainGame game)
    {
        super(game);
        Texture tex = game.assets.manager.get("encore.jpg", Texture.class);
        TextureRegion reg = new TextureRegion(tex);
        picreg = reg;
        ttext = "Encore";
        dtext = "Shuffle two zero cost \"Draw 2\" cards into your draw pile.\nExhaust";
        ftext = "We want more!";
        basecost = 3;

        UpdateAssets();
    }

    @Override
    public Card2d clone() {
        AdvancedTwoDraw c = new AdvancedTwoDraw(game);
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
        Session.State.watchdog.CardPlayed();
        Session.PayCardCost(this);
        Session.Exhaust(this);
        return true;
    }
}
