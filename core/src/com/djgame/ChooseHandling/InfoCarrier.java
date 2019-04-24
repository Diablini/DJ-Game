package com.djgame.ChooseHandling;

import com.djgame.Card.Card2d;
import com.djgame.Mixer.MixerTrack;
import com.djgame.Tracks.Track;

import java.util.Vector;

public class InfoCarrier {
    public InfoCarrier(){
        chosencards = new Vector<Card2d>();
        chosentracks = new Vector<Track>();
    }
    public Vector<Card2d> chosencards;
    public Vector<Track> chosentracks;
    public MixerTrack chosenmixer;
}
