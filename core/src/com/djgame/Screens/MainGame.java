package com.djgame.Screens;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
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
import com.djgame.UI;


public class MainGame extends Game {

	private Stage stage;
	public Assets assets;
	public GameScreen gamescreen;


	@Override
	public void create () {

        assets = new Assets();
        assets.loadcardimages();
        assets.loadfonts();
        assets.loadmusic();
        assets.manager.finishLoading();
        gamescreen = new GameScreen(assets, this);
		this.setScreen(gamescreen);
	}

	@Override
	public void render () {
		float delta = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.getScreen().render(delta);
	}
	
	@Override
	public void dispose () {
	}
}
