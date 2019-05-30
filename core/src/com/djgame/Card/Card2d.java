package com.djgame.Card;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.djgame.Constants;
import com.djgame.Screens.MainGame;
import com.djgame.Session;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;

import javax.smartcardio.Card;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.parallel;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.rotateTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.scaleTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;


public class Card2d extends Group {

    // for storing z index before being moused over
    private boolean iszoomed;

    private int zoriginal;
    private float xoriginal;
    private float yoriginal;
    private float angleoriginal;
    public int indexoriginal;
    public boolean ismoving;

    protected TextureRegion backgroundreg, picreg;
    protected String ttext, ftext, dtext;
    protected int basecost, costmod;
    public Rarity rarity;
    public CardType type;

    public MainGame game;


    public Card2d(MainGame game){
        this.game = game;
        rarity = Rarity.Common;
        type = CardType.None;

        xoriginal = yoriginal = 0;
        indexoriginal = 0;
        iszoomed = false;
        ismoving = false;
        // load textures and styles
        Texture backgroundtex =
                game.assets.manager.get("cardplaceholderfixed.png", Texture.class);
        Texture pictex = game.assets.manager.get("pictureplaceholder.jpg", Texture.class);

        backgroundreg = new TextureRegion(backgroundtex);
        picreg = new TextureRegion(pictex);

        backgroundreg.getTexture().setFilter(Texture.TextureFilter.Linear,
                Texture.TextureFilter.Linear);
        picreg.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        ttext = "Lorem ipsum";
        ftext = "Lorem ipsum";
        dtext = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";

        costmod = 0;

        UpdateAssets();

        //setZIndex(Constants.zcardinhand);

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
                if (iszoomed || ismoving) return;
                if (hasActions()) return;
                if (event.getType() != InputEvent.Type.enter || event.getButton() != -1) return;
                if (getChildren().contains(fromActor, true)) return;

                addAction(parallel(
                        scaleTo(Constants.cardscalelargex,
                                Constants.cardscalelargey, Constants.enlargeduration),
                        moveTo(getX() + Constants.hoveroffsetx,
                                getY() + Constants.hoveroffsety, Constants.enlargeduration),
                        rotateTo(getRotation()/1f, Constants.enlargeduration)));



                System.out.print("Enter X:" + (getX() + Constants.hoveroffsetx + " Y:" +
                        (getY() + Constants.hoveroffsety)) + "\n");
                // set Z index higher
                zoriginal = getZIndex();
                setZIndex(Constants.zcardzoomed);
                xoriginal = getX();
                yoriginal = getY();
                angleoriginal = getRotation();
                iszoomed = true;
                ismoving = false;

                cancel();
            }

            // on mouse exit
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                // ignore clicks and exit from children
                if (!iszoomed || ismoving) return;
                if (event.getType() != InputEvent.Type.exit || event.getButton() != -1) return;
                if (getChildren().contains(toActor, true)) return;

                addAction(parallel(
                        scaleTo(Constants.cardscalex, Constants.cardscaley,
                                Constants.enlargeduration),
                        moveTo(xoriginal, yoriginal, Constants.enlargeduration),
                        rotateTo(angleoriginal, Constants.enlargeduration)));

                System.out.print("Exit X:" + xoriginal + " Y:" +
                        yoriginal + "\n");

                // set Z index to original
                setZIndex(zoriginal);
                iszoomed = false;
                ismoving = false;

