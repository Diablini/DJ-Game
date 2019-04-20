package com.djgame.Card.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.djgame.Card.Card2d;
import com.djgame.Constants;
import com.djgame.Session;
import com.djgame.TrackPlaylist;

public class BasicDrumHipHop extends Card2d {

    public BasicDrumHipHop(){
        Texture tex = new Texture(Gdx.files.internal("image-drum1.jpg"));
        picreg = new TextureRegion(tex);
        super.ttext = "Hip Hop Drum";
        super.dtext = "+2 Drums\nSpecial: Add from bottom";
        super.ftext = "Badum tish";
        basecost = 2;

        UpdateAssets();
    }

    @Override
    public boolean Play() {
        // TODO: add inspiration check
        if (!Session.CostCheck(this)) return false;
        Texture tex = new Texture(Gdx.files.internal("point-green.png"));
        TextureRegion reg = new TextureRegion(tex);

        TrackPlaylist.Clip clipone = Session.State.getui().tracks.new Clip();
        TrackPlaylist.Clip cliptwo = Session.State.getui().tracks.new Clip();
        clipone.style = TrackPlaylist.SongStyle.HIPHOP;
        cliptwo.style = TrackPlaylist.SongStyle.HIPHOP;
        clipone.crowdpoints = Constants.baseclippoints;
        cliptwo.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);
        cliptwo.img = new Image(reg);

        Session.State.getui().tracks.dtrack.InsertTop(clipone);
        Session.State.getui().tracks.dtrack.InsertTop(cliptwo);

        Session.DiscardAfterPlay(this);
        return true;
    }

    @Override
    public boolean PlaySpecial() {
        // TODO: add inspiration check
        if (!Session.CostCheck(this)) return false;

        Texture tex = new Texture(Gdx.files.internal("point-green.png"));
        TextureRegion reg = new TextureRegion(tex);

        TrackPlaylist.Clip clipone = Session.State.getui().tracks.new Clip();
        TrackPlaylist.Clip cliptwo = Session.State.getui().tracks.new Clip();
        clipone.style = TrackPlaylist.SongStyle.HIPHOP;
        cliptwo.style = TrackPlaylist.SongStyle.HIPHOP;
        clipone.crowdpoints = Constants.baseclippoints;
        cliptwo.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);
        cliptwo.img = new Image(reg);

        Session.State.getui().tracks.dtrack.InsertBottom(clipone);
        Session.State.getui().tracks.dtrack.InsertBottom(cliptwo);

        Session.DiscardAfterPlay(this);
        return true;
    }
}