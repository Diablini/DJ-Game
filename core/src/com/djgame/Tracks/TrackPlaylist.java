package com.djgame.Tracks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.djgame.Constants;
import com.djgame.Session;

public class TrackPlaylist extends Group {

    public enum TrackType{
        DRUM,
        BASS,
        SYNTH,
    }

    public enum SongStyle{
        HIPHOP,
        TRAP,
        HOUSE,
        EMPTY
    }

    public Track dtrack, btrack, strack;

    public TrackPlaylist (){
        Texture tracktexd = new Texture(Gdx.files.internal("track-1.png"));
        Texture tracktexb = new Texture(Gdx.files.internal("track-2.png"));
        Texture tracktexs = new Texture(Gdx.files.internal("track-3.png"));
        TextureRegion trackregd = new TextureRegion(tracktexd);
        TextureRegion trackregb = new TextureRegion(tracktexb);
        TextureRegion trackregs = new TextureRegion(tracktexs);

        dtrack = new Track(this, Constants.dtracksize, trackregd);
        btrack = new Track(this, Constants.btracksize, trackregb);
        strack = new Track(this, Constants.stracksize, trackregs);

        btrack.setPosition(Constants.trackoffsetx,0);
        strack.setPosition(Constants.trackoffsetx * 2, 0);


        addActor(dtrack);
        addActor(btrack);
        addActor(strack);

    }

    public void PlayTracks(){
        // play requested tracks
        Clip dclip,bclip,sclip;

        if (dtrack.clips.isEmpty()){Session.EmptyTrack(TrackType.DRUM);}
        dclip = dtrack.GetNext();

        if (btrack.clips.isEmpty()){Session.EmptyTrack(TrackType.BASS);}
        bclip = btrack.GetNext();

        if (strack.clips.isEmpty()){Session.EmptyTrack(TrackType.SYNTH);}
        sclip = strack.GetNext();

        // check for triple combo
        if (dclip.style != SongStyle.EMPTY &&
                dclip.style == bclip.style && bclip.style == sclip.style)
        {
            Session.TripleCombo(dclip.style);
        }
        else
        {
            // check for double combos
            // Drum and Bass
            if (dclip.style == bclip.style && dclip.style != SongStyle.EMPTY){
                Session.DoubleCombo(dclip.style);
            }
            // Drum and Synth
            if (dclip.style == sclip.style && dclip.style != SongStyle.EMPTY){
                Session.DoubleCombo(dclip.style);
            }
            // Bass and Synth
            if (bclip.style == sclip.style && bclip.style != SongStyle.EMPTY){
                Session.DoubleCombo(bclip.style);
            }
        }

        dtrack.PlayNext();
        btrack.PlayNext();
        strack.PlayNext();
    }


}
