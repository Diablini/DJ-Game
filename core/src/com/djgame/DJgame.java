package com.djgame;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.djgame.Card.Card2d;
import com.djgame.Card.Cards.AdvancedDrawperturn;
import com.djgame.Card.Cards.BasicBassHipHop;
import com.djgame.Card.Cards.BasicBassHouse;
import com.djgame.Card.Cards.BasicBassTrap;
import com.djgame.Card.Cards.BasicClipSwap;
import com.djgame.Card.Cards.BasicDrawDiscard;
import com.djgame.Card.Cards.BasicDrumHipHop;
import com.djgame.Card.Cards.BasicDrumHouse;
import com.djgame.Card.Cards.BasicDrumTrap;
import com.djgame.Card.Cards.BasicMixerPoint;
import com.djgame.Card.Cards.BasicSynthHipHop;
import com.djgame.Card.Cards.BasicSynthHouse;
import com.djgame.Card.Cards.BasicSynthTrap;


public class DJgame extends ApplicationAdapter {

	private Stage teststage;
	private UI ui;
	
	@Override
	public void create () {
		teststage = new Stage(new ScreenViewport());
		//ui = new UI();
		Gdx.input.setInputProcessor(teststage);
		Session.NewSession();

		teststage.addActor(Session.State.getui());
		Audio audio = new Audio();
		teststage.addActor(audio);


		Card2d card = new BasicMixerPoint();
		Card2d card1 = new BasicMixerPoint();
		Card2d card2 = new BasicSynthHouse();
		Card2d card3 = new BasicDrumHouse();
		Card2d card4 = new BasicBassHouse();
		Card2d card5 = new BasicSynthHipHop();
		Card2d card6 = new BasicDrumHipHop();
		Card2d card7 = new BasicBassHipHop();
		Card2d card8 = new BasicSynthTrap();
		Card2d card9 = new BasicBassTrap();
		Card2d card10 = new BasicDrumTrap();
		Card2d card11 = new BasicMixerPoint();
		Card2d card12 = new AdvancedDrawperturn();
		Card2d card13 = new BasicDrawDiscard();
		Card2d card14 = new BasicClipSwap();
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
		Session.State.getui().drawpile.Shuffle();

		Session.BeginTurn();
		//ui.cards.AddCard(card);

	}

	@Override
	public void render () {
		float delta = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		teststage.act(delta);
		teststage.draw();
	}
	
	@Override
	public void dispose () {
		teststage.dispose();
	}
}
