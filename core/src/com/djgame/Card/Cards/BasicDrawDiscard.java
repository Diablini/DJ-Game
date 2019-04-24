package com.djgame.Card.Cards;

import com.djgame.Card.Card2d;

public class BasicDrawDiscard extends Card2d {
    public BasicDrawDiscard(){
        //super.picreg
        super.ttext = "Hip Hop Bass";
        super.dtext = "+1 Bass\nSpecial: Add from bottom";
        super.ftext = "Drop it";
        basecost = 1;

        UpdateAssets();
    }
}
