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

public class BasicDrumHipHop extends Card2d {

    public BasicDrumHipHop(MainGame game){
        super(game);
        Texture tex = game.assets.manager.get("image-drum1.jpg", Texture.class);
        picreg = new TextureRegion(tex);
        super.ttext = "Hip Hop Drum";
        super.dtext = "+2 Drums\nSpecial: Add from bottom";
        super.ftext = "Badum tish";
        basecost = 2;

        UpdateAssets();
    }

    @Override
    public boolean Play() {
        if (!Session.CostCheck(this)) return false;
        Texture tex = new Texture(Gdx.files.internal("tracks-point3.png"));
        TextureRegion reg = new TextureRegion(tex);

        Clip clipone = new Clip();
        Clip cliptwo = new Clip();
        clipone.style = TrackPlaylist.SongStyle.HIPHOP;
        cliptwo.style = TrackPlaylist.SongStyle.HIPHOP;
        clipone.crowdpoints = Constants.baseclippoints;
        cliptwo.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);
        cliptwo.img = new Image(reg);

        Session.State.getui().tracks.dtrack.InsertTop(clipone);
        Session.State.getui().tracks.dtrack.InsertTop(cliptwo);

        Session.State.watchdog.CardPlayed();
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }

    @Override
    public boolean PlaySpecial() {
        // TODO: add inspiration check
        if (!Session.CostCheck(this)) return false;

        Texture tex = new Texture(Gdx.files.internal("tracks-point3.png"));
        TextureRegion reg = new TextureRegion(tex);

        Clip clipone = new Clip();
        Clip cliptwo = new Clip();
        clipone.style = TrackPlaylist.SongStyle.HIPHOP;
        cliptwo.style = TrackPlaylist.SongStyle.HIPHOP;
        clipone.crowdpoints = Constants.baseclippoints;
        cliptwo.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);
        cliptwo.img = new Image(reg);

        Session.State.getui().tracks.dtrack.InsertBottom(clipone);
        Session.State.getui().tracks.dtrack.InsertBottom(cliptwo);

        Session.State.watchdog.CardPlayed();
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }
}
