package com.djgame.Card.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.djgame.Card.Card2d;
import com.djgame.Constants;
import com.djgame.Session;
import com.djgame.TrackPlaylist;

public class BasicBassTrap extends Card2d {

    public BasicBassTrap(){
        //super.picreg
        super.ttext = "808's";
        super.dtext = "+1 Bass\nSpecial: Add from bottom";
        super.ftext = "Drop it";
        basecost = 1;

        UpdateAssets();
    }

    @Override
    public boolean Play() {
        // TODO: add inspiration check
        if (!Session.CostCheck(this)) return false;

        Texture tex = new Texture(Gdx.files.internal("point-red.png"));
        TextureRegion reg = new TextureRegion(tex);

        TrackPlaylist.Clip clipone = Session.State.getui().tracks.new Clip();
        clipone.style = TrackPlaylist.SongStyle.TRAP;
        clipone.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);

        Session.State.getui().tracks.btrack.InsertTop(clipone);

        Session.DiscardAfterPlay(this);
        return true;
    }

    @Override
    public boolean PlaySpecial() {
        // TODO: add inspiration check
        if (!Session.CostCheck(this)) return false;

        Texture tex = new Texture(Gdx.files.internal("point-red.png"));
        TextureRegion reg = new TextureRegion(tex);

        TrackPlaylist.Clip clipone = Session.State.getui().tracks.new Clip();
        clipone.style = TrackPlaylist.SongStyle.TRAP;
        clipone.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);

        Session.State.getui().tracks.btrack.InsertBottom(clipone);

        Session.DiscardAfterPlay(this);
        return true;
    }
}
