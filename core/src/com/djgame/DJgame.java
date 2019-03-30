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



public class DJgame extends ApplicationAdapter {

	private Stage teststage;
	private UI ui;
	
	@Override
	public void create () {
		teststage = new Stage(new ScreenViewport());
		ui = new UI();
		Gdx.input.setInputProcessor(teststage);

		Texture bgtex = new Texture(Gdx.files.internal("background.jpg"));
		Image bg = new Image(bgtex);

		Texture b = new Texture(Gdx.files.internal("image-drum1.jpg"));
		Image button = new Image(b);
		button.setZIndex(Constants.zgenericbutton);
		button.setPosition(900,500);
		button.setZIndex(0);
		button.setVisible(true);
		button.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				Card2d card = new Card2d(500,500,0, 2f/3f, 2f/3f);
				ui.cards.AddCard(card);
			}
		});

		teststage.addActor(bg);
		teststage.addActor(ui);
		teststage.addActor(button);

		Card2d card = new Card2d(960,540, 0, 2f/3f, 2f/3f);
		Card2d card1 = new Card2d(960,540, 0, 2f/3f, 2f/3f);
		Card2d card2 = new Card2d(960,540, 0, 2f/3f, 2f/3f);
		Card2d card3 = new Card2d(960,540, 0, 2f/3f, 2f/3f);
		Card2d card4 = new Card2d(960,540, 0, 2f/3f, 2f/3f);

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
