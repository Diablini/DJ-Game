package com.djgame.Mixer.Bonuses;

import com.djgame.Mixer.MixerBonus;
import com.djgame.Power;
import com.djgame.Session;

public class DoubleComboBonus extends MixerBonus {
    public DoubleComboBonus(){
        text.setText("Combos earn double this turn");
    }

    @Override
    public void Play() {
        if (activated) return;

        class DoubleComboPower extends Power {
            @Override
            public void Play() {
                Session.State.combomultiplierbonus++;
                duration--;
            }
            @Override
            public void Expire() {
                Session.State.combomultiplierbonus--;
            }
        }

        DoubleComboPower p = new DoubleComboPower();
        p.duration = 1;
        p.priority = 1;
        Session.State.powers.AddAfter(p);

        Session.RefreshUI();
        Activate();
    }
}
