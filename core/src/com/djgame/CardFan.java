package com.djgame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.lang.Math;
import java.util.Vector;


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
    private int centertargety = -50;
    private int radius = Math.round(centertargetx*3f);
    private int minslots = 4;
    private float maxdegrees = 10;


    Vector<CardSlot> slots;
    Vector<Card2d> cards;

    public CardFan() {
        // init Card slots
        slots = new Vector<CardSlot>();
        cards = new Vector<Card2d>();
        resize(minslots);
    }

    public void AddCard(Card2d card){
        cards.add(card);
        addActor(card);
        // im not flexing but i can use ? FLEX FLEX FLEX
        resize(minslots > cards.size() ? minslots : cards.size());
    }

    public boolean RemoveCard(Card2d card){
        for (int i = 0; i < cards.size(); i++)
        {
            if (cards.get(i).equals(card));{
                cards.remove(i);
                resize(cards.size());
                return true;
            }
        }
        return false;
    }

    public void resize(int n) {
        if (n == 0) {return;}
        if (cards.size() % 2 == 0) {
            n = (n + 2) + n % 2;
        }
        else{
            n +=2;
        }

        // find n evenly spaced slots on top of circle
        Vector2 leftmost = new Vector2(centertargetx, centertargety);
        Vector2 circlecenter = new Vector2(centertargetx, centertargety - radius);
        Vector2 reference = new Vector2(centertargetx, 0);
        leftmost.rotateAround(circlecenter, maxdegrees);
        float degreestep = 2 * maxdegrees/ (n - 1);

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
        int startslot = n - cards.size();
        for (int i = 0; i < cards.size(); i++)
        {
            cards.get(i).Shuffle(slots.get(i + startslot).x, slots.get(i + startslot).y,
                    slots.get(i + startslot).angle);
        }


    }

}
