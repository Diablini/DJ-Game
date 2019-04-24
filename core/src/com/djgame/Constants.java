package com.djgame;

import com.badlogic.gdx.graphics.Color;

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
    public static final float costoffsetx = 15f;
    public static final float costoffsety = 374f;
    public static final float costwidth = 20f;
    public static final float costheight = 26f;

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
    public static final float tracksy = 600f;
    public static final float mixerx = 1200f;
    public static final float mixery = 550f;
    public static final float timerx = 900f;
    public static final float timery = 1000f;
    public static final float inspirationx = 60f;
    public static final float inspirationy = 250f;
    public static final float crowdpointsx = 500f;
    public static final float crowdpointsy = 1000f;
    public static final float mixpowerx = 1200f;
    public static final float mixpowery = 350f;
    public static final float hpx = 1300f;
    public static final float hpy = 1000f;
    public static final float choosepromptx = 700f;
    public static final float chooseprompty = 400f;
    public static final float endturnbuttonx = 1500f;
    public static final float endturnbuttony = 200f;

    // mixer stuff
    public static final float knoboffsetx = -64f;
    public static final float knoboffsety = -40f;
    public static final float mixeroffset = 100f;
    public static final float mixertrackx = 62f;
    public static final float mixertracky = 40f;
    public static final float mixtracklength = 380f;
    public static final float upbuttonoffsetx = -20f;
    public static final float upbuttonoffsety = 350f;
    public static final float downbuttonoffsetx = -20f;
    public static final float downbuttonoffsety = -100f;
    public static final float bonusleftoffsetx = -30f;
    public static final float bonusrightoffsetx = 60f;
    public static final float bonusoffsety = 20f;

    // track stuff
    public static final float trackoffsetx = 100f;
    public static final float clipoffsetx = 5;
    public static final float clipoffsety = 75;
    public static final float clipmargin = 60;

    // drawpile stuff
    public static final float cardnumberoffsetx = 60f;
    public static final float cardnumberoffsety = 30f;


    // Z-index Constants
    // < 1000 Background
    // < 2000 Middle
    // < 3000 Foreground

    public static final int zbackground = 0;

    public static final int zgenericbutton = 0;
    public static final int zinspiration = 1;
    public static final int zcrowd = 2;
    public static final int ztimer = 3;
    public static final int zmixer = 4;
    public static final int zmixpower = 5;
    public static final int zhp = 6;
    public static final int ztracks = 7;
    public static final int zdrawpile = 8;
    public static final int zdiscardpile = 9;
    public static final int zchooseprompt = 10;
    public static final int zcardfan = 11;



    public static final int zcardzoomed = 2500;


    //----------------------------------------------------------//
    //------------- Game logic ---------------------------------//
    //----------------------------------------------------------//

    // Session
    public static final int roundlimit = 10;
    public static final int drawperturn = 5;
    public static final int startinghp = 3;
    public static final int inspirationperturn = 6;
    public static final int mixpowerperturn = 1;

    // Tracks
    public static final int dtracksize = 4;
    public static final int btracksize = 4;
    public static final int stracksize = 4;

    // Mixer
    public static final int mixernumofpositions = 4;


    // Card Effect Related

    public static final int baseclippoints = 10;
    public static final int basetwocombo = 10;
    public static final int basethreecombo = 30;
    public static final int basecombomultiplier = 1;

    // Powers
    public static final int maxpowerduration = 100;

    // Colors
    public static final Color activatedbonuscolor = Color.GREEN;
}
