package com.djgame.Card;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.djgame.Constants;

import java.lang.Math;
import java.util.Vector;

// Represents cards currently held in the hand
public class CardFan extends Group {

    public class CardSlot{
        public float x, y;
        // relative to x axis
        float angle;

        public CardSlot(float x, float y, float a)
        {
            this.x = x;
            this.y = y;
            angle = a;
        }
    }

    private int centertargetx = 960;
    private int centertargety = 0;
    private int radius = Math.round(centertargetx*1.8f);
    private int minslots = 4;
    private float maxdegrees = 18f;
    private float anglemultiplier = 0.9f;


    public Vector<CardSlot> slots;
    public Vector<Card2d> cards;

    public CardFan() {
        // init Card slots
        slots = new Vector<CardSlot>();
        cards = new Vector<Card2d>();
        resize(minslots);
    }

    public void AddCard(Card2d card){
        cards.add(card);
        addActor(card);
        resize(cards.size());
    }

    public void AddCardAtIndex(Card2d card, int index)
    {
        if (index == 1 && cards.isEmpty())
        {
            AddCard(card);
            return;
        }

        cards.add(index, card);
        addActor(card);
        resize(cards.size());
    }

    public boolean RemoveCard(Card2d card){
        for (int i = 0; i < cards.size(); i++)
        {
            if (cards.get(i) == card){
                removeActor(cards.get(i));
                cards.remove(i);
                resize(cards.size());
                return true;
            }
        }
        return false;
    }

    public Card2d getFirstCard(){
        if (cards.size() == 0) return null;
        return cards.firstElement();
    }

    public int getCardIndex(Card2d card)
    {
        for (int i = 0; i < cards.size(); i++)
        {
            if (cards.get(i) == card) return i;
        }
        return 0;
    }

    public void resize(int n) {
        int numcards = n;
        // handle special cases
        if (n == 0) {return;}
        if (n == 1){
            slots.clear();
            CardSlot s = new CardSlot(centertargetx - 150,centertargety, 0);
            slots.add(s);
            cards.get(0).Shuffle(slots.get(0).x, slots.get(0).y, slots.get(0).angle);
            return;
        }
        if (n == 4){n = 6;}
        if (n == 3){n = 5;}
        if (n == 2){n = 4;}

        if (numcards % 2 == 0) {
                n+=2;
        }
        else{
                n += 2;
        }

        // find n evenly spaced slots on top of circle
        Vector2 leftmost = new Vector2(centertargetx, centertargety);
        Vector2 circlecenter = new Vector2(centertargetx, centertargety - radius);
        Vector2 reference = new Vector2(centertargetx, 0);
        leftmost.rotateAround(circlecenter, maxdegrees);
        float degreestep = 2 * maxdegrees/ (n - 1);

        slots.clear();
        for (int i = 0; i < n; i++)
        {
            reference.x = leftmost.x - centertargetx;
            reference.y = leftmost.y + radius;
            float angle = reference.angle() - 90f;
            CardSlot newslot = new CardSlot(leftmost.x -150,
                    leftmost.y, angle);
            slots.add(newslot);
            leftmost.rotateAround(circlecenter, -degreestep);
        }

        // distribute cards in slots
        int startslot = (slots.size() - cards.size())/2;
        for (int i = 0; i < cards.size(); i++)
        {
            cards.get(i).setZIndex(i);
            cards.get(i).indexoriginal = i;
            cards.get(i).ismoving = false;
            cards.get(i).Shuffle(slots.get(i + startslot).x, slots.get(i + startslot).y,
                    slots.get(i + startslot).angle * anglemultiplier);
        }


    }

}
