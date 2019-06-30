package com.djgame.Card.Cards.Common;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.djgame.Card.Card2d;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

public class MixerMoveUp extends Card2d {

    public MixerMoveUp(MainGame game)
    {
        super(game);
        Texture tex = game.assets.manager.get("lowpass.png", Texture.class);
        picreg = new TextureRegion(tex);
        ttext = "High Filter";
        dtext = "Move both mixers up";
        ftext = "";
        basecost = 1;


        rarity = Rarity.Common;
        type = CardType.Support;
        UpdateAssets();
    }

    @Override
    public Card2d clone() {
        MixerMoveUp c = new MixerMoveUp(game);
        return c;
    }

    @Override
    public boolean Play() {
        if (!Session.CostCheck(this)) return false;

        Session.State.setMixpower(Session.State.getMixpower() + 2);
        Session.State.getui().mixer.rtrack.MoveUp();
        Session.State.getui().mixer.ltrack.MoveUp();

        Session.RefreshUI();
        Session.State.watchdog.CardPlayed(this);
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }
}
