package com.djgame.Card;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

public class CardAddListView extends CardListView {
    public int pickcount, maxpicks;

    public CardAddListView(CardPile pile, boolean shuffle, MainGame game)
    {
        super(pile, shuffle, game);
        RemoveListeners();
        AddListeners();
        pickcount = 0;
        maxpicks = 1;
    }


    public void PickLimit()
    {
        //game.setScreen(back);
    }

    @Override
    public void AddListeners() {
        final CardAddListView v = CardAddListView.this;

        for (int i = 0; i < cardlist.Size(); i++)
            {
                final Card2d card = cardlist.Get(i);
                ClickListener listener = new ClickListener(){
                    public CardAddListView view = v;

                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        view.pickcount++;
                        view.game.deck.AddCard(card);

                        if (view.pickcount >= view.maxpicks)
                        {
                            v.PickLimit();
                        }
                        return true;
                    }
                };
                cardlist.Get(i).addListener(listener);
            }
    }
}
