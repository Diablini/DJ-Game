package com.djgame.EventHandling;


import java.util.Vector;

// track events round by round such as cards drawn, discarded, played etc
public class Watchdog {
    public enum WATCHDOGEVENT{
        CARDSPLAYED,
        CARDSDRAWN,
        CARDSDRAWNEXTRA,
        CARDSDISCARDED,
        MIXERMOVES,
        HPLOST,
        TRACKSPLAYED,
        EMPTYTRACKS,
        POWERBEFORECREATED,
        POWERAFTERCREATED,

    }

    public int [] countersperturn;
    public int [] counterglobal;
    public Vector<WatchdogCallback> [] listeners;

    public Watchdog(){
        countersperturn = new int [WATCHDOGEVENT.values().length];
        counterglobal = new int [WATCHDOGEVENT.values().length];
        listeners = new Vector[WATCHDOGEVENT.values().length];
        NewRound();
        for (WATCHDOGEVENT i : WATCHDOGEVENT.values())
        {
            counterglobal[i.ordinal()] = 0;
        }
    }

    public void NewRound(){
        for (WATCHDOGEVENT i : WATCHDOGEVENT.values())
        {
            countersperturn[i.ordinal()] = 0;
        }
    }

    public void FireEvent(WATCHDOGEVENT e){
        // sort by priority
        for (int i = 0; i < listeners[e.ordinal()].size(); i++)
        {
            for (int z = i; z < listeners[e.ordinal()].size() - 1; z++)
            {
                if (listeners[e.ordinal()].get(z).priority >
                        listeners[e.ordinal()].get(z + 1).priority)
                {
                    WatchdogCallback swap = listeners[e.ordinal()].get(z);
                    listeners[e.ordinal()].set(z, listeners[e.ordinal()].get(z+1));
                    listeners[e.ordinal()].set(z + 1, swap);
                }
            }
        }

        // fire events
        for (int i = 0; i < listeners[e.ordinal()].size(); i++)
        {
            listeners[e.ordinal()].get(i).Play();
        }
    }

    public void AddListener(WatchdogCallback l, WATCHDOGEVENT e)
    {
        listeners[e.ordinal()].add(l);
    }

    public void RemoveListener(WatchdogCallback e)
    {
        for (WATCHDOGEVENT i : WATCHDOGEVENT.values()){
            listeners[i.ordinal()].remove(e);
        }
    }

    public int GetTurnValue(WATCHDOGEVENT e)
    {
        return countersperturn[e.ordinal()];
    }

    public int GetGlobalValue(WATCHDOGEVENT e){
        return counterglobal[e.ordinal()];
    }

    public void CardPlayed(){
        countersperturn[WATCHDOGEVENT.CARDSPLAYED.ordinal()]++;
        counterglobal[WATCHDOGEVENT.CARDSPLAYED.ordinal()]++;
    }

    public void CardDrawn(){
        counterglobal[WATCHDOGEVENT.CARDSDRAWN.ordinal()]++;
        countersperturn[WATCHDOGEVENT.CARDSDRAWN.ordinal()]++;
    }

    public void CardDrawnExtra(){
        countersperturn[WATCHDOGEVENT.CARDSDRAWNEXTRA.ordinal()]++;
        counterglobal[WATCHDOGEVENT.CARDSDRAWNEXTRA.ordinal()]++;
    }

    public void CardDiscard(){
        countersperturn[WATCHDOGEVENT.CARDSDISCARDED.ordinal()]++;
        counterglobal[WATCHDOGEVENT.CARDSDISCARDED.ordinal()]++;

    }

    public void MixerMoved(){
        countersperturn[WATCHDOGEVENT.MIXERMOVES.ordinal()]++;
        counterglobal[WATCHDOGEVENT.MIXERMOVES.ordinal()]++;
    }

    public void HpLost(){
        countersperturn[WATCHDOGEVENT.HPLOST.ordinal()]++;
        counterglobal[WATCHDOGEVENT.HPLOST.ordinal()]++;
    }

    public void TracksPlayed(){
        countersperturn[WATCHDOGEVENT.TRACKSPLAYED.ordinal()]++;
        counterglobal[WATCHDOGEVENT.TRACKSPLAYED.ordinal()]++;
    }

    public void EmptyTracks(){
        countersperturn[WATCHDOGEVENT.EMPTYTRACKS.ordinal()]++;
        counterglobal[WATCHDOGEVENT.EMPTYTRACKS.ordinal()]++;
    }

    public void PowerBeforeCreated(){
        countersperturn[WATCHDOGEVENT.POWERBEFORECREATED.ordinal()]++;
        counterglobal[WATCHDOGEVENT.POWERBEFORECREATED.ordinal()]++;
    }

    public void PowerAfterCreated(){
        countersperturn[WATCHDOGEVENT.POWERAFTERCREATED.ordinal()]++;
        counterglobal[WATCHDOGEVENT.POWERAFTERCREATED.ordinal()]++;
    }

}
