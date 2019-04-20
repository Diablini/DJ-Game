package com.djgame;


import com.djgame.Card.Card2d;

public class Session {

    public static void NewSession(){
        State.round = 1;
        State.crowd = 0;
        State.hp = Constants.startinghp;
        State.inspiration = Constants.inspirationperturn;
        State.ui = new UI();
        State.mixpower = Constants.mixpowerperturn;

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
            DrawCard();
        }

        // reset inspiration and mixpower
        State.inspiration = Constants.inspirationperturn;
        State.mixpower = Constants.mixpowerperturn;

        // reset mixer bonuses
        State.ui.mixer.ResetBonuses();

        // refresh ui
        RefreshUI();
    }

    public static void EndTurn(){
        // increment round
        State.round++;

        // play tracks
        State.ui.tracks.PlayTracks(true,true,true);

        // dump hand into discard pile
        int c = State.ui.cards.cards.size();
        for (int i = 0; i < c; i++){
            Card2d card = State.ui.cards.getFirstCard();
            State.ui.cards.RemoveCard(card);
            State.ui.discardpile.AddCard(card);
        }

        // refresh ui
        RefreshUI();

        if (State.hp <= 0){HpOut();}
        BeginTurn();
    }

    public static void DrawCard(){
        if (!State.ui.drawpile.HasCards())
        {
            // if discard is also empty we cant do anything
            if (!State.ui.discardpile.HasCards()) return;
            while(State.ui.discardpile.Size() != 0)
            {
                State.ui.drawpile.AddCard(State.ui.discardpile.DrawCard());
            }
            State.ui.drawpile.Shuffle();
        }
        Card2d card = State.ui.drawpile.DrawCard();
        State.ui.cards.AddCard(card);
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

    public static void DiscardAfterPlay(Card2d card){
        State.ui.cards.RemoveCard(card);
        State.ui.discardpile.AddCard(card);
    }

    public static boolean CostCheck(Card2d card){
        if (card.getCost() <= State.inspiration){
            State.inspiration -= card.getCost();
            RefreshUI();
            return true;
        }
        return false;
    }

    public static void RefreshUI(){
        State.ui.inspiration.setText("Inspiration: "
                + State.inspiration +"/" + Constants.inspirationperturn);
        State.ui.rounds.setText("Turn: " + State.round + "/" + Constants.roundlimit);
        State.ui.mixpower.setText("Mix Power: " + State.mixpower);
        State.ui.crowd.setText("Crowd Points: " + State.crowd);

        State.ui.drawpile.UpdateNumber();
        State.ui.discardpile.UpdateNumber();
    }

    public static class State{

        private static UI ui;
        private static int round, hp, inspiration, crowd, mixpower;

        public static UI getui(){
            return ui;
        }
        public static int getMixpower(){return mixpower;}
        public static int getRound(){return round;}
        public static int getCrowd(){return crowd;}
        public static int getHp(){return hp;}
        public static int getInspiration(){return inspiration;}
        public static void setMixpower(int power){mixpower = power;}
        public static void setRound(int r){round = r;}
        public static void setInspiration(int i){inspiration = i;}
        public static void setHp(int h){hp=h;}
        public static void setCrowd(int c){crowd = c;}
    }

}
