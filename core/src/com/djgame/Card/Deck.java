package com.djgame.Card;

import com.djgame.Card.Cards.AdvancedDrawperturn;
import com.djgame.Card.Cards.AdvancedInstantCombo;
import com.djgame.Card.Cards.AdvancedTwoDraw;
import com.djgame.Card.Cards.BasicBassHipHop;
import com.djgame.Card.Cards.BasicBassHouse;
import com.djgame.Card.Cards.BasicBassTrap;
import com.djgame.Card.Cards.BasicClipSwap;
import com.djgame.Card.Cards.BasicDrawDiscard;
import com.djgame.Card.Cards.BasicDrumHipHop;
import com.djgame.Card.Cards.BasicDrumHouse;
import com.djgame.Card.Cards.BasicDrumTrap;
import com.djgame.Card.Cards.BasicMixerPoint;
import com.djgame.Card.Cards.BasicPlayTrack;
import com.djgame.Card.Cards.BasicSynthHipHop;
import com.djgame.Card.Cards.BasicSynthHouse;
import com.djgame.Card.Cards.BasicSynthTrap;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

import java.util.Vector;

public class Deck {

    private Vector<Card2d> cards;
    private MainGame game;

    public Deck(MainGame game)
    {
        this.game = game;
        cards = new Vector<Card2d>();
    }

    public void AddCard(Card2d card)
    {
        cards.add(card);
    }

    public void RemoveCard(Card2d card)
    {
        cards.remove(card);
    }

    public CardPile GetInitialPile()
    {
        CardPile pile = new CardPile(game);
        for (int i = 0; i < cards.size(); i++)
        {
            pile.AddCard(cards.get(i));
        }
        return pile;
    }

    public static Deck getStarterDeck(MainGame game)
    {
        Deck deck = new Deck(game);
        Card2d card = new BasicMixerPoint(game);
        Card2d card1 = new BasicMixerPoint(game);
        Card2d card2 = new BasicSynthHouse(game);
        Card2d card3 = new BasicDrumHouse(game);
        Card2d card4 = new BasicBassHouse(game);
        Card2d card5 = new BasicSynthHipHop(game);
        Card2d card6 = new BasicDrumHipHop(game);
        Card2d card7 = new BasicBassHipHop(game);
        Card2d card8 = new BasicSynthTrap(game);
        Card2d card9 = new BasicBassTrap(game);
        Card2d card10 = new BasicDrumTrap(game);
        Card2d card11 = new BasicMixerPoint(game);
        Card2d card12 = new AdvancedDrawperturn(game);
        Card2d card13 = new BasicDrawDiscard(game);
        Card2d card14 = new BasicClipSwap(game);
        Card2d card15 = new BasicPlayTrack(game);
        Card2d card16 = new AdvancedInstantCombo(game);
        Card2d card17 = new AdvancedTwoDraw(game);
        deck.AddCard(card);
        deck.AddCard(card1);
        deck.AddCard(card2);
        deck.AddCard(card3);
        deck.AddCard(card4);
        deck.AddCard(card5);
        deck.AddCard(card6);
        deck.AddCard(card7);
        deck.AddCard(card8);
        deck.AddCard(card9);
        deck.AddCard(card10);
        deck.AddCard(card11);
        deck.AddCard(card12);
        deck.AddCard(card13);
        deck.AddCard(card14);
        deck.AddCard(card15);
        deck.AddCard(card16);
        deck.AddCard(card17);

        return deck;
    }
}
