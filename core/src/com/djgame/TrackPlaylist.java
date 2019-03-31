package com.djgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.Vector;

public class TrackPlaylist extends Group {

    enum SongStyle{
        HIPHOP,
        TRAP,
        HOUSE
    }

    private class Track{
        private class Clip{
            SongStyle style;
            int crowdpoints;
        }
        private int size;

        Track(int size){
            this.size = size;
        }

        Vector<Clip> clips;
    }

    private Track dtrack, btrack, strack;

    TrackPlaylist (){
        Texture tracktex = new Texture(Gdx.files.internal("tracks-1.png"));
        TextureRegion trackreg = new TextureRegion(tracktex);
        Image trackimg = new Image(trackreg);

        dtrack = new Track(Constants.dtracksize);
        btrack = new Track(Constants.btracksize);
        strack = new Track(Constants.stracksize);


        addActor(trackimg);
    }

}
