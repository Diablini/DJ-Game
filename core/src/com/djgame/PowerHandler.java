package com.djgame;

import java.util.Comparator;
import java.util.Vector;

public class PowerHandler {

    Vector<Power> beforeround, afterround;
    Comparator<Power> comp;

    public PowerHandler(){
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

        // clear duration 0 powers
        for (int i = 0; i < beforeround.size(); i++)
        {
            if (beforeround.get(i).duration <= 0)
            {
                beforeround.remove(i);
            }
        }

        for (int i = 0; i < beforeround.size(); i++){
            beforeround.get(i).Play();
        }
    }

    public void PlayAfter(){
        afterround.sort(comp);

        // clear duration 0 powers
        for (int i = 0; i < afterround.size(); i++)
        {
            if (afterround.get(i).duration <= 0)
            {
                afterround.remove(i);
            }
        }

        for (int i = 0; i < afterround.size(); i++){
            afterround.get(i).Play();
        }
    }

    public void AddBefore(Power p){
        beforeround.add(p);
    }

    public void AddAfter(Power p){
        afterround.add(p);
    }

}
