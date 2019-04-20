package com.djgame.Mixer.Bonuses;

import com.djgame.Mixer.MixerBonus;
import com.djgame.Session;

public class InspirationBonus extends MixerBonus {
    public InspirationBonus(){
        text.setText("+2 Inspiration");
    }

    @Override
    public void Play() {
        if (activated) return;
        Session.State.setInspiration(Session.State.getInspiration() + 2);
        Session.RefreshUI();
        Activate();
    }
}
