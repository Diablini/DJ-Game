package com.djgame.Tracks;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.djgame.Constants;
import com.djgame.Session;

import java.util.Vector;

public class Track extends Group {
    private TrackPlaylist trackPlaylist;
    Vector<Clip> clips;
    private int maxsize;
    private Image img;



    Track(TrackPlaylist trackPlaylist, int size, TextureRegion reg){
        this.trackPlaylist = trackPlaylist;
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
