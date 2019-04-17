package com.djgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.Vector;

public class TrackPlaylist extends Group {

    enum TrackType{
        DRUM,
        BASS,
        SYNTH
    }

    enum SongStyle{
        HIPHOP,
        TRAP,
        HOUSE
    }

    private class Track{
        Vector<Clip> clips;
        private int maxsize;

        private class Clip{
            SongStyle style;
            int crowdpoints;
        }

        Track(int size){
            this.maxsize = size;
        }

        public void InsertTop(Clip clip){
            if (clips.size() >= maxsize){
                // TODO: handle what happens if track is full
            }
            else{
                clips.add(clip);
            }
        }

        public void InsertBottom(Clip clip){
            if (clips.size() >= maxsize){
                // TODO: handle
            }
            else{
                clips.add(0, clip);
            }
        }

        public Clip GetNext(){
            if (clips.isEmpty()){return null;}
            return clips.get(0);
        }

        public boolean PlayNext(){
            if (clips.isEmpty()){
                return false;
            }
            clips.remove(0);
            return true;
        }

    }

    private Track dtrack, btrack, strack;

    TrackPlaylist (){
        Texture tracktexd = new Texture(Gdx.files.internal("track-1.png"));
        Texture tracktexb = new Texture(Gdx.files.internal("track-2.png"));
        Texture tracktexs = new Texture(Gdx.files.internal("track-3.png"));
        TextureRegion trackregd = new TextureRegion(tracktexd);
        TextureRegion trackregb = new TextureRegion(tracktexb);
        TextureRegion trackregs = new TextureRegion(tracktexs);
        Image trackd = new Image(trackregd);
        Image trackb = new Image(trackregb);
        Image tracks = new Image(trackregs);

        dtrack = new Track(Constants.dtracksize);
        btrack = new Track(Constants.btracksize);
        strack = new Track(Constants.stracksize);

        trackb.setPosition(Constants.trackoffsetx,0);
        tracks.setPosition(Constants.trackoffsetx * 2, 0);


        addActor(trackd);
        addActor(trackb);
        addActor(tracks);

    }

    public void PlayTracks(boolean d, boolean b, boolean s){
        // play requested tracks
        Track.Clip dclip,bclip,sclip;
        if (d){
            if (dtrack.clips.isEmpty()){Session.EmptyTrack(TrackType.DRUM);}
            dclip = dtrack.GetNext();
            dtrack.PlayNext();
        }

        if (b){
            if (btrack.clips.isEmpty()){Session.EmptyTrack(TrackType.BASS);}
            bclip = btrack.GetNext();
            btrack.PlayNext();
        }

        if (s){
            if (strack.clips.isEmpty()){Session.EmptyTrack(TrackType.SYNTH);}
            sclip = strack.GetNext();
            strack.PlayNext();
        }
        // TODO: check for matches
    }


}
