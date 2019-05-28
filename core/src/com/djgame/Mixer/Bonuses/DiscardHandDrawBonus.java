package com.djgame.Mixer.Bonuses;

import com.djgame.Mixer.MixerBonus;
import com.djgame.Session;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;

public class DiscardHandDrawBonus extends MixerBonus {
    public DiscardHandDrawBonus()
    {
        text.setText("Discard hand, draw new hand");
    }

    @Override
    public void Play() {
        if (activated) return;

        int cardnum = Session.State.getui().cards.cards.size();

        for (int i = 0; i < cardnum; i++)
        {
            Session.DiscardNoPlay(Session.State.getui().cards.getFirstCard());
        }

        for (int i = 0; i < cardnum; i++)
        {
            Session.DrawCard();
        }


        Session.RefreshUI();
        Activate();
    }
}
