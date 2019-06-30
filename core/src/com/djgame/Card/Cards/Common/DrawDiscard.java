package com.djgame.Card.Cards.Common;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.djgame.Card.Card2d;
import com.djgame.ChooseHandling.ChooseListener;
import com.djgame.ChooseHandling.ChooseRequest;
import com.djgame.ChooseHandling.InfoCarrier;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

public class DrawDiscard extends Card2d {
    public DrawDiscard(MainGame game){
        super(game);
        Texture tex = game.assets.manager.get("jacks.jpg", Texture.class);
        TextureRegion reg = new TextureRegion(tex);
        super.picreg = reg;
        super.ttext = "Transition";
        super.dtext = "Draw 1 Card\nDiscard 1 Card";
        super.ftext = "";
        basecost = 0;


        rarity = Rarity.Common;
        type = CardType.Support;
        UpdateAssets();
    }

    @Override
    public Card2d clone() {
        DrawDiscard c = new DrawDiscard(game);
        return c;
    }

    @Override
    public boolean Play() {
        if (!Session.CostCheck(this)) return false;

        Session.DrawCard();
        ChooseRequest req = new ChooseRequest() {
            @Override
            public void callback() {
                Session.DiscardNoPlay(
                        info.chosencards.get(0));
            }
        };

        req.info = new InfoCarrier();
        req.prompt = "Choose Card to discard";
        req.type = ChooseListener.ChooseRequestType.CARD;
        Session.State.choose.PutRequestLast(req);


        Session.State.watchdog.CardPlayed(this);
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }
}
