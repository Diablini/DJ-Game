package com.djgame.Levels;

import com.badlogic.gdx.Screen;
import com.djgame.Levels.Rewards.AddXofYAll;
import com.djgame.Levels.Rewards.AddXofYCommon;
import com.djgame.Levels.Rewards.AddXofYEpic;
import com.djgame.Levels.Rewards.AddXofYMusic;
import com.djgame.Levels.Rewards.AddXofYPower;
import com.djgame.Levels.Rewards.AddXofYRare;
import com.djgame.Levels.Rewards.AddXofYSupport;
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
        AddXofYCommon oneofthreecommon = new AddXofYCommon(game, 1, 3);
        AddXofYRare oneofthreerare = new AddXofYRare(game, 1, 3);
        AddXofYEpic oneofthreeepic = new AddXofYEpic(game, 1, 3);
        AddXofYMusic oneofthreemusic = new AddXofYMusic(game, 1, 3);
        AddXofYSupport oneofthreesupport = new AddXofYSupport(game, 1, 3);
        AddXofYPower oneofthreepower = new AddXofYPower(game, 1, 3);
        RemoveCard removeonecard = new RemoveCard(game, 1);

        rewards.add(oneofthreeall);
        rewards.add(oneofthreecommon);
        rewards.add(oneofthreerare);
        rewards.add(oneofthreeepic);
        rewards.add(oneofthreemusic);
        rewards.add(oneofthreesupport);
        rewards.add(oneofthreepower);
        rewards.add(removeonecard);

        return rewards;
    }
}