                cancel();
            }

            // on mouse click
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //TODO: write click event

                // if right button is pressed and card is picked up, put it back
                if (event.getButton() == Input.Buttons.RIGHT && Session.State.pickup.isPicked())
                {
                    Card2d toreturn = Session.State.pickup.picked;
                    Session.State.pickup.UnPick();
                    Session.State.getui().cards.AddCardAtIndex
                            (toreturn, toreturn.indexoriginal);
                    return true;
                }

                // if no card is picked up, pick it up
                if (!Session.State.pickup.isPicked())
                {
                    Session.State.pickup.PickUp(Card2d.this);
                    Card2d.this.ismoving = true;
                }
                else
                {
                    // check if card is below play line
                    if (event.getStageY() < Constants.cardplayliney)
                    {
                        Card2d toreturn = Session.State.pickup.picked;
                        Session.State.pickup.UnPick();
                        Session.State.getui().cards.AddCardAtIndex
                                (toreturn, toreturn.indexoriginal);
                        return true;
                    }

                    // check if there is a choose request for a card and satisfy it
                    if (Session.State.choose.CardWait())
                    {
                        Session.State.choose.CardChosen(Card2d.this);
                        return true;
                    }

                    // cost check and play if it passes
                    if (Session.State.pickup.picked == Card2d.this)
                    {
                        if (Session.State.pickup.picked.Play())
                        {
                            Session.State.pickup.UnPick();
                        }
                    }
                }
                return true;
            }

        });
    }

    public Card2d(Card2d cpy, MainGame game)
    {
        this(game);
        this.costmod = cpy.costmod;
        this.backgroundreg = cpy.backgroundreg;
        this.basecost = cpy.basecost;
        this.ttext = cpy.ttext;
        this.dtext = cpy.dtext;
        this.ftext = cpy.ftext;
        this.picreg = cpy.picreg;
        UpdateAssets();
    }

    public Card2d clone()
    {
        Card2d c = new Card2d(game);
        return c;
    }

    public void UpdateAssets()
    {
        // throw away all children
        getChildren().clear();

        Label.LabelStyle titlestyle = new Label.LabelStyle();
        Label.LabelStyle textstyle = new Label.LabelStyle();
        Label.LabelStyle ftextstyle = new Label.LabelStyle();
        Label.LabelStyle coststyle = new Label.LabelStyle();

        // TODO: True type fonts
        BitmapFont font = Constants.fonts.cardtitle;
        titlestyle.font = font;
        titlestyle.fontColor = Color.BLACK;
        textstyle.font = font;
        textstyle.fontColor = Color.BLACK;
        ftextstyle.font = font;
        ftextstyle.fontColor = Color.DARK_GRAY;
        coststyle.font = font;
        coststyle.fontColor = Color.BLACK;

        backgroundreg.getTexture().setFilter(Texture.TextureFilter.Linear,
                Texture.TextureFilter.Linear);
        picreg.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Image background = new Image(backgroundreg);
        Image pic = new Image(picreg);

        Label titletext = new Label(ttext,titlestyle);
        Label descriptiontext = new Label(dtext,textstyle);
        Label flavourtext = new Label(ftext, ftextstyle);
        Label costtext = new Label(String.valueOf(basecost + costmod), coststyle);
        titletext.setFontScale(Constants.cardtitlefontscale, Constants.cardtitlefontscale);
        descriptiontext.setFontScale(Constants.carddescfontscale,Constants.carddescfontscale);
        costtext.setFontScale(Constants.cardtitlefontscale, Constants.cardtitlefontscale);
        flavourtext.setFontScale(Constants.cardflavfontscale, Constants.cardflavfontscale);
        costtext.setFontScale(Constants.cardtitlefontscale);

        // set relative positions
        pic.setX(pic.getX() + Constants.picoffsetx);
        pic.setY(pic.getY() + Constants.picoffsety);

        titletext.setX(Constants.titleoffsetx);
        titletext.setY(Constants.titleoffsety);
        titletext.setBounds(Constants.titleoffsetx, Constants.titleoffsety,
                 Constants.titlewidth, Constants.titleheight);
        titletext.setAlignment(Align.center,Align.center);

        descriptiontext.setX(Constants.textoffsetx);
        descriptiontext.setY(Constants.textoffsety);
        descriptiontext.setBounds(Constants.textoffsetx, Constants.textoffsety,
                Constants.textwidth, Constants.textheight);
        descriptiontext.setAlignment(Align.top , Align.center);
        descriptiontext.setWrap(true);

        flavourtext.setX(Constants.ftextoffsetx);
        flavourtext.setY(Constants.ftextoffsety);
        flavourtext.setBounds(Constants.ftextoffsetx, Constants.ftextoffsety,
                Constants.ftextwidth, Constants.ftextheight);
        flavourtext.setAlignment(Align.center,Align.center);

        costtext.setX(Constants.costoffsetx);
        costtext.setY(Constants.costoffsety);
        costtext.setBounds(Constants.costoffsetx, Constants.costoffsety,
                Constants.costwidth, Constants.costheight);

        // add actors
        addActor(background);
        addActor(pic);
        addActor(titletext);
        addActor(descriptiontext);
        addActor(flavourtext);
        addActor(costtext);
    }

    // basically move and rotate card to position and angle
    public void Shuffle(float x, float y, float angle){
        ismoving = true;
        setOrigin(getWidth()/2, getHeight()/2);
        addAction(sequence(
                parallel(moveTo(x, y, Constants.shuffleduration),
                        rotateTo(angle, Constants.shuffleduration),
                        scaleTo(Constants.cardscalex, Constants.cardscaley, Constants.shuffleduration))
                , new Action() {

                    @Override
                    public boolean act(float v) {
                        Card2d.this.ismoving = false;
                        Card2d.this.iszoomed = false;
                        return true;
                    }
                }
        ));
        setOrigin(getWidth()/2, 0);
    }

    public int getCost(){
        return basecost + costmod;
    }

    public boolean Play(){
        return false;
    }

    public boolean PlaySpecial(){
        return false;
    }

    public enum Rarity
    {
        Common,
        Rare,
        Epic,
        Special
    }

    public enum CardType
    {
        None,
        Music,
        Power,
        Support,
    }
}
