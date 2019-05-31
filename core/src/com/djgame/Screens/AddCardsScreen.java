package com.djgame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.djgame.Card.CardAddListView;
import com.djgame.Card.CardPile;
import com.djgame.Constants;

public class AddCardsScreen implements Screen {

    private Stage stage;
    private MainGame game;

    public AddCardsScreen(MainGame game, CardPile cards, int pickmax)
    {
        this.game = game;
        stage = new Stage();

        Texture bgtex = game.assets.manager.get("background.jpg", Texture.class);
        Image bg = new Image(bgtex);
        stage.addActor(bg);

        Label.LabelStyle style = new Label.LabelStyle(Constants.fonts.uilabel, Color.WHITE);
        Label prompttext = new Label("Pick " + pickmax + " Cards",style);
        prompttext.setFontScale(1f);
        prompttext.setPosition(650f, 900f);
        prompttext.setAlignment(Align.center);
        stage.addActor(prompttext);

        CardAddListView view =
                new CardAddListView(cards, false, game);
        view.maxpicks = pickmax;
        view.Resize(1000, 660);
        view.setPosition(500f, 500f);
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
    public void hide() {

    }


    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void dispose() {
        if (stage != null)
        {
            stage.dispose();
        }
    }
}
