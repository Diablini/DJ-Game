package com.djgame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;


public class UI extends Group {

    public CardFan cards;
    public CardPile drawpile, discardpile;
    public TrackPlaylist tracks;

    UI(){
        setPosition(0,0);
        cards = new CardFan();
        drawpile = new CardPile();
        discardpile = new CardPile();
        tracks = new TrackPlaylist();



        cards.setZIndex(Constants.zcardinhand);
        drawpile.setZIndex(Constants.zcardinhand);
        drawpile.setPosition(Constants.drawpilex, Constants.drawpiley);
        discardpile.setZIndex(Constants.zcardinhand);
        discardpile.setPosition(Constants.discardpilex, Constants.discardpiley);
        tracks.setZIndex(Constants.ztracks);
        tracks.setPosition(Constants.tracksx, Constants.tracksy);

        //TODO: add ui elements

        addActor(cards);
        addActor(drawpile);
        addActor(discardpile);
        addActor(tracks);
        setVisible(true);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawChildren(batch, parentAlpha);
    }
}
