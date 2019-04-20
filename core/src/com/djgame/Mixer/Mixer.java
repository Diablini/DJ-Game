package com.djgame.Mixer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.djgame.Constants;
import com.djgame.Mixer.Bonuses.NoBonus;
import com.djgame.Session;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.Vector;

public class Mixer extends Group {


    class MixerTrack extends Group{
        MixerTrack(){
            value = 0;
            left = true;
            // TODO: Load from atlas
            Texture mtracktex = new Texture(Gdx.files.internal("mixer-1.png"));
            Texture knobtex = new Texture(Gdx.files.internal("mixer-knob.png"));
            Texture uptex = new Texture(Gdx.files.internal("point-bass.png"));
            Texture downtex = new Texture(Gdx.files.internal("point-lead.png"));
            TextureRegion mtrackreg = new TextureRegion(mtracktex);
            TextureRegion knobreg = new TextureRegion(knobtex);
            TextureRegion upreg = new TextureRegion(uptex);
            TextureRegion downreg = new TextureRegion(downtex);
            final MixerTrack dis = this;

            bonuses = new Vector<MixerBonus>();
            mixertrack = new Image(mtrackreg);
            knob = new Image(knobreg);
            knob.setPosition(Constants.knoboffsetx, Constants.knoboffsety);
            upbutton = new Image(upreg);
            downbutton = new Image(downreg);
            upbutton.setPosition(Constants.upbuttonoffsetx, Constants.upbuttonoffsety);
            downbutton.setPosition(Constants.downbuttonoffsetx, Constants.downbuttonoffsety);

            upbutton.addListener(new ClickListener(){
                 @Override
                 public boolean touchDown(InputEvent event, float x, float y,
                                          int pointer, int button) {
                     if (dis.MoveUp()){

                     }
                     return true;
                 }
             });

            downbutton.addListener(new ClickListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y,
                                         int pointer, int button) {
                    if (dis.MoveDown())
                    {

                    }
                    return true;
                }
            });

            addActor(mixertrack);
            addActor(knob);
            addActor(upbutton);
            addActor(downbutton);
        }

        public boolean MoveUp(){
            if (value < Constants.mixernumofpositions - 1 && Session.State.getMixpower() > 0)
            {
                value++;
                Session.State.setMixpower(Session.State.getMixpower() - 1);
                UpdatePosition();
                bonuses.get(value).Play();
                Session.RefreshUI();
                return true;
            }
            return false;
        }

        public boolean MoveDown(){
            if (value > 0 && Session.State.getMixpower() > 0){
                value--;
                Session.State.setMixpower(Session.State.getMixpower() - 1);
                UpdatePosition();
                bonuses.get(value).Play();
                Session.RefreshUI();
                return true;
            }
            return false;
        }

        public void UpdatePosition(){

            knob.setPosition(Constants.knoboffsetx,
                    Constants.knoboffsety +
                            (value *
                                    (Constants.mixtracklength / Constants.mixernumofpositions)));
        }

        public void ResetBonuses(Vector<MixerBonus> list){
            // remove current bonuses
            for (int i = 0; i <bonuses.size(); i++)
            {
                removeActor(bonuses.get(i).text);
            }
            bonuses.clear();

            // shuffle new bonuses
            for (int i = 0; i < Constants.mixernumofpositions; i++){
                if (value == i){
                    NoBonus nobo = new NoBonus();
                    bonuses.add(nobo);
                    addActor(nobo.text);
                }
                else{
                    bonuses.add(list.firstElement());
                    addActor(list.firstElement().text);
                    list.removeElementAt(0);
                }
                if (left){
                    bonuses.lastElement().text.setPosition(Constants.bonusleftoffsetx,
                            (Constants.bonusoffsety +
                                    i *(Constants.mixtracklength/Constants.mixernumofpositions)));
                    bonuses.lastElement().text.setAlignment(Align.right, Align.right);
                }
                else{
                    bonuses.lastElement().text.setPosition(Constants.bonusrightoffsetx,
                            (Constants.bonusoffsety +
                                    i *(Constants.mixtracklength/Constants.mixernumofpositions)));
                }
            }
        }

        Image knob, mixertrack, upbutton, downbutton;
        Vector<MixerBonus> bonuses;
        int value;
        boolean left;
    }

    // ---------------------------------------------------------------------------------------

    public MixerTrack ltrack,rtrack;

    public Mixer()
    {
        ltrack = new MixerTrack();
        rtrack = new MixerTrack();

        ltrack.left = true;
        rtrack.left = false;
        ltrack.setPosition(Constants.mixertrackx, Constants.mixertracky);
        rtrack.setPosition(Constants.mixertrackx + Constants.mixeroffset, Constants.mixertracky);

        addActor(ltrack);
        addActor(rtrack);
    }

    public void ResetBonuses(){
        Vector<MixerBonus> list = MixerBonus.getBonusList();
        ltrack.ResetBonuses(list);
        rtrack.ResetBonuses(list);
    }

}
