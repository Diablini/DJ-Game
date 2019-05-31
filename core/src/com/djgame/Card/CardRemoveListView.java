package com.djgame.Card;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.djgame.Card.CardListView;
import com.djgame.Screens.MainGame;

public class CardRemoveListView extends CardListView {

    public int maxpicks, picks;

    public CardRemoveListView(CardPile cards, boolean shuffle, MainGame game)
    {
        super(cards, shuffle, game);
        this.cardlist = game.deck.GetInitialPile();

        RemoveListeners();
        AddListeners();
        maxpicks = 1;
        picks = 0;
    }

    @Override
    public void AddListeners() {

        final CardRemoveListView v = this;

        for (int i = 0; i < cardlist.Size(); i++)
        {
            final Card2d card = cardlist.Get(i);
            ClickListener listener = new ClickListener(){

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    picks++;
                    game.deck.RemoveCard(card);
                    if (picks >= maxpicks)
                    {
                        PickLimit();
                    }
                    return true;
                }
            };

            card.addListener(listener);
        }
    }

    public void PickLimit()
    {
        game.NextOrReward();
    }
}
