package com.djgame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.djgame.Assets;
import com.djgame.Audio;
import com.djgame.Card.Deck;
import com.djgame.Session;

public class GameScreen implements Screen {

    private Stage stage;
    public Assets assets;
    public MainGame game;


    public GameScreen(Assets assets, MainGame game){
        super();
        this.game = game;
        this.assets = assets;

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Session.NewSession(assets, game);

        stage.addActor(Session.State.getui());
        Audio audio = new Audio();
        stage.addActor(audio);

        Deck starter = game.deck;

        Session.State.getui().drawpile.Copy(starter.GetInitialPile());
        Session.State.getui().drawpile.Shuffle();

        Session.BeginTurn();
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        //stage.setDebugAll(true);
        stage.draw();
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
