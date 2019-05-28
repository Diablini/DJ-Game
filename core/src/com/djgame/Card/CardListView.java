package com.djgame.Card;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.djgame.Constants;
import com.djgame.Screens.MainGame;

public class CardListView extends Group {

    public MainGame game;
    public CardPile cardlist;
    public float width, height;

    public CardListView(CardPile cards, boolean shuffle, MainGame game){
        this.game = game;
        cardlist = new CardPile(cards, game);
        if (shuffle)
        {
            cardlist.Shuffle();
        }

        Resize(((int) Constants.listviewwidth), ((int) Constants.listviewheight));
        RemoveListeners();
        AddListeners();
    }

    public void Resize(int w, int h)
    {
        this.clearChildren();

        width = ((float) w);
        height = ((float) h);
        int maxrows, maxcols, cardwidth, cardheight;
        cardwidth = ((int) (300f * Constants.listviewcardscale));
        cardheight = ((int) (420f * Constants.listviewcardscale));
        maxcols = ((int) width) / (cardwidth + ((int) Constants.listviewcolumnpad));
        maxrows = (((int) height) / cardheight + ((int) Constants.listviewrowpad));

        int col = 0;
        int row = 0;
        for (int i = 0; i < cardlist.Size(); i++)
        {
            // if its both max columns and rows stop placing any more cards
            if (col > maxcols && row > maxrows) break;

            if (col > maxcols){
                row++;
                col = 0;
            }

            // place card
            addActor(cardlist.Get(i));
            cardlist.Get(i).setPosition(col * cardwidth + (col * Constants.listviewcolumnpad),
                                         -(row * cardheight + (row * Constants.listviewrowpad)));
            cardlist.Get(i).setScale(Constants.listviewcardscale);

            col++;
        }

    }

    public void RemoveListeners()
    {
        for (int i = 0; i < cardlist.Size(); i++)
        {
            if (cardlist.Get(i) != null)
            {
                cardlist.Get(i).clearListeners();
            }
        }
    }

    public void AddListeners()
    {
        for (int i = 0; i < cardlist.Size(); i++)
        {
            if (cardlist.Get(i) != null)
            {
                ClickListener listener = new ClickListener(){

                };
            }
        }
    }

}
