package com.djgame.Card;

import com.djgame.Card.Cards.Rare.Drawperturn;
import com.djgame.Card.Cards.Rare.InstantCombo;
import com.djgame.Card.Cards.Epic.TwoDraw;
import com.djgame.Card.Cards.Common.BassHipHop;
import com.djgame.Card.Cards.Common.BassHouse;
import com.djgame.Card.Cards.Common.BassTrap;
import com.djgame.Card.Cards.Rare.ClipSwap;
import com.djgame.Card.Cards.Common.DrawDiscard;
import com.djgame.Card.Cards.Common.DrumHipHop;
import com.djgame.Card.Cards.Common.DrumHouse;
import com.djgame.Card.Cards.Common.DrumTrap;
import com.djgame.Card.Cards.Common.MixerPoint;
import com.djgame.Card.Cards.Common.PlayTrack;
import com.djgame.Card.Cards.Common.SynthHipHop;
import com.djgame.Card.Cards.Common.SynthHouse;
import com.djgame.Card.Cards.Common.SynthTrap;
import com.djgame.Card.Cards.Rare.ResetMixerBonuses;
import com.djgame.Screens.MainGame;

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

    public static Deck getAllCards(MainGame game)
    {
        Deck deck = new Deck(game);

        Card2d card = new MixerPoint(game);
        Card2d card2 = new SynthHouse(game);
        Card2d card3 = new DrumHouse(game);
        Card2d card4 = new BassHouse(game);
        Card2d card5 = new SynthHipHop(game);
        Card2d card6 = new DrumHipHop(game);
        Card2d card7 = new BassHipHop(game);
        Card2d card8 = new SynthTrap(game);
        Card2d card9 = new BassTrap(game);
        Card2d card10 = new DrumTrap(game);
        Card2d card12 = new Drawperturn(game);
        Card2d card13 = new DrawDiscard(game);
        Card2d card14 = new ClipSwap(game);
        Card2d card15 = new PlayTrack(game);
        Card2d card16 = new InstantCombo(game);
        Card2d card17 = new TwoDraw(game);
        Card2d card18 = new ResetMixerBonuses(game);
        deck.AddCard(card);
        deck.AddCard(card2);
        deck.AddCard(card3);
        deck.AddCard(card4);
        deck.AddCard(card5);
        deck.AddCard(card6);
        deck.AddCard(card7);
        deck.AddCard(card8);
        deck.AddCard(card9);
        deck.AddCard(card10);
        deck.AddCard(card12);
        deck.AddCard(card13);
        deck.AddCard(card14);
        deck.AddCard(card15);
        deck.AddCard(card16);
        deck.AddCard(card17);
        deck.AddCard(card18);

        return deck;
    }

    public static Deck getCommonCards(MainGame game)
    {
        Deck deck = getAllCards(game);

        for (int i = 0; i < deck.cards.size(); i++)
        {
            if (deck.cards.get(i).rarity != Card2d.Rarity.Common)
            {
                deck.RemoveCard(deck.cards.get(i));
                i--;
            }
        }

        return deck;
    }

    public static Deck getRareCards(MainGame game)
    {
        Deck deck = getAllCards(game);

        for (int i = 0; i < deck.cards.size(); i++)
        {
            if (deck.cards.get(i).rarity != Card2d.Rarity.Rare)
            {
                deck.RemoveCard(deck.cards.get(i));
                i--;
            }
        }

        return deck;
    }

    public static Deck getEpicCards(MainGame game)
    {
        Deck deck = getAllCards(game);

        for (int i = 0; i < deck.cards.size(); i++)
        {
            if (deck.cards.get(i).rarity != Card2d.Rarity.Epic)
            {
                deck.RemoveCard(deck.cards.get(i));
                i--;
            }
        }

        return deck;
    }

    public static Deck getMusicCards(MainGame game)
    {
        Deck deck = getAllCards(game);

        for (int i = 0; i < deck.cards.size(); i++)
        {
            if (deck.cards.get(i).type != Card2d.CardType.Music)
            {
                deck.RemoveCard(deck.cards.get(i));
                i--;
            }
        }

        return deck;
    }

    public static Deck getSupportCards(MainGame game)
    {
        Deck deck = getAllCards(game);

        for (int i = 0; i < deck.cards.size(); i++)
        {
            if (deck.cards.get(i).type != Card2d.CardType.Support)
            {
                deck.RemoveCard(deck.cards.get(i));
                i--;
            }
        }

        return deck;
    }

    public static Deck getPowerCards(MainGame game)
    {
        Deck deck = getAllCards(game);

        for (int i = 0; i < deck.cards.size(); i++)
        {
            if (deck.cards.get(i).type != Card2d.CardType.Power)
            {
                deck.RemoveCard(deck.cards.get(i));
                i--;
            }
        }

        return deck;
    }

    public static Deck getStarterDeck(MainGame game)
    {
        Deck deck = new Deck(game);
        Card2d card = new MixerPoint(game);
        Card2d card1 = new MixerPoint(game);
        Card2d card2 = new SynthHouse(game);
        Card2d card3 = new DrumHouse(game);
        Card2d card4 = new BassHouse(game);
        Card2d card5 = new SynthHipHop(game);
        Card2d card6 = new DrumHipHop(game);
        Card2d card7 = new BassHipHop(game);
        Card2d card8 = new SynthTrap(game);
        Card2d card9 = new BassTrap(game);
        Card2d card10 = new DrumTrap(game);
        Card2d card11 = new MixerPoint(game);
        Card2d card12 = new Drawperturn(game);
        Card2d card13 = new DrawDiscard(game);
        Card2d card14 = new ClipSwap(game);
        Card2d card15 = new PlayTrack(game);
        Card2d card16 = new InstantCombo(game);
        Card2d card17 = new TwoDraw(game);
        Card2d card18 = new ResetMixerBonuses(game);
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
        deck.AddCard(card18);

        return deck;
    }
}
