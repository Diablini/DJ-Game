package com.djgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TrackPlaylist extends Group {

    TrackPlaylist (){
        Texture tracktex = new Texture(Gdx.files.internal("tracks-1.png"));
        TextureRegion trackreg = new TextureRegion(tracktex);
        Image trackimg = new Image(trackreg);




        addActor(trackimg);
    }

}
