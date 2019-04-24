package com.djgame.Mixer;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.djgame.Constants;

import java.util.Vector;

public class Mixer extends Group {


    public MixerTrack ltrack,rtrack;

    public Mixer()
    {
        ltrack = new MixerTrack();
        rtrack = new MixerTrack();

        ltrack.left = true;
        rtrack.left = false;
        ltrack.setPosition(Constants.mixertrackx, Constants.mixertracky);
        rtrack.setPosition(Constants.mixertrackx + Constants.mixeroffset, Constants.mixertracky);

        addActor(ltrack);
        addActor(rtrack);
    }

    public void ResetBonuses(){
        Vector<MixerBonus> list = MixerBonus.getBonusList();
        ltrack.ResetBonuses(list);
        rtrack.ResetBonuses(list);
    }

}
