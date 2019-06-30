package com.djgame.Card.Cards.Common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.djgame.Card.Card2d;
import com.djgame.Constants;
import com.djgame.Screens.MainGame;
import com.djgame.Session;
import com.djgame.Tracks.Clip;
import com.djgame.Tracks.TrackPlaylist;

public class BassTrap extends Card2d {

    public BassTrap(MainGame game){
        super(game);

        Texture tex = game.assets.manager.get("cards-bass2.png", Texture.class);
        TextureRegion reg = new TextureRegion(tex);

        super.picreg = reg;
        super.ttext = "Trap Bass's";
        super.dtext = "+1 Bass\nSpecial: Add from bottom";
        super.ftext = "Drop it";
        basecost = 1;


        rarity = Rarity.Common;
        type = CardType.Music;
        UpdateAssets();
    }

    @Override
    public Card2d clone() {
        BassTrap c = new BassTrap(game);
        return c;
    }

    @Override
    public boolean Play() {
        // TODO: add inspiration check
        if (!Session.CostCheck(this)) return false;

        Texture tex = new Texture(Gdx.files.internal("tracks-point1.png"));
        TextureRegion reg = new TextureRegion(tex);

        Clip clipone = new Clip();
        clipone.style = TrackPlaylist.SongStyle.TRAP;
        clipone.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);

        Session.State.getui().tracks.btrack.InsertTop(clipone);

        Session.State.watchdog.CardPlayed(this);
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }

    @Override
    public boolean PlaySpecial() {
        // TODO: add inspiration check
        if (!Session.CostCheck(this)) return false;

        Texture tex = new Texture(Gdx.files.internal("tracks-point1.png"));
        TextureRegion reg = new TextureRegion(tex);

        Clip clipone = new Clip();
        clipone.style = TrackPlaylist.SongStyle.TRAP;
        clipone.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);

        Session.State.getui().tracks.btrack.InsertBottom(clipone);

        Session.State.watchdog.CardPlayed(this);
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }
}
