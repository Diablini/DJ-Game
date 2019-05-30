package com.djgame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.djgame.Assets;
import com.djgame.Levels.Level;
import com.djgame.Levels.LevelGenerator;
import com.djgame.Session;

public class ChooseLevelScreen implements Screen {

    private MainGame game;
    private Assets assets;
    public Stage stage;

    public ChooseLevelScreen(MainGame game, int levelstage)
    {
        this.game = game;
        stage = new Stage();

        Texture bgtex = game.assets.manager.get("background.jpg", Texture.class);
        TextureRegion bgreg = new TextureRegion(bgtex);
        Image background = new Image(bgreg);
        stage.addActor(background);

        LevelGenerator levelgenerator = new LevelGenerator(game);

        Level one = levelgenerator.generate(levelstage, 10);
        Level two = levelgenerator.generate(levelstage, 10);
        Level three = levelgenerator.generate(levelstage, 10);

        stage.addActor(one);
        stage.addActor(two);
        stage.addActor(three);

        one.setPosition(200f , 600f);
        two.setPosition( 800f, 600f);
        three.setPosition(1400f, 600f);

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

