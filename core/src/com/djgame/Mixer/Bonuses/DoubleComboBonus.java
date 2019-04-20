package com.djgame.Mixer.Bonuses;

import com.djgame.Mixer.MixerBonus;
import com.djgame.Session;

public class DoubleComboBonus extends MixerBonus {
    public DoubleComboBonus(){
        text.setText("Combos earn double this turn");
    }

    @Override
    public void Play() {
        if (activated) return;
        // TODO: implement
        Session.RefreshUI();
        Activate();
    }
}