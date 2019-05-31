package com.djgame.Levels.Rewards;

import com.badlogic.gdx.Screen;
import com.djgame.Card.CardPile;
import com.djgame.Card.Deck;
import com.djgame.Levels.LevelReward;
import com.djgame.Screens.AddCardsScreen;
import com.djgame.Screens.MainGame;

public class AddXofYPower extends LevelReward {
    public int x, y;

    public AddXofYPower(MainGame game, int add, int ofy)
    {
        super(game);
        x = add;
        y = ofy;
        cost = 60;
    }

    @Override
    public LevelReward clone() {
        AddXofYPower c = new AddXofYPower(game, x, y);
        return c;
    }

    @Override
    public String getText() {
        return "Pick " + x + " of " + y + " support cards";
    }

    @Override
    public Screen Claim() {
        Deck deck = Deck.getPowerCards(game);
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
