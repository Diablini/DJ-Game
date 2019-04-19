package com.djgame.Mixer.Bonuses;

import com.djgame.Mixer.MixerBonus;
import com.djgame.Session;

public class DrawBonus extends MixerBonus {
    public DrawBonus(){
        text.setText("Draw 1 Card");
    }

    @Override
    public void Play() {
        if (activated) return;
        Session.DrawCard();
        Session.RefreshUI();
        activated = true;
    }
}
