package com.djgame.EventHandling;


import com.djgame.Card.Card2d;
import com.djgame.Mixer.MixerTrack;

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
            listeners[i.ordinal()] = new Vector<WatchdogCallback>();
        }
    }

    public void NewRound(){
        for (WATCHDOGEVENT i : WATCHDOGEVENT.values())
        {
            countersperturn[i.ordinal()] = 0;
        }
    }

    public void FireEvent(WATCHDOGEVENT e, WatchdogEventInfo info){
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
            listeners[e.ordinal()].get(i).Play(info);
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

    public void CardPlayed(Card2d card){
        countersperturn[WATCHDOGEVENT.CARDSPLAYED.ordinal()]++;
        counterglobal[WATCHDOGEVENT.CARDSPLAYED.ordinal()]++;
        WatchdogEventInfo info = new WatchdogEventInfo();
        info.card = card;
        FireEvent(WATCHDOGEVENT.CARDSPLAYED, info);
    }

    public void CardDrawn(Card2d card){
        counterglobal[WATCHDOGEVENT.CARDSDRAWN.ordinal()]++;
        countersperturn[WATCHDOGEVENT.CARDSDRAWN.ordinal()]++;
        WatchdogEventInfo info = new WatchdogEventInfo();
        info.card = card;
        FireEvent(WATCHDOGEVENT.CARDSDRAWN, info);
    }

    public void CardDrawnExtra(Card2d card){
        countersperturn[WATCHDOGEVENT.CARDSDRAWNEXTRA.ordinal()]++;
        counterglobal[WATCHDOGEVENT.CARDSDRAWNEXTRA.ordinal()]++;
        WatchdogEventInfo info = new WatchdogEventInfo();
        info.card = card;
        FireEvent(WATCHDOGEVENT.CARDSDRAWNEXTRA, info);
    }

    public void CardDiscard(Card2d card){
        countersperturn[WATCHDOGEVENT.CARDSDISCARDED.ordinal()]++;
        counterglobal[WATCHDOGEVENT.CARDSDISCARDED.ordinal()]++;
        WatchdogEventInfo info = new WatchdogEventInfo();
        info.card = card;
        FireEvent(WATCHDOGEVENT.CARDSDISCARDED, info);

    }

    public void MixerMoved(MixerTrack mixer){
        countersperturn[WATCHDOGEVENT.MIXERMOVES.ordinal()]++;
        counterglobal[WATCHDOGEVENT.MIXERMOVES.ordinal()]++;
        WatchdogEventInfo info = new WatchdogEventInfo();
        info.mixer = mixer;
        FireEvent(WATCHDOGEVENT.MIXERMOVES, info);
    }

    public void HpLost(){
        countersperturn[WATCHDOGEVENT.HPLOST.ordinal()]++;
        counterglobal[WATCHDOGEVENT.HPLOST.ordinal()]++;
        WatchdogEventInfo info = new WatchdogEventInfo();
        FireEvent(WATCHDOGEVENT.HPLOST, info);
    }

    public void TracksPlayed(){
        countersperturn[WATCHDOGEVENT.TRACKSPLAYED.ordinal()]++;
        counterglobal[WATCHDOGEVENT.TRACKSPLAYED.ordinal()]++;
        WatchdogEventInfo info = new WatchdogEventInfo();
        FireEvent(WATCHDOGEVENT.TRACKSPLAYED, info);
    }

    public void EmptyTracks(){
        countersperturn[WATCHDOGEVENT.EMPTYTRACKS.ordinal()]++;
        counterglobal[WATCHDOGEVENT.EMPTYTRACKS.ordinal()]++;
        WatchdogEventInfo info = new WatchdogEventInfo();
        FireEvent(WATCHDOGEVENT.EMPTYTRACKS, info);
    }

    public void PowerBeforeCreated(){
        countersperturn[WATCHDOGEVENT.POWERBEFORECREATED.ordinal()]++;
        counterglobal[WATCHDOGEVENT.POWERBEFORECREATED.ordinal()]++;
        WatchdogEventInfo info = new WatchdogEventInfo();
        FireEvent(WATCHDOGEVENT.POWERBEFORECREATED, info);
    }

    public void PowerAfterCreated(){
        countersperturn[WATCHDOGEVENT.POWERAFTERCREATED.ordinal()]++;
        counterglobal[WATCHDOGEVENT.POWERAFTERCREATED.ordinal()]++;
        WatchdogEventInfo info = new WatchdogEventInfo();
        FireEvent(WATCHDOGEVENT.POWERAFTERCREATED, info);
    }

}
