package com.djgame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;


public class UI extends Group {

    public CardFan cards;

    UI(){
        setPosition(0,0);
        cards = new CardFan();

        //TODO: add ui elements

        addActor(cards);
        setVisible(true);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawChildren(batch, parentAlpha);
    }
}
