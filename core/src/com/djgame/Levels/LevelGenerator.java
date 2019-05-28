package com.djgame.Levels;


import com.djgame.Screens.MainGame;

public class LevelGenerator {
    private MainGame game;

    public static int[] targetpointaverages = new int [] {
            0, // 1 Turn
            30, // 2 Turns
            120, // 3 Turns
            210, // 4 Turns
            330, // 5 Turns
            480, // 6 Turns
            790, // 7 Turns
            1000, // 8 Turns
            1270, // 9 Turns
            1460, // 10 Turns
            1670, // 11 Turns
            2000, // 12 Turns
            2450, // 13 Turns
            2800, // 14 Turns
            3100, // 15 Turns
            3430, // 16 Turns
            3790, // 17 Turns
            4500, // 18 Turns
            5500, // 19 Turns
            7000, // 20 Turns
    };

    public static float[] difficultycoef = new float [] {
            0.5f, // Stage 1
            0.6f, // Stage 2
            0.7f, // Stage 3
            0.8f, // Stage 4
            0.9f, // Stage 5
            1f,   // Stage 6
            1.1f, // Stage 7
            1.2f, // Stage 8
            1.3f, // Stage 9
            1.5f, // Stage 10
    };


    public LevelGenerator(MainGame game)
    {
        this.game = game;
    }

    public Level generate(int stage, int turns)
    {
        Level l = new Level(game);
        l.targetpoints = (int)((targetpointaverages[turns - 1] * difficultycoef[stage - 1])
                /10) * 10;

        return l;
    }
}
