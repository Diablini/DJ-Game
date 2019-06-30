package com.djgame.Card.Cards.Rare;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.djgame.Card.Card2d;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

public class ResetMixerBonuses extends Card2d {

    public ResetMixerBonuses(MainGame game)
    {
        super(game);
        Texture tex = game.assets.manager.get("eqrainbow.jpg", Texture.class);
        picreg = new TextureRegion(tex);
        super.ttext = "Low Pass";
        super.dtext = "+2 Mix Power\nReset mixer bonuses";
        super.ftext = "";
        basecost = 2;

        rarity = Rarity.Rare;
        type = CardType.Support;
        UpdateAssets();

    }

    @Override
    public Card2d clone() {
        ResetMixerBonuses c = new ResetMixerBonuses(game);
        return c;
    }

    @Override
    public boolean Play() {
        if (!Session.CostCheck(this)) return false;

        Session.State.setMixpower(Session.State.getMixpower() + 2);
        Session.State.getui().mixer.ResetBonuses();

        Session.State.watchdog.CardPlayed(this);
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }
}
