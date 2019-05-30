package com.djgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.djgame.Card.CardFan;
import com.djgame.Card.CardPile;
import com.djgame.Mixer.Mixer;
import com.djgame.Screens.MainGame;
import com.djgame.Screens.ViewDiscardPileScreen;
import com.djgame.Screens.ViewDrawPileScreen;
import com.djgame.Tracks.TrackPlaylist;


public class UI extends Group {

    public MainGame game;
    public Assets assets;
    public CardFan cards;
    public CardPile drawpile, discardpile, exhaustpile;
    public TrackPlaylist tracks;
    public Mixer mixer;
    public Label rounds, inspiration, crowd, mixpower, hp, chooseprompt;
    public Image endturnbutton, background, topplate;

    UI(final Assets assets, final MainGame game){
        this.assets = assets;
        this.game = game;

        setPosition(0,0);
        Label.LabelStyle style = new Label.LabelStyle();
        BitmapFont font = Constants.fonts.uilabel;
        style.fontColor = Color.WHITE;
        style.font = font;
        // TODO: load from atlas
        Texture endtex = new Texture(Gdx.files.internal("davaj-davaj.png"));
        TextureRegion endreg = new TextureRegion(endtex);
        Texture bgtex = new Texture(Gdx.files.internal("background.jpg"));
        TextureRegion bgreg = new TextureRegion(bgtex);
        Texture platetex = new Texture(Gdx.files.internal("stats-bar.png"));
        TextureRegion platereg = new TextureRegion(platetex);

        cards = new CardFan();
        drawpile = new CardPile(game);
        exhaustpile = new CardPile(game);
        discardpile = new CardPile(game);
        tracks = new TrackPlaylist();
        mixer = new Mixer();
        rounds = new Label("Turns: 0/0",style);
        inspiration = new Label("Inspiration: 0/0", style);
        crowd = new Label("Crowd Points: ", style);
        mixpower = new Label("Mix Power: 0", style);
        hp = new Label("HP: 0", style);
        chooseprompt = new Label("", style);

        endturnbutton = new Image(endreg);
        endturnbutton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                Session.EndTurn();
            }
        });

        drawpile.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                ViewDrawPileScreen screen = new ViewDrawPileScreen(game);
                game.setScreen(screen);
                return true;
            }
        });

        discardpile.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                ViewDiscardPileScreen screen = new ViewDiscardPileScreen(game);
                game.setScreen(screen);
                return true;
            }
        });



        background = new Image(bgreg);
        topplate = new Image(platereg);


        rounds.setFontScale(Constants.uilabelfontscale);
        inspiration.setFontScale(Constants.uilabelfontscale);
        crowd.setFontScale(Constants.uilabelfontscale);
        mixpower.setFontScale(Constants.uilabelfontscale);
        hp.setFontScale(Constants.uilabelfontscale);
        chooseprompt.setFontScale(Constants.uilabelfontscale);


        drawpile.Rename("Draw");
        discardpile.Rename("Discard");
        exhaustpile.Rename("");
        exhaustpile.setVisible(false);



        //TODO: add ui elements

        addActor(cards);
        addActor(drawpile);
        addActor(discardpile);
        addActor(exhaustpile);
        addActor(tracks);
        addActor(mixer);
        addActor(rounds);
        addActor(inspiration);
        addActor(crowd);
        addActor(mixpower);
        addActor(hp);
        addActor(chooseprompt);
        addActor(endturnbutton);
        addActor(background);
        addActor(topplate);
        setVisible(true);

        cards.setZIndex(Constants.zcardfan);
        cards.setPosition(Constants.cardfanx, Constants.cardfany);
        drawpile.setZIndex(Constants.zdrawpile);
        drawpile.setPosition(Constants.drawpilex, Constants.drawpiley);
        discardpile.setZIndex(Constants.zdiscardpile);
        discardpile.setPosition(Constants.discardpilex, Constants.discardpiley);
        tracks.setZIndex(Constants.ztracks);
        tracks.setPosition(Constants.tracksx, Constants.tracksy);
        mixer.setZIndex(Constants.zmixer);
        mixer.setPosition(Constants.mixerx, Constants.mixery);
        rounds.setZIndex(Constants.ztimer);
        rounds.setPosition(Constants.timerx, Constants.timery);
        inspiration.setZIndex(Constants.zinspiration);
        inspiration.setPosition(Constants.inspirationx, Constants.inspirationy);
        crowd.setZIndex(Constants.zcrowd);
        crowd.setPosition(Constants.crowdpointsx, Constants.crowdpointsy);
        mixpower.setZIndex(Constants.zmixpower);
        mixpower.setPosition(Constants.mixpowerx, Constants.mixpowery);
        hp.setZIndex(Constants.zhp);
        hp.setPosition(Constants.hpx, Constants.hpy);
        chooseprompt.setZIndex(Constants.zchooseprompt);
        chooseprompt.setPosition(Constants.choosepromptx, Constants.chooseprompty);
        endturnbutton.setZIndex(Constants.zgenericbutton);
        endturnbutton.setPosition(Constants.endturnbuttonx,Constants.endturnbuttony);
        background.setZIndex(Constants.zbackground);
        background.setPosition(Constants.backgroundx, Constants.backgroundy);
        topplate.setZIndex(Constants.ztopplate);
        topplate.setPosition(Constants.topplatex, Constants.topplatey);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawChildren(batch, parentAlpha);
    }
}
