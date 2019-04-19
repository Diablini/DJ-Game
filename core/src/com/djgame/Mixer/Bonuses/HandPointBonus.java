package com.djgame.Mixer.Bonuses;

import com.djgame.Mixer.MixerBonus;
import com.djgame.Session;


public class HandPointBonus extends MixerBonus {
    public HandPointBonus(){
        text.setText("+5 crowd per card in hand");
    }

    @Override
    public void Play() {
        if (activated) return;
        Session.ScorePoints(5 * Session.State.getui().cards.cards.size());
        Session.RefreshUI();
        activated = true;
    }
}
