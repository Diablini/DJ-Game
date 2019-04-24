package com.djgame;

// track events round by round such as cards drawn, discarded, played etc
public class Watchdog {
    public int cardsplayed, cardsdrawn, cardsdrawnextra, cardsdiscarded, mixermoves, hplost,
            tracksplayed, emptytracks, powerbeforecreated, poweraftercreated;

    public Watchdog(){
        NewRound();
    }

    public void NewRound(){
        cardsplayed = cardsdrawn = cardsdiscarded = cardsdrawnextra = mixermoves = hplost =
                tracksplayed = emptytracks = poweraftercreated = powerbeforecreated = 0;
    }

    public void CardPlayed(){
        cardsplayed++;
    }

    public void CardDrawn(){
        cardsdrawn++;
    }

    public void CardDrawnExtra(){
        cardsdrawnextra++;
    }

    public void CardDiscard(){
        cardsdiscarded++;
    }

    public void MixerMoved(){
        mixermoves++;
    }

    public void HpLost(){
        hplost++;
    }

    public void TracksPlayed(){
        tracksplayed++;
    }

    public void EmptyTracks(){
        emptytracks++;
    }

    public void PowerBeforeCreated(){
        powerbeforecreated++;
    }

    public void PowerAfterCreated(){poweraftercreated++;}
}
