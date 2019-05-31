package com.djgame.Levels.Rewards;

import com.badlogic.gdx.Screen;
import com.djgame.Levels.LevelReward;
import com.djgame.Screens.MainGame;
import com.djgame.Screens.RemoveCardsScreen;

public class RemoveCard extends LevelReward {

    public int toremove;

    public RemoveCard(MainGame game, int howmany)
    {
        super(game);
        toremove = howmany;
        cost = 50;
    }

    @Override
    public LevelReward clone() {
        RemoveCard c = new RemoveCard(game,toremove);
        return c;
    }

    @Override
    public String getText() {
        if (toremove > 1)
        {
            return "Remove " + toremove + " cards";
        }
        return "Remove " + toremove + " card";
    }

    @Override
    public Screen Claim() {
        Screen screen = new RemoveCardsScreen(game, toremove);

        return screen;
    }
}
