package com.djgame;

public final class Constants {
    private Constants(){
        // no constructor
    }

    // offsets of different card group elements
    public static final float cardscalex = 2f/3f;
    public static final float cardscaley = 2f/3f;
    public static final float cardscalelargex = 1f;
    public static final float cardscalelargey = 1f;
    public static final float picoffsetx = 20f;
    public static final float picoffsety = 171f;
    public static final float titleoffsetx = 20f;
    public static final float titleoffsety = 374f;
    public static final float titleheight = 26f;
    public static final float titlewidth = 260f;
    public static final float textoffsetx = 20f;
    public static final float textoffsety = 55f;
    public static final float textwidth = 260f;
    public static final float textheight = 87f;
    public static final float ftextoffsetx = 20f;
    public static final float ftextoffsety = 20f;
    public static final float ftextwidth = 260f;
    public static final float ftextheight = 25f;

    // card when shuffling to hand
    public static final float shufflescalex = 0.05f;
    public static final float shufflescaley = 0.05f;

    // card when zoomed
    public static final float hoveroffsetx = 0f;
    public static final float hoveroffsety = 30f;

    // card action durations
    public static final float enlargeduration = 0.1f;
    public static final float shuffleduration = 0.25f;


    // positions of UI elements
    public static final float drawpilex = 50f;
    public static final float drawpiley = 50f;
    public static final float discardpilex = 1700f;
    public static final float discardpiley = 50f;
    public static final float tracksx = 300f;
    public static final float tracksy = 400f;
    public static final float mixerx = 1200f;
    public static final float mixery = 400f;

    // mixer stuff
    public static final float knobscalex = 0.5f;
    public static final float knobscaley = 0.5f;
    public static final float knoboffset = 91f;

    // Z-index Constants
    // < 1000 Background
    // < 2000 Middle
    // < 3000 Foreground

    public static final int zbackground = 900;

    public static final int zgenericbutton = 1300;
    public static final int ztracks = 1401;
    public static final int zmixer = 1400;
    public static final int zcardinhand = 1500;
    public static final int zdrawpile = 1600;
    public static final int zdiscardpile = 1601;

    public static final int zcardzoomed = 2500;

}
