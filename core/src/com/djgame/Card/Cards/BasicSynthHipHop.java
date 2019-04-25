package com.djgame.Card.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.djgame.Card.Card2d;
import com.djgame.Constants;
import com.djgame.Session;
import com.djgame.Tracks.Clip;
import com.djgame.Tracks.TrackPlaylist;

public class BasicSynthHipHop extends Card2d {

    public BasicSynthHipHop(){
        Texture tex = new Texture(Gdx.files.internal("image-lead1.jpg"));
        picreg = new TextureRegion(tex);
        super.ttext = "Hip Hop Synth";
        super.dtext = "+1 Synth Hip Hop\nSpecial: Add from bottom";
        super.ftext = "";
        basecost = 1;

        UpdateAssets();
    }

    @Override
    public boolean Play() {
        // TODO: add inspiration check
        if (!Session.CostCheck(this)) return false;
        Texture tex = new Texture(Gdx.files.internal("tracks-point3.png"));
        TextureRegion reg = new TextureRegion(tex);

        Clip clipone = new Clip();
        clipone.style = TrackPlaylist.SongStyle.HIPHOP;
        clipone.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);

        Session.State.getui().tracks.strack.InsertTop(clipone);

        Session.State.watchdog.CardPlayed();
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
        clipone.style = TrackPlaylist.SongStyle.HIPHOP;
        clipone.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);

        Session.State.getui().tracks.strack.InsertBottom(clipone);

        Session.State.watchdog.CardPlayed();
        Session.DiscardAfterPlay(this);
        return true;
    }
}