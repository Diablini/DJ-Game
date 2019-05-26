package com.djgame.Card.Cards;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.djgame.Assets;
import com.djgame.Card.Card2d;
import com.djgame.Constants;
import com.djgame.Powers.Power;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

public class AdvancedDrawperturn extends Card2d {
    public AdvancedDrawperturn(MainGame game)
    {
        super(game);
        Texture tex = game.assets.manager.get("winamp.jpg", Texture.class);
        TextureRegion reg = new TextureRegion(tex);
        super.picreg = reg;
        super.ttext = "Playlist";
        super.dtext = "Draw 1 more card at the beginning of each turn";
        super.ftext = "Pusni Soni";
        basecost = 3;

        UpdateAssets();
    }

    @Override
    public boolean Play() {
        if (!Session.CostCheck(this)) return false;

        class DrawPerTurn extends Power{
            @Override
            public void Play() {
                Session.DrawCard();
            }

            @Override
            public void Expire() {

            }
        }

        DrawPerTurn p = new DrawPerTurn();
        p.priority = 0;
        p.duration = Constants.maxpowerduration;

        Session.State.powers.AddBefore(p);

        Session.State.watchdog.PowerBeforeCreated();
        Session.State.watchdog.CardPlayed();
        Session.PayCardCost(this);
        Session.Exhaust(this);
        return true;
    }


}
