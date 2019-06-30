package com.djgame.Card;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.djgame.Constants;
import com.djgame.Screens.MainGame;
import com.djgame.Session;


public class CardPickup extends Group {
    private MainGame game;
    public Card2d picked;
    public boolean pickedup;
    public float a = 0f;

    public CardPickup(MainGame game)
    {
        this.game = game;
        picked = null;
        pickedup = false;
    }

    public void PickUp(Card2d card)
    {
        if (!isPicked())
        {
            picked = card;
            addActor(picked);
            pickedup = true;
            picked.setScale(Constants.cardscalelargex, Constants.cardscalelargey);
            picked.setRotation(0f);
            Session.State.getui().cards.RemoveCard(picked);
        }
    }

    public void UnPick()
    {
        pickedup = false;
        picked = null;
        clearChildren();
    }

    public boolean isPicked()
    {
        return pickedup;
    }

    @Override
    public void act(float delta) {
        int x = Gdx.input.getX();
        int y = Gdx.graphics.getHeight() + -Gdx.input.getY();

        for (int i = 0; i < getChildren().items.length; i++)
        {
            if (getChildren().items[i] != null)
            {
                getChildren().items[i].setPosition(x - getChildren().items[i].getWidth()/2,
                        y - getChildren().items[i].getHeight()/2);
            }
        }

        // BULLSHIT CODE FOR TILTING THE CARD
        // TODO: change to reverse vector
        float angle = (Gdx.input.getDeltaX() / 5f);

        if (true) return;

        float side = 0f;
        if (0 + a > 0f)
        {
            side = -1f;
        }
        else side = 1f;
        a += Math.min( 2.63f, Math.abs(a)) * side ;
        a += (Gdx.input.getDeltaX()/ 2.3f) % 8f;
        a %= 20f;
        if (a > -2f && a < 2f) a = 0f;

        System.out.print(a + "\n");

        if (isPicked())
        {
            picked.setRotation(a);
        }
    }
}
