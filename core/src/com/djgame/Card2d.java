package com.djgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.parallel;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.rotateTo;


public class Card2d extends Group {
    // offsets of different elements
    private static float cardscalex = 2f/3f;
    private static float cardscaley = 2f/3f;
    private static float picoffsetx = 20f;
    private static float picoffsety = 171f;

    private static float titleoffsetx = 20f;
    private static float titleoffsety = 374f;
    private static float titleheight = 26f;
    private static float titlewidth = 260f;

    private static float textoffsetx = 20f;
    private static float textoffsety = 55f;
    private static float textwidth = 260f;
    private static float textheight = 87f;

    private static float ftextoffsetx = 20f;
    private static float ftextoffsety = 20f;
    private static float ftextwidth = 260f;
    private static float ftextheight = 25f;

    // action durations
    private static float shuffleduration = 0.25f;

    public Card2d(float x, float y, float angle, float scalex, float scaley){
        // load textures and styles
        Texture backgroundtex = new Texture(Gdx.files.internal("cardplaceholder.png"));
        Texture pictex = new Texture(Gdx.files.internal("pictureplaceholder.jpg"));
        Label.LabelStyle titlestyle = new Label.LabelStyle();
        Label.LabelStyle textstyle = new Label.LabelStyle();
        Label.LabelStyle ftextstyle = new Label.LabelStyle();

        BitmapFont font = new BitmapFont();
        titlestyle.font = font;
        titlestyle.fontColor = Color.BLACK;
        textstyle.font = font;
        textstyle.fontColor = Color.BLACK;
        ftextstyle.font = font;
        ftextstyle.fontColor = Color.DARK_GRAY;

        TextureRegion backgroundreg = new TextureRegion(backgroundtex);
        TextureRegion picreg = new TextureRegion(pictex);

        Image background = new Image(backgroundreg);
        Image pic = new Image(picreg);
        Label title = new Label("Sochni Cici xD",titlestyle);
        Label text = new Label("Tazi karta prizovava so4ni cici koito da ma4kata po cql den",
                textstyle);
        Label ftext = new Label("\" Seks sus jivotni \"", ftextstyle);

        // add actors
        addActor(background);
        addActor(pic);
        addActor(title);
        addActor(text);
        addActor(ftext);

        // set relative positions
        pic.setX(pic.getX() + picoffsetx);
        pic.setY(pic.getY() + picoffsety);

        title.setX(titleoffsetx);
        title.setY(titleoffsety);
        title.setBounds(titleoffsetx, titleoffsety, titlewidth, titleheight);
        title.setAlignment(1,1);

        text.setX(textoffsetx);
        text.setY(textoffsety);
        text.setBounds(textoffsetx, textoffsety, textwidth, textheight);
        text.setAlignment(1 , 1);
        text.setWrap(true);

        ftext.setX(ftextoffsetx);
        ftext.setY(ftextoffsety);
        ftext.setBounds(ftextoffsetx, ftextoffsety, ftextwidth, ftextheight);
        ftext.setAlignment(1,1);



        setPosition(x,y);
        setBounds(x,y,background.getWidth(),background.getHeight());
        setScale(scalex,scaley);
        setOrigin(getWidth()/2, getHeight()/2);
        setRotation(angle);

        setOrigin(getWidth()/2, 0);
        //setBounds(x,y, texture.getWidth(), texture.getHeight());
    }

    public void Shuffle(float x, float y, float angle){
        setOrigin(getWidth()/2, getHeight()/2);
        addAction(parallel(moveTo(x,y,shuffleduration),rotateTo(angle,shuffleduration)));
        setOrigin(getWidth()/2, 0);
    }
}
