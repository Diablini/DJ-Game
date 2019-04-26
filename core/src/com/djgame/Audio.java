package com.djgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.djgame.Tracks.TrackPlaylist;

public class Audio extends Actor {

    public Audio(){
        drum = null;
        bass = null;
        synth = null;
        dummy = Gdx.audio.newMusic(Gdx.files.internal("audio/HipHopSynths.wav"));

        dummy.setVolume(0f);
        Music.OnCompletionListener listen = new Music.OnCompletionListener() {
            @Override
            public void onCompletion(Music music) {
                LoopComplete();
            }
        };


    }

    @Override
    public void act(float delta) {
        if (!dummy.isPlaying()){
            LoopComplete();
        }
    }

    public void LoopComplete(){
        boolean anyplaying = false;

        // check drums
        if (Session.State.getui().tracks.dtrack.GetNext().style != TrackPlaylist.SongStyle.EMPTY){
            anyplaying = true;
            if (drum != null) drum.dispose();
            drum = Load(Session.State.getui().tracks.dtrack.GetNext().style,
                    TrackPlaylist.TrackType.DRUM);
        }
        else{
            if (drum != null) drum.dispose();
            drum = null;
        }

        // check bass
        if (Session.State.getui().tracks.btrack.GetNext().style != TrackPlaylist.SongStyle.EMPTY){
            anyplaying = true;
            if (bass != null) bass.dispose();
            bass = Load(Session.State.getui().tracks.btrack.GetNext().style,
                    TrackPlaylist.TrackType.BASS);
        }
        else{
            if (bass != null) bass.dispose();
            bass = null;
        }


        // check synth
        if (Session.State.getui().tracks.strack.GetNext().style != TrackPlaylist.SongStyle.EMPTY){
            anyplaying = true;
            if (synth != null) synth.dispose();
            synth = Load(Session.State.getui().tracks.strack.GetNext().style,
                    TrackPlaylist.TrackType.SYNTH);
        }
        else{
            if (synth != null) synth.dispose();
            synth = null;
        }

        if (!anyplaying){
            return;
        }

        dummy.play();
        if (drum != null) drum.play();
        if (bass != null) bass.play();
        if (synth != null) synth.play();
    }

    public Music Load(TrackPlaylist.SongStyle style, TrackPlaylist.TrackType type)
    {
        String target = "audio/";
        switch (style){
            case HIPHOP:
                target += "HipHop";
                break;

            case HOUSE:
                target += "House";
                break;

            case TRAP:
                target += "Trap";
                break;
            case EMPTY:
                System.out.println("WTF");
                break;
        }

        switch (type){
            case SYNTH:
                target += "Synths";
                break;
            case DRUM:
                target += "Drums";
                break;
            case BASS:
                target += "Bass";
                break;
        }
        target += ".wav";
        return Gdx.audio.newMusic(Gdx.files.internal(target));
    }

    private Music drum, bass, synth, dummy;
    private long drumid, bassid, synthid, dummyid;
}
