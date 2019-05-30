package com.djgame.Levels;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.djgame.Constants;
import com.djgame.Screens.MainGame;

import java.util.Vector;


public class Level extends Group {
    private MainGame game;
    public int targetpoints, turns;
    public Vector<LevelReward> rewards;



    public Level(MainGame game, int turns, int targetpoints, Vector<LevelReward> rewards)
    {
        this.game = game;
        this.turns = turns;
        this.rewards = rewards;
        this.targetpoints = targetpoints;

        Texture icontex = game.assets.manager.get("encore.jpg", Texture.class);
        TextureRegion iconreg = new TextureRegion(icontex);
        Image icon = new Image(iconreg);
        addActor(icon);

        float ydist = -60f;
        float basey = -30f;

        Label.LabelStyle style = new Label.LabelStyle(Constants.fonts.uilabel, Color.WHITE);
        Label pointslabel = new Label("Score " + targetpoints + " points in " + turns +
                " turns", style);
        Label rewardseparator = new Label("Rewards: ", style);
        addActor(pointslabel);
        addActor(rewardseparator);

        pointslabel.setPosition(0, basey + ydist);
        rewardseparator.setPosition(0,  basey + (ydist * 2));
        pointslabel.setFontScale(0.75f);
        rewardseparator.setFontScale(0.75f);

        if (rewards != null)
        {
            for (int i = 0; i < rewards.size(); i++)
            {
                Label label = new Label(rewards.get(i).getText(), style);
                addActor(label);
                label.setPosition(0,  basey + ((3 * ydist) + (ydist * i)));
                label.setFontScale(0.75f);
            }
        }


    }

}
