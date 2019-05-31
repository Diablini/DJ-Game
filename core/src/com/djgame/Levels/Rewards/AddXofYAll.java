package com.djgame.Levels.Rewards;

import com.badlogic.gdx.Screen;
import com.djgame.Card.CardPile;
import com.djgame.Card.Deck;
import com.djgame.Levels.LevelReward;
import com.djgame.Screens.MainGame;
import com.djgame.Screens.AddCardsScreen;

public class AddXofYAll extends LevelReward {
    public int x, y;

    public AddXofYAll(MainGame game, int add, int ofy)
    {
        super(game);
        x = add;
        y = ofy;
        cost = 30;
    }

    @Override
    public LevelReward clone() {
        AddXofYAll c = new AddXofYAll(game, x, y);
        return c;
    }

    @Override
    public String getText() {
        return "Pick " + x + " of " + y + " random cards";
    }

    @Override
    public Screen Claim() {
        Deck deck = Deck.getAllCards(game);
        CardPile pile = deck.GetInitialPile();
        pile.Shuffle();

        // remove cards until we have y cards
        while(pile.Size() > y)
        {
            pile.DrawCard();
        }
        //Screen screen = new AddCardsScreen(game, pile, x);
        Screen screen = new AddCardsScreen(game, pile, x);

        return screen;
    }
}
