package com.djgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.parallel;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.rotateTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.scaleTo;


public class Card2d extends Group {

    // for storing z index before being moused over
    private boolean iszoomed;
    private int zoriginal;
    private float xoriginal;
    private float yoriginal;

    public Card2d(float x, float y, float angle, float scalex, float scaley){
        iszoomed = false;
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
        pic.setX(pic.getX() + Constants.picoffsetx);
        pic.setY(pic.getY() + Constants.picoffsety);

        title.setX(Constants.titleoffsetx);
        title.setY(Constants.titleoffsety);
        title.setBounds(Constants.titleoffsetx, Constants.titleoffsety,
                Constants.titlewidth, Constants.titleheight);
        title.setAlignment(1,1);

        text.setX(Constants.textoffsetx);
        text.setY(Constants.textoffsety);
        text.setBounds(Constants.textoffsetx, Constants.textoffsety,
                Constants.textwidth, Constants.textheight);
        text.setAlignment(1 , 1);
        text.setWrap(true);

        ftext.setX(Constants.ftextoffsetx);
        ftext.setY(Constants.ftextoffsety);
        ftext.setBounds(Constants.ftextoffsetx, Constants.ftextoffsety,
                Constants.ftextwidth, Constants.ftextheight);
        ftext.setAlignment(1,1);

        setZIndex(Constants.zcardinhand);

        setPosition(x,y);
        setBounds(x,y,background.getWidth(),background.getHeight());
        setScale(scalex,scaley);
        setOrigin(getWidth()/2, getHeight()/2);
        setRotation(angle);

        setOrigin(getWidth()/2, 0);
        //setBounds(x,y, texture.getWidth(), texture.getHeight());

        // add listeners
        addListener(new ClickListener(){

            // on mouse over
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                // ignore clicks and entry from children
                if (iszoomed) return;
                if (hasActions()) return;
                if (event.getType() != InputEvent.Type.enter) return;
                if (getChildren().contains(fromActor, true)) return;

                addAction(parallel(
                        scaleTo(Constants.cardscalelargex,
                        Constants.cardscalelargey, Constants.enlargeduration),
                        moveTo(getX() + Constants.hoveroffsetx,
                                getY() + Constants.hoveroffsety)));

                if (!iszoomed) {
                    // set Z index higher
                    zoriginal = getZIndex();
                    setZIndex(Constants.zcardzoomed);
                    xoriginal = getX();
                    yoriginal = getY();
                    iszoomed = true;
                }

                cancel();
            }

            // on mouse exit
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                // ignore clicks and exit from children
                if (!iszoomed) return;
                if (event.getType() != InputEvent.Type.exit) return;
                if (getChildren().contains(toActor, true)) return;
                addAction(parallel(
                        scaleTo(Constants.cardscalex, Constants.cardscaley,
                        Constants.enlargeduration),
                        moveTo(xoriginal, yoriginal)));

                // set Z index to original
                setZIndex(zoriginal);
                iszoomed = false;

                cancel();
            }

            // on mouse click
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //TODO: write click event
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    public void Shuffle(float x, float y, float angle){
        setOrigin(getWidth()/2, getHeight()/2);
        addAction(parallel(moveTo(x,y, Constants.shuffleduration),
                rotateTo(angle, Constants.shuffleduration)));
        setOrigin(getWidth()/2, 0);
    }
}
