package com.djgame.Levels;

import com.badlogic.gdx.Screen;
import com.djgame.Levels.Rewards.AddXofYAll;
import com.djgame.Levels.Rewards.RemoveCard;
import com.djgame.Screens.ChooseLevelScreen;
import com.djgame.Screens.MainGame;

import java.util.Vector;

public class LevelReward {
    protected MainGame game;
    public float cost;

    public LevelReward(MainGame game)
    {
        this.game = game;
        cost = 0;
    }

    public LevelReward clone()
    {
        LevelReward c = new LevelReward(game);
        return c;
    }

    public String getText()
    {
        return "Reward Text";
    }

    public void EndReward()
    {
        if (game.PendingRewards())
        {
            game.ClaimReward();
        }
        else
        {
            game.levelstage++;
            game.setScreen(new ChooseLevelScreen(game, game.levelstage));
        }
    }

    public Screen Claim()
    {
        return null;
    }

    public static Vector<LevelReward> getAllRewards(MainGame game)
    {
        Vector<LevelReward> rewards = new Vector<LevelReward>();

        AddXofYAll oneofthreeall = new AddXofYAll(game, 1, 3);
        RemoveCard removeonecard = new RemoveCard(game, 1);

        rewards.add(oneofthreeall);
        rewards.add(removeonecard);

        return rewards;
    }
}
