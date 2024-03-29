package com.djgame.Mixer.Bonuses;

import com.djgame.Mixer.MixerBonus;
import com.djgame.Session;

public class PointBonus extends MixerBonus {
    public PointBonus(){
        text.setText("50 points");
    }

    @Override
    public void Play() {
        if (activated) return;
        Session.ScorePoints(50);
        Session.RefreshUI();
        Activate();
    }
}
