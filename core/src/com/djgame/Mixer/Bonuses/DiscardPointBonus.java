package com.djgame.Mixer.Bonuses;

import com.djgame.Mixer.MixerBonus;
import com.djgame.Session;

public class DiscardPointBonus extends MixerBonus {
    public DiscardPointBonus(){
        text.setText("Discard hand +10 crowd per card");
    }

    @Override
    public void Play() {
        if (activated) return;
        while(!Session.State.getui().cards.cards.isEmpty())
        {
            Session.State.getui().cards.RemoveCard(Session.State.getui().cards.getFirstCard());
            Session.ScorePoints(10);
        }
        Session.RefreshUI();
        Activate();
    }
}
