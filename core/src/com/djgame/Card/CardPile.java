package com.djgame.Card;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.TimeUtils;
import com.djgame.Constants;
import com.djgame.Screens.MainGame;

import java.util.Vector;


public class CardPile extends Group {

    private Vector<Card2d> cards;
    private Label img;
    private Label counter;
    private MainGame game;

    public CardPile(MainGame game){
        this.game = game;
        cards = new Vector<Card2d>();
        BitmapFont font = Constants.fonts.uilabel;
        Label.LabelStyle style = new Label.LabelStyle(font, Constants.cardlightcolor);
        img = new Label("Draw Deck", style);
        counter = new Label("0", style);
        img.setFontScale(2.5f);
        counter.setFontScale(Constants.uilabelfontscale);
        //counter.setAlignment(Align.center, Align.center);
        counter.setPosition(Constants.cardnumberoffsetx, Constants.cardnumberoffsety);

        //addActor(img);
        addActor(counter);
    }

    public CardPile(CardPile cpy, MainGame game){
        this(game);
        for (int i = 0; i < cpy.cards.size(); i++)
        {
            Card2d c = cpy.cards.get(i).clone();
            cards.add(c);
        }
    }

    public void Copy(CardPile cpy)
    {
        for (int i = 0; i < cpy.cards.size(); i++)
        {
            Card2d c = cpy.cards.get(i).clone();
            AddCard(c);
        }
    }

    public boolean HasCards(){
        return (cards.size() != 0);
    }

    public Card2d Get(int i){
        if (i >= cards.size()) return null;
        return cards.get(i);
    }

    public int Size(){
        return cards.size();
    }

    public void AddCard(Card2d card){
        cards.add(card);
        UpdateNumber();
    }

    public void AddCardRand(Card2d card){
        RandomXS128 rand = new RandomXS128();
        rand.setSeed(TimeUtils.nanoTime());
        rand.setSeed(TimeUtils.nanoTime());
        cards.add(rand.nextInt(cards.size()), card);
        UpdateNumber();
    }

    public Card2d DrawCard(){
        if (cards.size() == 0) return null;
        Card2d card = cards.lastElement();
        cards.remove(cards.size() - 1);
        card.setPosition(getX(),getY());
        card.setScale(Constants.shufflescalex, Constants.shufflescaley);
        UpdateNumber();
        return card;
    }

    public void Shuffle(){
        RandomXS128 rand = new RandomXS128();
        rand.setSeed(TimeUtils.nanoTime());
        Card2d swap;
        for (int i = 0; i < cards.size(); i++){
            int index = rand.nextInt(cards.size());
            swap = cards.get(i);
            cards.setElementAt(cards.get(index), i);
            cards.setElementAt(swap, index);
        }
    }

    public void Rename(String newname){
        img.setText(newname);
    }

    public void UpdateNumber(){
        counter.setText(cards.size());
    }

    public void UpdateCards(){
        for (int i = 0; i < cards.size(); i++)
        {
            cards.get(i).UpdateAssets();
        }
    }
}
