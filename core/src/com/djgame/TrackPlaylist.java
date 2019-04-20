package com.djgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;

import java.util.Vector;

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

    public class Clip{

        public SongStyle style;
        public int crowdpoints;
        public Image img;

        public Clip()
        {
            style = SongStyle.EMPTY;
        }
    }

    public class Track extends Group{
        Vector<Clip> clips;
        private int maxsize;
        private Image img;



        Track(int size, TextureRegion reg){
            clips = new Vector<Clip>();
            this.maxsize = size;
            this.img = new Image(reg);
            addActor(img);
        }

        public void InsertTop(Clip clip){
            if (clips.size() >= maxsize){
                // TODO: handle what happens if track is full
            }
            else{
                clips.add(clip);
                clip.img.setZIndex(5000);
                addActor(clip.img);
                realign();
            }
        }

        public void InsertBottom(Clip clip){
            if (clips.size() >= maxsize){
                // TODO: handle
            }
            else{
                clips.add(0, clip);
                addActor(clip.img);
                realign();
            }
        }

        public Clip GetNext(){
            if (clips.isEmpty()){ return new Clip(); }
            return clips.get(0);
        }

        public boolean PlayNext(){
            if (clips.isEmpty()){
                return false;
            }
            removeActor(clips.get(0).img);
            Session.SingleCombo(clips.get(0));
            clips.remove(0);
            realign();
            return true;
        }

        public void realign(){
            for (int i = 0; i < clips.size(); i++){
                clips.get(i).img.setPosition(Constants.clipoffsetx,
                        Constants.clipoffsety + i*Constants.clipmargin);
            }
        }

    }

    public Track dtrack, btrack, strack;

    TrackPlaylist (){
        Texture tracktexd = new Texture(Gdx.files.internal("track-1.png"));
        Texture tracktexb = new Texture(Gdx.files.internal("track-2.png"));
        Texture tracktexs = new Texture(Gdx.files.internal("track-3.png"));
        TextureRegion trackregd = new TextureRegion(tracktexd);
        TextureRegion trackregb = new TextureRegion(tracktexb);
        TextureRegion trackregs = new TextureRegion(tracktexs);

        dtrack = new Track(Constants.dtracksize, trackregd);
        btrack = new Track(Constants.btracksize, trackregb);
        strack = new Track(Constants.stracksize, trackregs);

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
