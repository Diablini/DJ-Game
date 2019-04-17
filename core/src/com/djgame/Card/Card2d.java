package com.djgame.Card;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.djgame.Constants;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.parallel;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.rotateTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.scaleTo;


public class Card2d extends Group {

    // for storing z index before being moused over
    private boolean iszoomed, ispickedup;
    private int zoriginal;
    private float xoriginal;
    private float yoriginal;
    private float angleoriginal;
    private float dragpointx, dragpointy;
    protected TextureRegion backgroundreg, picreg;
    protected String ttext, ftext, dtext;
    protected int basecost;


    public Card2d(){
        iszoomed = false;
        ispickedup = false;
        // load textures and styles
        Texture backgroundtex = new Texture(Gdx.files.internal("cardplaceholder.png"));
        Texture pictex = new Texture(Gdx.files.internal("pictureplaceholder.jpg"));

        backgroundreg = new TextureRegion(backgroundtex);
        picreg = new TextureRegion(pictex);

        backgroundreg.getTexture().setFilter(Texture.TextureFilter.Linear,
                Texture.TextureFilter.Linear);
        picreg.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        ttext = "Lorem ipsum";
        ftext = "Lorem ipsum";
        dtext = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";

        UpdateAssets();

        setZIndex(Constants.zcardinhand);

        setPosition(0,0);
        setBounds(0,0,backgroundreg.getTexture().getWidth(),
                backgroundreg.getTexture().getHeight());
        setScale(1f,1f);
        setOrigin(getWidth()/2, getHeight()/2);
        setRotation(0);

        setOrigin(getWidth()/2, 0);
        //setBounds(x,y, texture.getWidth(), texture.getHeight());

        // add listeners
        addListener(new ClickListener(){

            // on mouse over
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                // ignore clicks and entry from children
                if (iszoomed || ispickedup) return;
                if (hasActions()) return;
                if (event.getType() != InputEvent.Type.enter || event.getButton() != -1) return;
                if (getChildren().contains(fromActor, true)) return;

                addAction(parallel(
                        scaleTo(Constants.cardscalelargex,
                                Constants.cardscalelargey, Constants.enlargeduration),
                        moveTo(getX() + Constants.hoveroffsetx,
                                getY() + Constants.hoveroffsety, Constants.enlargeduration),
                        rotateTo(getRotation()/2f, Constants.enlargeduration)));

                // set Z index higher
                zoriginal = getZIndex();
                setZIndex(Constants.zcardzoomed);
                xoriginal = getX();
                yoriginal = getY();
                angleoriginal = getRotation();
                iszoomed = true;

                cancel();
            }

            // on mouse exit
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                // ignore clicks and exit from children
                if (!iszoomed || ispickedup) return;
                if (event.getType() != InputEvent.Type.exit || event.getButton() != -1) return;
                if (getChildren().contains(toActor, true)) return;
                addAction(parallel(
                        scaleTo(Constants.cardscalex, Constants.cardscaley,
                                Constants.enlargeduration),
                        moveTo(xoriginal, yoriginal, Constants.enlargeduration),
                        rotateTo(angleoriginal, Constants.enlargeduration)));

                // set Z index to original
                setZIndex(zoriginal);
                iszoomed = false;

                cancel();
            }



            // on mouse click
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //TODO: write click event
                if (hasActions()) return false;
                return Play();
            }

            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {
                return true;
            }
        });
    }

    public Card2d(float x, float y, float angle, float scalex, float scaley){
        // TODO: maybe delete this and use only default constructor
        iszoomed = false;
        ispickedup = false;
        // load textures and styles
        Texture backgroundtex = new Texture(Gdx.files.internal("cardplaceholder.png"));
        Texture pictex = new Texture(Gdx.files.internal("pictureplaceholder.jpg"));

        backgroundreg = new TextureRegion(backgroundtex);
        picreg = new TextureRegion(pictex);

        backgroundreg.getTexture().setFilter(Texture.TextureFilter.Linear,
                Texture.TextureFilter.Linear);
        picreg.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


        ttext = "Lorem ipsum";
        ftext = "Lorem ipsum";
        dtext = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";

        UpdateAssets();

        setZIndex(Constants.zcardinhand);

        setPosition(x,y);
        setBounds(x,y,backgroundreg.getTexture().getWidth(),
                backgroundreg.getTexture().getHeight());
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
                if (event.getType() != InputEvent.Type.enter || event.getButton() != -1) return;
                if (getChildren().contains(fromActor, true)) return;

                addAction(parallel(
                        scaleTo(Constants.cardscalelargex,
                        Constants.cardscalelargey, Constants.enlargeduration),
                        moveTo(getX() + Constants.hoveroffsetx,
                                getY() + Constants.hoveroffsety, Constants.enlargeduration)));

                // set Z index higher
                zoriginal = getZIndex();
                setZIndex(Constants.zcardzoomed);
                xoriginal = getX();
                yoriginal = getY();
                iszoomed = true;

                cancel();
            }

            // on mouse exit
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                // ignore clicks and exit from children
                if (!iszoomed) return;
                if (event.getType() != InputEvent.Type.exit || event.getButton() != -1) return;
                if (getChildren().contains(toActor, true)) return;
                addAction(parallel(
                        scaleTo(Constants.cardscalex, Constants.cardscaley,
                        Constants.enlargeduration),
                        moveTo(xoriginal, yoriginal, Constants.enlargeduration)));

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

    public void UpdateAssets()
    {
        // throw away all children
        getChildren().clear();

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

        backgroundreg.getTexture().setFilter(Texture.TextureFilter.Linear,
                Texture.TextureFilter.Linear);
        picreg.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Image background = new Image(backgroundreg);
        Image pic = new Image(picreg);

        Label titletext = new Label(ttext,titlestyle);
        titletext.setFontScale(2f,2f);
        Label descriptiontext = new Label(dtext,textstyle);
        descriptiontext.setFontScale(1.5f,1.5f);
        Label flavourtext = new Label(ftext, ftextstyle);

        // set relative positions
        pic.setX(pic.getX() + Constants.picoffsetx);
        pic.setY(pic.getY() + Constants.picoffsety);

        titletext.setX(Constants.titleoffsetx);
        titletext.setY(Constants.titleoffsety);
        titletext.setBounds(Constants.titleoffsetx, Constants.titleoffsety,
                Constants.titlewidth, Constants.titleheight);
        titletext.setAlignment(1,1);

        descriptiontext.setX(Constants.textoffsetx);
        descriptiontext.setY(Constants.textoffsety);
        descriptiontext.setBounds(Constants.textoffsetx, Constants.textoffsety,
                Constants.textwidth, Constants.textheight);
        descriptiontext.setAlignment(1 , 1);
        descriptiontext.setWrap(true);

        flavourtext.setX(Constants.ftextoffsetx);
        flavourtext.setY(Constants.ftextoffsety);
        flavourtext.setBounds(Constants.ftextoffsetx, Constants.ftextoffsety,
                Constants.ftextwidth, Constants.ftextheight);
        flavourtext.setAlignment(1,1);

        // add actors
        addActor(background);
        addActor(pic);
        addActor(titletext);
        addActor(descriptiontext);
        addActor(flavourtext);
    }

    // basically move and rotate card to position and angle
    public void Shuffle(float x, float y, float angle){
        setOrigin(getWidth()/2, getHeight()/2);
        addAction(parallel(moveTo(x,y, Constants.shuffleduration),
                rotateTo(angle, Constants.shuffleduration),
                scaleTo(Constants.cardscalex, Constants.cardscaley, Constants.shuffleduration)));
        setOrigin(getWidth()/2, 0);
    }

    public boolean Play(){
        return false;
    }

    public boolean PlaySpecial(){
        return false;
    }
}
