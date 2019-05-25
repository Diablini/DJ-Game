package com.djgame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.djgame.Assets;
import com.djgame.Audio;
import com.djgame.Card.Card2d;
import com.djgame.Card.CardListView;
import com.djgame.Card.Cards.AdvancedDrawperturn;
import com.djgame.Card.Cards.AdvancedInstantCombo;
import com.djgame.Card.Cards.BasicBassHipHop;
import com.djgame.Card.Cards.BasicBassHouse;
import com.djgame.Card.Cards.BasicBassTrap;
import com.djgame.Card.Cards.BasicClipSwap;
import com.djgame.Card.Cards.BasicDrawDiscard;
import com.djgame.Card.Cards.BasicDrumHipHop;
import com.djgame.Card.Cards.BasicDrumHouse;
import com.djgame.Card.Cards.BasicDrumTrap;
import com.djgame.Card.Cards.BasicMixerPoint;
import com.djgame.Card.Cards.BasicPlayTrack;
import com.djgame.Card.Cards.BasicSynthHipHop;
import com.djgame.Card.Cards.BasicSynthHouse;
import com.djgame.Card.Cards.BasicSynthTrap;
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

        Card2d card = new BasicMixerPoint(game);
        Card2d card1 = new BasicMixerPoint(game);
        Card2d card2 = new BasicSynthHouse(game);
        Card2d card3 = new BasicDrumHouse(game);
        Card2d card4 = new BasicBassHouse(game);
        Card2d card5 = new BasicSynthHipHop(game);
        Card2d card6 = new BasicDrumHipHop(game);
        Card2d card7 = new BasicBassHipHop(game);
        Card2d card8 = new BasicSynthTrap(game);
        Card2d card9 = new BasicBassTrap(game);
        Card2d card10 = new BasicDrumTrap(game);
        Card2d card11 = new BasicMixerPoint(game);
        Card2d card12 = new AdvancedDrawperturn(game);
        Card2d card13 = new BasicDrawDiscard(game);
        Card2d card14 = new BasicClipSwap(game);
        Card2d card15 = new BasicPlayTrack(game);
        Card2d card16 = new AdvancedInstantCombo(game);
        Session.State.getui().drawpile.AddCard(card);
        Session.State.getui().drawpile.AddCard(card1);
        Session.State.getui().drawpile.AddCard(card2);
        Session.State.getui().drawpile.AddCard(card3);
        Session.State.getui().drawpile.AddCard(card4);
        Session.State.getui().drawpile.AddCard(card5);
        Session.State.getui().drawpile.AddCard(card6);
        Session.State.getui().drawpile.AddCard(card7);
        Session.State.getui().drawpile.AddCard(card8);
        Session.State.getui().drawpile.AddCard(card9);
        Session.State.getui().drawpile.AddCard(card10);
        Session.State.getui().drawpile.AddCard(card11);
        Session.State.getui().drawpile.AddCard(card12);
        Session.State.getui().drawpile.AddCard(card13);
        Session.State.getui().drawpile.AddCard(card14);
        Session.State.getui().drawpile.AddCard(card15);
        Session.State.getui().drawpile.AddCard(card16);
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
