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
    public static final float titlewidth = 260f;
    public static final float titleheight = 26f;
    public static final float textoffsetx = 20f;
    public static final float textoffsety = 65f;
    public static final float textwidth = 260f;
    public static final float textheight = 70f;
    public static final float ftextoffsetx = 20f;
    public static final float ftextoffsety = 16f;
    public static final float ftextwidth = 260f;
    public static final float ftextheight = 25f;
    public static final float typeoffsetx = 180f;
    public static final float typeoffsety = 150f;
    public static final float typewidth = 100f;
    public static final float typeheight = 21f;
    public static final float rarityoffestx = 20f;
    public static final float rarityoffsety = 150f;
    public static final float raritywidth = 100f;
    public static final float rarityheight = 21f;
    public static final float costoffsetx = 60f;
    public static final float costoffsety = 150f;
    public static final float costwidth = 0f;
    public static final float costheight = 0f;

    // card when shuffling to hand
    public static final float shufflescalex = 0.05f;
    public static final float shufflescaley = 0.05f;

    // card when zoomed
    public static final float hoveroffsetx = 0f;
    public static final float hoveroffsety = 30f;

    // card action durations
    public static final float enlargeduration = 0.1f;
    public static final float shuffleduration = 0.2f;

    // card font scaling
    public static final float cardtitlefontscale = 0.85f;
    public static final float carddescfontscale = 0.50f;
    public static final float cardflavfontscale = 0.35f;
    public static final float cardtypefontscale = 0.4f;
    public static final float cardrarityfontscale = 0.4f;

    // ui font scaling
    public static final float uilabelfontscale = 0.6f;
    public static final float uimixbonusfontscale = 0.35f;

    // card play line
    public static final float cardplayliney = 500f;

    // positions of UI elements
    public static final float backgroundx = 0f;
    public static final float backgroundy = 0f;
    public static final float cardfanx = 0f;
    public static final float cardfany = 170f;
    public static final float topplatex = 0f;
    public static final float topplatey = 0f;
    public static final float drawpilex = 65f;
    public static final float drawpiley = 370f;
    public static final float discardpilex = 1805f;
    public static final float discardpiley = 370f;
    public static final float tracksx = 40f;
    public static final float tracksy = 40f;
    public static final float mixerx = 1645f;
    public static final float mixery = 40f;
    public static final float timerx = 620f;
    public static final float timery = 1010f;
    public static final float inspirationx = 810f;
    public static final float inspirationy = 1010f;
    public static final float crowdpointsx = 1230f;
    public static final float crowdpointsy = 1000f;
    public static final float mixpowerx = 1820f;
    public static final float mixpowery = 15f;
    public static final float hpx = 990f;
    public static final float hpy = 1010f;
    public static final float choosepromptx = 0f;
    public static final float chooseprompty = 850f;
    public static final float choosepromptwidth = 1920f;
    public static final float choosepromptheight = 100f;
    public static final float endturnbuttonx = 885f;
    public static final float endturnbuttony = 0f;

    // mixer stuff
    public static final float knoboffsetx = -20f;
    public static final float knoboffsety = 0f;
    public static final float mixeroffset = 65f;
    public static final float mixertrackx = 62f;
    public static final float mixertracky = 40f;
    public static final float mixtracklength = 330f;
    public static final float bonusleftoffsetx = -120f;
    public static final float bonusrightoffsetx = 45f;
    public static final float bonusoffsety = -12f;
    public static final float bonustextwidth = 95f;
    public static final float bonustextheight = 60f;

    // track stuff
    public static final float trackoffsetx = 90f;
    public static final float clipoffsetx = 5f;
    public static final float clipoffsety = 75f;
    public static final float clipmargin = 60f;

    // drawpile stuff
    public static final float cardnumberoffsetx = 60f;
    public static final float cardnumberoffsety = 30f;

    // CardListView stuff
    public static final float listviewwidth = 1000f;
    public static final float listviewheight = 800f;
    public static final float listviewcolumnpad = 40f;
    public static final float listviewrowpad = 40f;
    public static final float listviewcardscale = 2f/3f;

    // vinyl
    public static final float vinylscale = 1f;
    public static final float vinylx = 220f;
    public static final float vinyly = -920f;
    public static final float vinylspinrate = 0.25f;
    public static final float vinylspinbonus = 0.5f;


    // Z-index Constants
    // < 1000 Background
    // < 2000 Middle
    // < 3000 Foreground

    public static final int zbackground = 0;
    public static final int zvinyl = 1;
    public static final int ztopplate = 2;
    public static final int zgenericbutton = 3;
    public static final int zinspiration = 4;
    public static final int zcrowd = 5;
    public static final int ztimer = 6;
    public static final int zmixer = 7;
    public static final int zmixpower = 8;
    public static final int zhp = 9;
    public static final int ztracks = 10;
    public static final int zdrawpile = 11;
    public static final int zdiscardpile = 12;
    public static final int zchooseprompt = 13;
    public static final int zcardfan = 14;



    public static final int zcardzoomed = 2500;


    //----------------------------------------------------------//
    //------------- Game logic ---------------------------------//
    //----------------------------------------------------------//

    // Levels
    public static final int maxstages = 10;
    public static final int maxrewards = 3;

    // Session
    public static final int roundlimit = 20;
    public static final int drawperturn = 6;
    public static final int startinghp = 3;
    public static final int maxhp = 3;
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
    public static final Color activatedbonuscolor = Color.valueOf("CB904DFF");
    public static final Color carddarkcolor = Color.valueOf("000000FF");
    public static final Color cardlightcolor = Color.valueOf("DADADAFF");
    // Fonts
    public static Fonts fonts = new Fonts();
}
