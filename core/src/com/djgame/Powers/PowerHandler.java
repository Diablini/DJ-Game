package com.djgame.Powers;

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
        // since this call is depreciated and crashes the app on my phone
        // I'll be using my own bubblesortTM
        // beforeround.sort(comp);

        for (int i = 0; i < beforeround.size(); i++)
        {
            for (int z = i; z < beforeround.size() - 1; z++)
            {
                if (beforeround.get(z).priority > beforeround.get(z+1).priority)
                {
                    Power swap = beforeround.get(z);
                    beforeround.set(z, beforeround.get(z+1));
                    beforeround.set(z + 1, swap);
                }
            }
        }

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
        // since this call is depreciated and crashes the app on my phone
        // I'll be using my own bubblesortTM
        //afterround.sort(comp);

        for (int i = 0; i < afterround.size(); i++)
        {
            for (int z = i; z < afterround.size() - 1; z++)
            {
                if (afterround.get(z).priority > afterround.get(z+1).priority)
                {
                    Power swap = afterround.get(z);
                    afterround.set(z, afterround.get(z+1));
                    afterround.set(z + 1, swap);
                }
            }
        }

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
