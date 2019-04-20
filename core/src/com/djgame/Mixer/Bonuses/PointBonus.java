package com.djgame.Mixer.Bonuses;

import com.djgame.Mixer.MixerBonus;
import com.djgame.Session;

public class PointBonus extends MixerBonus {
    public PointBonus(){
        text.setText("+25 crowd");
    }

    @Override
    public void Play() {
        if (activated) return;
        Session.ScorePoints(25);
        Session.RefreshUI();
        Activate();
    }
}
