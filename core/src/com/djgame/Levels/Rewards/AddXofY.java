package com.djgame.Levels.Rewards;

import com.badlogic.gdx.Screen;
import com.djgame.Card.Card2d;
import com.djgame.Card.CardPile;
import com.djgame.Card.Deck;
import com.djgame.Levels.Level;
import com.djgame.Levels.LevelReward;
import com.djgame.Screens.GameScreen;
import com.djgame.Screens.MainGame;
import com.djgame.Screens.PickCardsScreen;

public class AddXofY extends LevelReward {
    public int x, y;

    public AddXofY(MainGame game, int add, int ofy)
    {
        super(game);
        x = add;
        y = ofy;
    }

    @Override
    public String getText() {
        return "Pick " + x + " of " + y + " cards";
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
        //Screen screen = new PickCardsScreen(game, pile, x);
        Screen screen = new GameScreen(game);

        return screen;
    }
}
