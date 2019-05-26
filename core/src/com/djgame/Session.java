package com.djgame;


import com.djgame.Card.Card2d;
import com.djgame.Card.CardPickup;
import com.djgame.ChooseHandling.ChooseListener;
import com.djgame.EventHandling.Watchdog;
import com.djgame.Powers.PowerHandler;
import com.djgame.Screens.MainGame;
import com.djgame.Tracks.Clip;
import com.djgame.Tracks.TrackPlaylist;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;

public class Session {

    public static void NewSession(Assets assets, MainGame game){
        State.round = 1;
        State.crowd = 0;
        State.hp = Constants.startinghp;
        State.inspiration = Constants.inspirationperturn;
        State.ui = new UI(assets, game);
        State.mixpower = Constants.mixpowerperturn;

        // powerups
        State.combomultiplierbonus = 0;
        State.hiphopsinglebonus = 0;
        State.trapsinglebonus = 0;
        State.housesinglebonus = 0;

        State.ui.drawpile.Shuffle();
        State.watchdog = new Watchdog();
        State.powers = new PowerHandler();
        State.choose = new ChooseListener();
        State.pickup = new CardPickup(game);
        State.ui.addActor(State.pickup);
        State.pickup.setPosition(0, 0);

    }

    public static void BeginTurn(){
        // reset watchdog
        State.watchdog.NewRound();

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

        // play beginning of turn powers
        State.powers.PlayBefore();

        // refresh ui
        RefreshUI();
    }

    public static void EndTurn(){
        // check if we can end turn
        if (State.choose.AnyWait()) return;

        // play end of turn powers
        State.powers.PlayAfter();

        // increment round
        State.round++;

        // play tracks
        State.ui.tracks.PlayTracks();

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
        State.watchdog.CardDrawn();
    }

    public static void HealHp(){
        State.hp = (State.hp + 1 >= Constants.maxhp) ? Constants.maxhp : State.hp + 1;
        RefreshUI();
    }

    public static void LoseHp(){
        State.hp--;
        RefreshUI();
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
        State.watchdog.EmptyTracks();
        // TODO: more logic prob
    }

    public static void DiscardAfterPlay(Card2d card){
        // if card is picked up
        if (State.pickup.isPicked() && State.pickup.picked == card)
        {
            Card2d c = State.pickup.picked;
            State.pickup.UnPick();
            State.ui.discardpile.AddCard(c);
            State.watchdog.CardDiscard();
            return;
        }

        State.ui.cards.RemoveCard(card);
        State.ui.discardpile.AddCard(card);
        State.watchdog.CardDiscard();
    }

    public static void DiscardNoPlay(Card2d card){
        // if card is picked up
        if (State.pickup.isPicked() && State.pickup.picked == card)
        {
            Card2d c = State.pickup.picked;
            State.pickup.UnPick();
            State.ui.discardpile.AddCard(c);
            State.watchdog.CardDiscard();
            return;
        }

        State.ui.cards.RemoveCard(card);
        State.ui.discardpile.AddCard(card);
        State.watchdog.CardDiscard();
    }

    public static void Exhaust(Card2d card){
        // if card is picked up
        if (State.pickup.isPicked() && State.pickup.picked == card)
        {
            Card2d c = State.pickup.picked;
            State.pickup.UnPick();
            State.ui.exhaustpile.AddCard(c);
            return;
        }

        State.ui.cards.RemoveCard(card);
        State.ui.exhaustpile.AddCard(card);
    }

    public static void TripleCombo(TrackPlaylist.SongStyle style)
    {
        ScorePoints(Constants.basethreecombo *
                (Constants.basecombomultiplier + State.combomultiplierbonus));
    }

    public static void DoubleCombo(TrackPlaylist.SongStyle style)
    {
        ScorePoints(Constants.basetwocombo *
                (Constants.basecombomultiplier + State.combomultiplierbonus) );
    }

    public static void SingleCombo(Clip clip)
    {
        switch (clip.style)
        {
            case TRAP: ScorePoints(clip.crowdpoints + State.trapsinglebonus); break;
            case HOUSE: ScorePoints(clip.crowdpoints + State.housesinglebonus); break;
            case HIPHOP: ScorePoints(clip.crowdpoints + State.hiphopsinglebonus); break;
            // wtf are we doing here
            case EMPTY: return;
        }
    }

    public static boolean CostCheck(Card2d card){
        if (card.getCost() <= State.inspiration){
            return true;
        }
        return false;
    }

    public static void PayCardCost(Card2d card)
    {
        if (card.getCost() <= State.inspiration){
            State.inspiration -= card.getCost();
            RefreshUI();
        }
        else
        {
            State.inspiration = 0;
            RefreshUI();
        }
    }

    public static void RefreshUI(){
        State.ui.inspiration.setText(State.inspiration +"/" + Constants.inspirationperturn);
        State.ui.rounds.setText(State.round + "/" + Constants.roundlimit);
        State.ui.mixpower.setText(State.mixpower);
        State.ui.crowd.setText(State.crowd);
        State.ui.hp.setText(State.hp);

        State.ui.drawpile.UpdateNumber();
        State.ui.discardpile.UpdateNumber();
        State.ui.chooseprompt.setText(State.choose.GetPrompt());

        State.ui.drawpile.UpdateCards();
        State.ui.discardpile.UpdateCards();
        State.ui.exhaustpile.UpdateCards();
    }

    public static class State{

        private static UI ui;
        private static int round, hp, inspiration, crowd, mixpower;
        public static Watchdog watchdog;
        public static PowerHandler powers;
        public static ChooseListener choose;
        public static CardPickup pickup;


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


        // Powerups and shit
        public static int combomultiplierbonus;
        public static int trapsinglebonus, housesinglebonus, hiphopsinglebonus;
    }

}
