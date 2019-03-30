package com.djgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Mixer extends Group {

    Mixer()
    {
        Texture mtracks = new Texture(Gdx.files.internal("mixer-tracks.png"));
        Texture knob = new Texture(Gdx.files.internal("mixer-knob.png"));
        TextureRegion mtracksreg = new TextureRegion(mtracks);
        TextureRegion knobreg = new TextureRegion(knob);

        Image tracks = new Image(mtracksreg);
        Image dknob = new Image(knobreg);
        Image bknob = new Image(knobreg);
        Image sknob = new Image(knobreg);

        bknob.setX(Constants.knoboffset);
        sknob.setX(Constants.knoboffset * 2);

        addActor(tracks);
        addActor(dknob);
        addActor(bknob);
        addActor(sknob);
    }

}
