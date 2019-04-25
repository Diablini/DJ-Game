package com.djgame.Mixer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.djgame.Constants;
import com.djgame.Mixer.Bonuses.NoBonus;
import com.djgame.Session;

import java.util.Vector;
import java.lang.Math;

public class MixerTrack extends Group {
    MixerTrack(){
        value = 0;
        left = true;

        // TODO: Load from atlas
        Texture mtracktex = new Texture(Gdx.files.internal("mixer-1.png"));
        Texture knobtex = new Texture(Gdx.files.internal("mixer-knob.png"));
        TextureRegion mtrackreg = new TextureRegion(mtracktex);
        TextureRegion knobreg = new TextureRegion(knobtex);

        bonuses = new Vector<MixerBonus>();
        mixertrack = new Image(mtrackreg);
        knob = new Image(knobreg);
        knob.setPosition(Constants.knoboffsetx, Constants.knoboffsety);

        // handles changing of mixer positions
        knob.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                chosenvalue = value;
                return true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                // motherfucking magic
                Vector2 vec =
                        stageToLocalCoordinates(new Vector2(event.getStageX(),event.getStageY()));
                // since function's x and y are deltas we need the y relative to actor
                y = vec.y;

                // get closest position of knob
                float [] pos = new float [Constants.mixernumofpositions];
                // get positions
                for (int i = 0; i < Constants.mixernumofpositions; i++){
                    pos[i] = Constants.knoboffsety + (i *
                            (Constants.mixtracklength / Constants.mixernumofpositions));
                }

                float chosen = 99999f;
                // check which is closest position we can afford
                for (int i = 0; i < Constants.mixernumofpositions; i++){
                    // if its closer and we can afford the mixpower
                    if (Math.abs(y - pos[i]) < Math.abs(y - chosen) &&
                            Session.State.getMixpower() >= Math.abs(value - i) )
                    {
                        chosen = pos[i];
                        // update chosen position
                        chosenvalue = i;
                    }
                }
                // move to chosen position
                knob.setY(chosen);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                // cost check just in case
                if (Math.abs(value - chosenvalue) > Session.State.getMixpower()){
                    UpdatePosition();
                    return;
                }
                if (value == chosenvalue) return;

                int target = Math.abs(value - chosenvalue);
                // check if we should go up or down
                if (value - chosenvalue >= 0){
                    for (int i = 0; i < target; i++){
                        MoveDown();
                    }
                }
                else
                {
                    for (int i = 0; i < target; i++){
                        MoveUp();
                    }
                }
            }
        });

        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (Session.State.choose.MixerWait()){
                    Session.State.choose.MixerChosen(MixerTrack.this);
                }
                return true;
            }
        });

        addActor(mixertrack);
        addActor(knob);
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
    int value, chosenvalue;
    boolean left;
}
