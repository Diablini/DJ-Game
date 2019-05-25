package com.djgame.Mixer.Bonuses;

import com.djgame.Mixer.MixerBonus;
import com.djgame.Powers.Power;
import com.djgame.Session;

public class DrawNextBonus extends MixerBonus {
    public DrawNextBonus(){text.setText("Draw 2 cards next turn");}

    @Override
    public void Play() {
        Power power = new Power() {
            @Override
            public void Play() {
                Session.DrawCard();
                Session.DrawCard();
                duration = 0;
            }

            @Override
            public void Expire() {
            }
        };
        power.duration = 1;
        power.priority = 0;

        Session.State.powers.AddBefore(power);
        Session.RefreshUI();
        Activate();
    }
}
