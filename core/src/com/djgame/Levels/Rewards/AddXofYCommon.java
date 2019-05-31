package com.djgame.Levels.Rewards;

import com.badlogic.gdx.Screen;
import com.djgame.Card.CardPile;
import com.djgame.Card.Deck;
import com.djgame.Levels.LevelReward;
import com.djgame.Screens.AddCardsScreen;
import com.djgame.Screens.MainGame;

public class AddXofYCommon extends LevelReward {
    public int x, y;

    public AddXofYCommon(MainGame game, int add, int ofy)
    {
        super(game);
        x = add;
        y = ofy;
        cost = 25;
    }

    @Override
    public LevelReward clone() {
        AddXofYCommon c = new AddXofYCommon(game, x, y);
        return c;
    }

    @Override
    public String getText() {
        return "Pick " + x + " of " + y + " common cards";
    }

    @Override
    public Screen Claim() {
        Deck deck = Deck.getCommonCards(game);
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
