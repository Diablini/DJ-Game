package com.djgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Mixer extends Group {
    private int drum, bass, synth;

    Mixer()
    {
        Texture mtrack = new Texture(Gdx.files.internal("mixer-1.png"));
        Texture knob = new Texture(Gdx.files.internal("mixer-knob.png"));
        TextureRegion mtrackreg = new TextureRegion(mtrack);
        TextureRegion knobreg = new TextureRegion(knob);

        Image dtrack = new Image(mtrackreg);
        Image btrack = new Image(mtrackreg);
        Image strack = new Image(mtrackreg);
        Image dknob = new Image(knobreg);
        Image bknob = new Image(knobreg);
        Image sknob = new Image(knobreg);

        bknob.setX(Constants.knoboffset);
        sknob.setX(Constants.knoboffset * 2);

        dtrack.setPosition(Constants.mixertrackx, Constants.mixertracky);
        btrack.setPosition(Constants.mixertrackx + Constants.mixeroffset, Constants.mixertracky);
        strack.setPosition(Constants.mixertrackx + Constants.mixeroffset * 2,
                Constants.mixertracky);

        addActor(dtrack);
        addActor(btrack);
        addActor(strack);
        addActor(dknob);
        addActor(bknob);
        addActor(sknob);
    }

}
