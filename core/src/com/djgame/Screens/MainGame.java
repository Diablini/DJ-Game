package com.djgame.Screens;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.djgame.Assets;
import com.djgame.Card.Deck;
import com.djgame.Constants;
import com.djgame.Levels.Level;


public class MainGame extends Game {

	private Stage stage;
	public Assets assets;
	public GameScreen gamescreen;
	public Level level;
	public Deck deck;
	public boolean gamedone, gameover;
	public int levelstage;


	@Override
	public void create () {

        assets = new Assets();
        assets.loadcardimages();
        assets.loadfonts();
        assets.loadmusic();
        assets.manager.finishLoading();

        level = null;
        gamedone = false;
        gameover = false;
        levelstage = 0;

        deck = Deck.getStarterDeck(this);

        Screen chooselevel = new ChooseLevelScreen(this, levelstage);

		this.setScreen(chooselevel);
	}

	public boolean PendingRewards()
	{
		if (level == null || level.rewards.isEmpty()) return false;
		return true;
	}

	public void ClaimReward()
	{
		if (!PendingRewards()) return;
		Screen rewardscreen = level.rewards.get(0).Claim();
		level.rewards.remove(0);
		setScreen(rewardscreen);
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
