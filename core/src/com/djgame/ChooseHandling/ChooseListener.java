package com.djgame.ChooseHandling;

import com.badlogic.gdx.utils.Queue;
import com.djgame.Card.Card2d;
import com.djgame.Mixer.Mixer;
import com.djgame.Mixer.MixerTrack;
import com.djgame.Session;
import com.djgame.Tracks.Track;
import com.djgame.Tracks.TrackPlaylist;


public class ChooseListener {

    public enum ChooseRequestType{
        CARD,
        MIXER,
        TRACK
    }

    Queue<ChooseRequest> requests;

    public ChooseListener(){
        requests = new Queue<ChooseRequest>();
    }

    public void PutRequest(ChooseRequest req){
        requests.addLast(req);
        Session.RefreshUI();
    }

    // are we waiting for a card to be chosen?
    public boolean CardWait(){
        if (requests.isEmpty()) return false;
        if (requests.first().type == ChooseRequestType.CARD) return true;
        return false;
    }

    // are we waiting for a mixer to be chosen?
    public boolean MixerWait(){
        if (requests.isEmpty()) return false;
        if (requests.first().type == ChooseRequestType.MIXER) return true;
        return false;
    }

    // are we waiting for a track to be chosen?
    public boolean TrackWait(){
        if (requests.isEmpty()) return false;
        if (requests.first().type == ChooseRequestType.TRACK) return true;
        return false;
    }

    public boolean AnyWait(){
        if (TrackWait() || MixerWait() || CardWait()){
            return true;
        }
        return false;
    }

    public void CardChosen(Card2d card){
        if (CardWait()){
            requests.first().info.chosencards.add(card);
            requests.first().callback();
            InfoCarrier carrier = requests.first().info;
            requests.removeFirst();

            // if there are more requests pass info to them
            if (!requests.isEmpty()){
                requests.first().info = carrier;
            }
            Session.RefreshUI();
        }
    }

    public void TrackChosen(Track track){
        if (TrackWait()){
            requests.first().info.chosentracks.add(track);
            requests.first().callback();
            InfoCarrier carrier = requests.first().info;
            requests.removeFirst();

            // if there are more requests pass info to them
            if (!requests.isEmpty()){
                requests.first().info = carrier;
            }
            Session.RefreshUI();
        }
    }

    public void MixerChosen(MixerTrack mixer){
        if (MixerWait()){
            requests.first().info.chosenmixer = mixer;
            requests.first().callback();
            InfoCarrier carrier = requests.first().info;
            requests.removeFirst();

            // if there are more requests pass info to them
            if (!requests.isEmpty()){
                requests.first().info = carrier;
            }
            Session.RefreshUI();
        }
    }

    public String GetPrompt(){
        if (AnyWait()){
            return requests.first().prompt;
        }
        return "";
    }

}
