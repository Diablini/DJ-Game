package com.djgame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.djgame.Constants;

public class GameOverScreen implements Screen {

    public MainGame game;
    public Stage stage;

    public GameOverScreen(MainGame game)
    {
        this.game = game;
        stage = new Stage();

        Label.LabelStyle style = new Label.LabelStyle(Constants.fonts.uilabel, Color.WHITE);
        Label gameover = new Label("GAME OVER", style);
        gameover.setPosition(stage.getWidth()/2 - gameover.getWidth()/2, stage.getHeight()/2);

        stage.addActor(gameover);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(v);
        stage.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void pause() {

    }

}
