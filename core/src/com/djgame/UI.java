package com.djgame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.djgame.Card.CardFan;
import com.djgame.Card.CardPile;


public class UI extends Group {

    public CardFan cards;
    public CardPile drawpile, discardpile;
    public TrackPlaylist tracks;
    public Mixer mixer;
    public Label rounds;

    UI(){
        setPosition(0,0);
        Label.LabelStyle style = new Label.LabelStyle();
        BitmapFont font = new BitmapFont();
        style.fontColor = Color.BLACK;
        style.font = font;

        cards = new CardFan();
        drawpile = new CardPile();
        discardpile = new CardPile();
        tracks = new TrackPlaylist();
        mixer = new Mixer();
        rounds = new Label("Turns: 0/0",style);



        cards.setZIndex(Constants.zcardinhand);
        drawpile.setZIndex(Constants.zcardinhand);
        drawpile.setPosition(Constants.drawpilex, Constants.drawpiley);
        discardpile.setZIndex(Constants.zcardinhand);
        discardpile.setPosition(Constants.discardpilex, Constants.discardpiley);
        tracks.setZIndex(Constants.ztracks);
        tracks.setPosition(Constants.tracksx, Constants.tracksy);
        mixer.setZIndex(Constants.zmixer);
        mixer.setPosition(Constants.mixerx, Constants.mixery);
        rounds.setZIndex(Constants.ztimer);
        rounds.setPosition(Constants.timerx, Constants.timery);

        //TODO: add ui elements

        addActor(cards);
        addActor(drawpile);
        addActor(discardpile);
        addActor(tracks);
        addActor(mixer);
        addActor(rounds);
        setVisible(true);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawChildren(batch, parentAlpha);
    }
}
