package com.djgame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.djgame.Card.CardRemoveListView;
import com.djgame.Card.Deck;

public class RemoveCardsScreen implements Screen {

    public Stage stage;
    public MainGame game;

    public RemoveCardsScreen(MainGame game, int howmany)
    {
        stage = new Stage();
        this.game = game;

        CardRemoveListView view =
                new CardRemoveListView(game.deck.GetInitialPile(), false, game);
        view.Resize(1600, 960);
        view.setPosition(100f, 740f);
        stage.addActor(view);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(v);
        stage.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
