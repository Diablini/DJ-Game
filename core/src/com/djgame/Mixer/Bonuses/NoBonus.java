package com.djgame.Mixer.Bonuses;

import com.djgame.Mixer.MixerBonus;

public class NoBonus extends MixerBonus {
    public NoBonus(){
        text.setText("No bonus");
    }

    @Override
    public void Play() {
    }
}
