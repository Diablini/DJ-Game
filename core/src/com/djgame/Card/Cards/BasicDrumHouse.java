package com.djgame.Card.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.djgame.Card.Card2d;
import com.djgame.Constants;
import com.djgame.Session;
import com.djgame.TrackPlaylist;

public class BasicDrumHouse extends Card2d {

    public BasicDrumHouse(){
        //super.picreg
        super.ttext = "House Drums";
        super.dtext = "+2 Drum\nSpecial: Add from bottom";
        super.ftext = "4 on the floor";
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
        clipone.style = TrackPlaylist.SongStyle.HOUSE;
        cliptwo.style = TrackPlaylist.SongStyle.HOUSE;
        clipone.crowdpoints = Constants.baseclippoints;
        cliptwo.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);
        cliptwo.img = new Image(reg);

        Session.State.getui().tracks.dtrack.InsertTop(clipone);
        Session.State.getui().tracks.dtrack.InsertTop(cliptwo);
        return true;
    }

    @Override
    public boolean PlaySpecial() {
        // TODO: add inspiration check

        Texture tex = new Texture(Gdx.files.internal("point-synth.png"));
        TextureRegion reg = new TextureRegion(tex);

        TrackPlaylist.Clip clipone = Session.State.getui().tracks.new Clip();
        TrackPlaylist.Clip cliptwo = Session.State.getui().tracks.new Clip();
        clipone.style = TrackPlaylist.SongStyle.HOUSE;
        cliptwo.style = TrackPlaylist.SongStyle.HOUSE;
        clipone.crowdpoints = Constants.baseclippoints;
        cliptwo.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);
        cliptwo.img = new Image(reg);

        Session.State.getui().tracks.dtrack.InsertBottom(clipone);
        Session.State.getui().tracks.dtrack.InsertBottom(cliptwo);
        return true;
    }
}
