package com.djgame.Card.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.djgame.Card.Card2d;
import com.djgame.Constants;
import com.djgame.Session;
import com.djgame.TrackPlaylist;

public class BasicBassHipHop extends Card2d {

    public BasicBassHipHop(){
        //super.picreg
        super.ttext = "Hip Hop Bass";
        super.dtext = "+2 Bass\nSpecial: Add from bottom";
        super.ftext = "Drop it";
        basecost = 2;

        UpdateAssets();
    }

    @Override
    public boolean Play() {
        // TODO: add inspiration check

        Texture tex = new Texture(Gdx.files.internal("point-bass.png"));
        TextureRegion reg = new TextureRegion(tex);

        TrackPlaylist.Clip clipone = Session.State.getui().tracks.new Clip();
        TrackPlaylist.Clip cliptwo = Session.State.getui().tracks.new Clip();
        clipone.style = TrackPlaylist.SongStyle.HIPHOP;
        cliptwo.style = TrackPlaylist.SongStyle.HIPHOP;
        clipone.crowdpoints = Constants.baseclippoints;
        cliptwo.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);
        cliptwo.img = new Image(reg);

        Session.State.getui().tracks.btrack.InsertTop(clipone);
        Session.State.getui().tracks.btrack.InsertTop(cliptwo);
        return true;
    }

    @Override
    public boolean PlaySpecial() {
        // TODO: add inspiration check

        Texture tex = new Texture(Gdx.files.internal("point-bass.png"));
        TextureRegion reg = new TextureRegion(tex);

        TrackPlaylist.Clip clipone = Session.State.getui().tracks.new Clip();
        TrackPlaylist.Clip cliptwo = Session.State.getui().tracks.new Clip();
        clipone.style = TrackPlaylist.SongStyle.HIPHOP;
        cliptwo.style = TrackPlaylist.SongStyle.HIPHOP;
        clipone.crowdpoints = Constants.baseclippoints;
        cliptwo.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);
        cliptwo.img = new Image(reg);

        Session.State.getui().tracks.btrack.InsertBottom(clipone);
        Session.State.getui().tracks.btrack.InsertBottom(cliptwo);
        return true;
    }
}
