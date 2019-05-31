package com.djgame.Levels.Rewards;

import com.badlogic.gdx.Screen;
import com.djgame.Card.CardPile;
import com.djgame.Card.Deck;
import com.djgame.Levels.LevelReward;
import com.djgame.Screens.AddCardsScreen;
import com.djgame.Screens.MainGame;

public class AddXofYRare extends LevelReward {
    public int x, y;

    public AddXofYRare(MainGame game, int add, int ofy)
    {
        super(game);
        x = add;
        y = ofy;
        cost = 50;
    }

    @Override
    public LevelReward clone() {
        AddXofYRare c = new AddXofYRare(game, x, y);
        return c;
    }

    @Override
    public String getText() {
        return "Pick " + x + " of " + y + " rare cards";
    }

    @Override
    public Screen Claim() {
        Deck deck = Deck.getRareCards(game);
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
