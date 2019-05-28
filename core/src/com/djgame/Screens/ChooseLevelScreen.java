package com.djgame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.djgame.Assets;
import com.djgame.Session;

public class ChooseLevelScreen implements Screen {

    private MainGame game;
    private Assets assets;
    public Stage stage;

    public ChooseLevelScreen(Assets assets, MainGame game)
    {
        this.assets = assets;
        this.game = game;
        stage = new Stage();
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
    public void hide() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void dispose() {
        if (stage != null)
        {
            stage.dispose();
        }
    }
}

