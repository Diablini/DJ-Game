package com.djgame;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.Font;


public class DJgame extends ApplicationAdapter {
	/*public SpriteBatch batch;
	public BitmapFont font;
	public Texture img;*/

	private Stage teststage;
	private CardFan cardfan;
	
	@Override
	public void create () {
		/*batch = new SpriteBatch();
		font = new BitmapFont();
		img = new Texture("badlogic.jpg");
		this.setScreen(new MainMenuScreen(this));*/
		teststage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(teststage);
		cardfan = new CardFan();
		Texture bgtex = new Texture(Gdx.files.internal("background.jpg"));
		Image bg = new Image(bgtex);

		Texture b = new Texture(Gdx.files.internal("button.png"));
		Image button = new Image(b);
		button.setX(500);
		button.setY(500);
		button.setZIndex(0);
		button.addListener(new ClickListener() {
							   @Override
							   public boolean isPressed() {
							   	Card2d card = new Card2d(500,500,0, 1, 1);
							   	cardfan.AddCard(card);
								   return super.isPressed();
							   }
						   });
		teststage.addActor(button);


		teststage.addActor(bg);
		teststage.addActor(cardfan);

		for (int i = 0; i < cardfan.slots.size(); i++)
		{
			float x = cardfan.slots.get(i).x;
			float y = cardfan.slots.get(i).y;
			float a = cardfan.slots.get(i).angle;
			Card2d card = new Card2d(x,y,a, 1, 1);
			teststage.addActor(card);
		}
	}

	@Override
	public void render () {
		/*Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();*/
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
