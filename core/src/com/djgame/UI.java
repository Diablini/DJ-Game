package com.djgame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.djgame.Card.CardFan;
import com.djgame.Card.CardPile;
import com.djgame.Mixer.Mixer;


public class UI extends Group {

    public CardFan cards;
    public CardPile drawpile, discardpile;
    public TrackPlaylist tracks;
    public Mixer mixer;
    public Label rounds, inspiration, crowd, mixpower;

    UI(){
        setPosition(0,0);
        Label.LabelStyle style = new Label.LabelStyle();
        BitmapFont font = new BitmapFont();
        style.fontColor = Color.WHITE;
        style.font = font;

        cards = new CardFan();
        drawpile = new CardPile();
        discardpile = new CardPile();
        tracks = new TrackPlaylist();
        mixer = new Mixer();
        rounds = new Label("Turns: 0/0",style);
        inspiration = new Label("Inspiration: 0/0", style);
        crowd = new Label("Crowd Points: ", style);
        mixpower = new Label("Mix Power: 0", style);


        rounds.setFontScale(2.5f);
        inspiration.setFontScale(2.5f);
        crowd.setFontScale(2.5f);
        mixpower.setFontScale(2.5f);

        drawpile.Rename("Draw");
        discardpile.Rename("Discard");



        //TODO: add ui elements

        addActor(cards);
        addActor(drawpile);
        addActor(discardpile);
        addActor(tracks);
        addActor(mixer);
        addActor(rounds);
        addActor(inspiration);
        addActor(crowd);
        addActor(mixpower);
        setVisible(true);

        cards.setZIndex(Constants.zcardfan);
        drawpile.setZIndex(Constants.zdrawpile);
        drawpile.setPosition(Constants.drawpilex, Constants.drawpiley);
        discardpile.setZIndex(Constants.zdiscardpile);
        discardpile.setPosition(Constants.discardpilex, Constants.discardpiley);
        tracks.setZIndex(Constants.ztracks);
        tracks.setPosition(Constants.tracksx, Constants.tracksy);
        mixer.setZIndex(Constants.zmixer);
        mixer.setPosition(Constants.mixerx, Constants.mixery);
        rounds.setZIndex(Constants.ztimer);
        rounds.setPosition(Constants.timerx, Constants.timery);
        inspiration.setZIndex(Constants.zinspiration);
        inspiration.setPosition(Constants.inspirationx, Constants.inspirationy);
        crowd.setZIndex(Constants.zcrowd);
        crowd.setPosition(Constants.crowdpointsx, Constants.crowdpointsy);
        mixpower.setZIndex(Constants.zmixpower);
        mixpower.setPosition(Constants.mixpowerx, Constants.mixpowery);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawChildren(batch, parentAlpha);
    }
}
