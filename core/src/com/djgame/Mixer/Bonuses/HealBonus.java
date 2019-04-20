package com.djgame.Mixer.Bonuses;

import com.djgame.Mixer.MixerBonus;
import com.djgame.Session;

public class HealBonus extends MixerBonus {
    public HealBonus(){
        text.setText("+1 HP");
    }

    @Override
    public void Play() {
        if (activated) return;
        Session.State.setHp(Session.State.getHp() + 1);
        Session.RefreshUI();
        Activate();
    }
}
