package com.djgame.Card.Cards;

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

public class BasicSynthHouse extends Card2d {

    public BasicSynthHouse(MainGame game){
        super(game);
        Texture tex = game.assets.manager.get("image-lead1.jpg", Texture.class);
        picreg = new TextureRegion(tex);
        super.ttext = "House Synths";
        super.dtext = "+1 Synth\nSpecial: Add from bottom";
        super.ftext = "";
        basecost = 1;

        UpdateAssets();
    }

    @Override
    public Card2d clone() {
        BasicSynthHouse c = new BasicSynthHouse(game);
        return c;
    }

    @Override
    public boolean Play() {
        // TODO: add inspiration check
        if (!Session.CostCheck(this)) return false;
        Texture tex = new Texture(Gdx.files.internal("tracks-point2.png"));
        TextureRegion reg = new TextureRegion(tex);

        Clip clipone = new Clip();
        clipone.style = TrackPlaylist.SongStyle.HOUSE;
        clipone.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);

        Session.State.getui().tracks.strack.InsertTop(clipone);

        Session.State.watchdog.CardPlayed();
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }

    @Override
    public boolean PlaySpecial() {
        // TODO: add inspiration check
        if (!Session.CostCheck(this)) return false;

        Texture tex = new Texture(Gdx.files.internal("tracks-point2.png"));
        TextureRegion reg = new TextureRegion(tex);

        Clip clipone = new Clip();
        clipone.style = TrackPlaylist.SongStyle.HOUSE;
        clipone.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);

        Session.State.getui().tracks.strack.InsertBottom(clipone);

        Session.State.watchdog.CardPlayed();
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }
}