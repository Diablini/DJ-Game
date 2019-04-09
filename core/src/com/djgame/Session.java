package com.djgame;


public class Session {

    public static void NewSession(){
        State.round = 1;
        State.hp = Constants.startinghp;
        State.inspiration = Constants.inspirationperturn;
        State.ui = new UI();

        State.ui.drawpile.Shuffle();
    }

    public static void BeginTurn(){
        // check if round timer has run out
        if (State.round > Constants.roundlimit){
            TimerOut();
            return;
        }

        // update round timer
        State.ui.rounds.setText("Turns: " + State.round + "/" + Constants.roundlimit);

        // draw initial cards
        for (int i = 0; i < Constants.drawperturn; i++)
        {
            // if nothing left to draw, shuffle discard into draw
            if (!State.ui.drawpile.HasCards())
            {
                // if discard is also empty we cant do anything
                if (!State.ui.discardpile.HasCards()) break;
                while(State.ui.discardpile.Size() != 0)
                {
                    State.ui.drawpile.AddCard(State.ui.discardpile.DrawCard());
                }
                State.ui.drawpile.Shuffle();
            }
            Card2d card = State.ui.drawpile.DrawCard();
            State.ui.cards.AddCard(card);
        }

        // reset inspiration
        State.inspiration = Constants.inspirationperturn;
    }

    public static void EndTurn(){
        // increment round
        State.round++;

        // dump hand into discard pile
        int c = State.ui.cards.cards.size();
        for (int i = 0; i < c; i++){
            Card2d card = State.ui.cards.getFirstCard();
            State.ui.cards.RemoveCard(card);
            State.ui.discardpile.AddCard(card);
        }

        if (State.hp <= 0){HpOut();}
        BeginTurn();
    }

    public static void LoseHp(){
        State.hp--;
        if (State.hp <= 0){HpOut();}
    }

    public static void HpOut(){
        // TODO: Handle
    }

    public static void TimerOut(){
        // TODO: Handle game end
    }

    public static void ScorePoints(int points){
        State.crowd += points;
    }

    // called when a track is played but has no clips
    public static void EmptyTrack(TrackPlaylist.TrackType type){
        LoseHp();
        // TODO: more logic prob
    }

    public static class State{

        private static UI ui;
        private static int round, hp, inspiration, crowd;

        public static UI getui(){
            return ui;
        }
    }

}
