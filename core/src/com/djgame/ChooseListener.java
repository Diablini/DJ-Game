package com.djgame;

import com.badlogic.gdx.utils.Queue;
import com.djgame.Card.Card2d;


public class ChooseListener {

    enum ChooseRequestType{
        CARD,
        MIXER,
        TRACK
    }

    class ChooseRequest{
        public ChooseRequestType type;
        public Card2d callback;
    }

    Queue<ChooseRequest> requests;

    ChooseListener(){
        requests = new Queue<ChooseRequest>();
    }

    // are we waiting for a card to be chosen?
    public boolean CardWait(){
        if (requests.isEmpty()) return false;
        if (requests.first().type == ChooseRequestType.CARD) return true;
        return false;
    }

    // are we waiting for a card to be chosen?
    public boolean MixerWait(){
        if (requests.isEmpty()) return false;
        if (requests.first().type == ChooseRequestType.MIXER) return true;
        return false;
    }

    // are we waiting for a card to be chosen?
    public boolean TrackWait(){
        if (requests.isEmpty()) return false;
        if (requests.first().type == ChooseRequestType.TRACK) return true;
        return false;
    }


}
