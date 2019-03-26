package com.djgame;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import java.lang.Math;
import java.util.Vector;


public class CardFan implements Disposable {

    public class CardSlot{
        public int x, y;
        // relative to x axis
        float angle;

        public CardSlot(int x, int y, float a)
        {
            this.x = x;
            this.y = y;
            angle = a;
        }
    }

    public int centertargetx = 960;
    public int centertargety = 100;
    public int radius = 3500;
    public int minslots = 30;
    public float maxdegrees = 10;
    Vector<CardSlot> slots;

    public CardFan() {
        // init Card slots
        slots = new Vector<CardSlot>();
        resize(minslots);
    }

    public void resize(int n) {

        // find n evenly spaced slots on top of circle
        Vector2 leftmost = new Vector2(centertargetx, centertargety);
        Vector2 circlecenter = new Vector2(centertargetx, centertargety - radius);
        Vector2 reference = new Vector2(centertargetx, 0);
        leftmost.rotateAround(circlecenter, maxdegrees);
        float degreestep = 2*maxdegrees/ (n - 1);

        for (int i = 0; i < n; i++)
        {
            reference.x = leftmost.x - centertargetx;
            reference.y = leftmost.y + radius;
            float angle = Math.round(reference.angle() - 90f);
            CardSlot newslot = new CardSlot(Math.round(leftmost.x),
                    Math.round(leftmost.y), angle);
            slots.add(newslot);
            leftmost.rotateAround(circlecenter, -degreestep);
        }
    }

    @Override
    public void dispose() {

    }
}
