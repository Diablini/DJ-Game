package com.djgame.Card;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.TimeUtils;
import com.djgame.Constants;

import java.util.Vector;

public class CardPile extends Group {

    private Vector<Card2d> cards;

    public CardPile(){
        cards = new Vector<Card2d>();
        BitmapFont font = new BitmapFont();
        Label.LabelStyle style = new Label.LabelStyle(font, Color.BLACK);
        Label img = new Label("Draw Deck", style);
        img.setFontScale(2.5f);

        addActor(img);
    }

    public boolean HasCards(){
        return (cards.size() != 0);
    }

    public int Size(){
        return cards.size();
    }

    public void AddCard(Card2d card){
        cards.add(card);
    }

    public void AddCardRand(Card2d card){
        RandomXS128 rand = new RandomXS128();
        rand.setSeed(TimeUtils.nanoTime());
        cards.add(rand.nextInt(cards.size()), card);
    }

    public Card2d DrawCard(){
        if (cards.size() == 0) return null;
        Card2d card = cards.lastElement();
        cards.remove(cards.size() - 1);
        card.setPosition(getX(),getY());
        card.setScale(Constants.shufflescalex, Constants.shufflescaley);
        return card;
    }

    public void Shuffle(){
        RandomXS128 rand = new RandomXS128();
        Card2d swap;
        for (int i = 0; i < cards.size(); i++){
            int index = rand.nextInt(cards.size());
            swap = cards.get(i);
            cards.setElementAt(cards.get(index), i);
            cards.setElementAt(swap, index);
        }
    }
}
