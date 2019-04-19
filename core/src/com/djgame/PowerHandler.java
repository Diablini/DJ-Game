package com.djgame;

import java.util.Comparator;
import java.util.Vector;

public class PowerHandler {

    public abstract class Power{
        public int priority;
        public abstract void Play();
    }

    Vector<Power> beforeround, afterround;
    Comparator<Power> comp;

    PowerHandler(){
        beforeround = new Vector<Power>();
        afterround = new Vector<Power>();
        comp = new Comparator<Power>() {
            @Override
            public int compare(Power power, Power t1) {
                return power.priority - t1.priority;
            }
        };
    }

    public void PlayBefore(){
        beforeround.sort(comp);

        for (int i = 0; i < beforeround.size(); i++){
            beforeround.get(i).Play();
        }
    }

    public void PlayAfter(){
        afterround.sort(comp);

        for (int i = 0; i < afterround.size(); i++){
            afterround.get(i).Play();
        }
    }
}
