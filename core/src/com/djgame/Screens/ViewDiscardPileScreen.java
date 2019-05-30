package com.djgame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.djgame.Assets;
import com.djgame.Card.CardListView;
import com.djgame.Session;

public class ViewDiscardPileScreen implements Screen {

    private Stage stage;
    private MainGame game;

    public ViewDiscardPileScreen(final MainGame game)
    {
        super();
        stage = new Stage();
        this.game = game;

        Texture bgtex = game.assets.manager.get("background.jpg", Texture.class);
        Image bg = new Image(bgtex);
        stage.addActor(bg);

        CardListView view = new CardListView(Session.State.getui().discardpile, false, game);
        view.Resize(1600, 960);
        view.setPosition(100f, 740f);
        stage.addActor(view);

        Texture buttontex = game.assets.manager.get("davaj-davaj.png", Texture.class);
        final Image backbutton = new Image(buttontex);
        backbutton.setPosition(60, 60);
        backbutton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(game.gamescreen);
                return true;
            }
        });
        stage.addActor(backbutton);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(v);
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
