package com.djgame.Levels;

import com.badlogic.gdx.Screen;
import com.djgame.Screens.MainGame;

public class LevelReward {
    protected MainGame game;
    public int cost;

    public LevelReward(MainGame game)
    {
        this.game = game;
        cost = 0;
    }

    public String getText()
    {
        return "Reward Text";
    }

    public Screen Claim()
    {
        return null;
    }
}
