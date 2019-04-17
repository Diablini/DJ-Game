package com.djgame.Card.Cards;

import com.djgame.Card.Card2d;
import com.djgame.Session;

public class BasicDrum extends Card2d {

    public BasicDrum(){
        //super.picreg
        super.ttext = "Basic Drum";
        super.dtext = "2 Drums to top of drum track\nSpecial: 2 Drums to bottom of drum track";
        super.ftext = "Badum tish";

        UpdateAssets();
    }

    public BasicDrum(float x, float y, float angle, float scalex, float scaley){
        //super.ttext = "Basic Drum";
        super.dtext = "2 Drums to top of drum track\nSpecial: 2 Drums to bottom of drum track";
        super.ftext = "Badum tish";

        UpdateAssets();
    }

    @Override
    public boolean Play() {
        return super.Play();
    }

    @Override
    public boolean PlaySpecial() {
        return super.PlaySpecial();
    }
}
