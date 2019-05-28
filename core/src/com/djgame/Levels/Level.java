package com.djgame.Levels;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.djgame.Screens.MainGame;


public class Level extends Group {
    private MainGame game;
    public int targetpoints;



    public Level(MainGame game)
    {
        this.game = game;
    }

}
