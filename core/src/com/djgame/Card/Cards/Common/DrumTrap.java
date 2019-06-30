package com.djgame.Card.Cards.Common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.djgame.Card.Card2d;
import com.djgame.Constants;
import com.djgame.Screens.MainGame;
import com.djgame.Session;
import com.djgame.Tracks.Clip;
import com.djgame.Tracks.TrackPlaylist;

public class DrumTrap extends Card2d {

    public DrumTrap(MainGame game){
        super(game);
        Texture tex = game.assets.manager.get("cards-drum2.png", Texture.class);
        picreg = new TextureRegion(tex);
        super.ttext = "Trap Drums";
        super.dtext = "+2 Drum\nSpecial: Add from bottom";
        super.ftext = "Badum tish";
        basecost = 2;


        rarity = Rarity.Common;
        type = CardType.Music;
        UpdateAssets();
    }

    @Override
    public Card2d clone() {
        DrumTrap c = new DrumTrap(game);
        return c;
    }

    @Override
    public boolean Play() {
        // TODO: add inspiration check
        if (!Session.CostCheck(this)) return false;
        Texture tex = new Texture(Gdx.files.internal("tracks-point1.png"));
        TextureRegion reg = new TextureRegion(tex);

        Clip clipone = new Clip();
        Clip cliptwo = new Clip();
        clipone.style = TrackPlaylist.SongStyle.TRAP;
        cliptwo.style = TrackPlaylist.SongStyle.TRAP;
        clipone.crowdpoints = Constants.baseclippoints;
        cliptwo.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);
        cliptwo.img = new Image(reg);

        Session.State.getui().tracks.dtrack.InsertTop(clipone);
        Session.State.getui().tracks.dtrack.InsertTop(cliptwo);

        Session.State.watchdog.CardPlayed(this);
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }

    @Override
    public boolean PlaySpecial() {
        // TODO: add inspiration check
        if (!Session.CostCheck(this)) return false;

        Texture tex = new Texture(Gdx.files.internal("tracks-point1.png"));
        TextureRegion reg = new TextureRegion(tex);

        Clip clipone = new Clip();
        Clip cliptwo = new Clip();
        clipone.style = TrackPlaylist.SongStyle.TRAP;
        cliptwo.style = TrackPlaylist.SongStyle.TRAP;
        clipone.crowdpoints = Constants.baseclippoints;
        cliptwo.crowdpoints = Constants.baseclippoints;
        clipone.img = new Image(reg);
        cliptwo.img = new Image(reg);

        Session.State.getui().tracks.dtrack.InsertBottom(clipone);
        Session.State.getui().tracks.dtrack.InsertBottom(cliptwo);

        Session.State.watchdog.CardPlayed(this);
        Session.PayCardCost(this);
        Session.DiscardAfterPlay(this);
        return true;
    }
}
