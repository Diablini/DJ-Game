package com.djgame.Mixer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.TimeUtils;
import com.djgame.Constants;
import com.djgame.Mixer.Bonuses.DiscardPointBonus;
import com.djgame.Mixer.Bonuses.DoubleComboBonus;
import com.djgame.Mixer.Bonuses.DrawBonus;
import com.djgame.Mixer.Bonuses.DrawNextBonus;
import com.djgame.Mixer.Bonuses.HandPointBonus;
import com.djgame.Mixer.Bonuses.HealBonus;
import com.djgame.Mixer.Bonuses.InspirationBonus;
import com.djgame.Mixer.Bonuses.PointBonus;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.Vector;

public class MixerBonus {
    public Label text;
    public boolean activated;
    public void Play(){
    }

    protected void Activate(){
        activated = true;
        text.getStyle().fontColor = Constants.activatedbonuscolor;
    }

    public MixerBonus(){
        BitmapFont font = Constants.fonts.uilabel;
        Label.LabelStyle style = new Label.LabelStyle();
        style.fontColor = Color.WHITE;
        style.font = font;
        activated = false;
        text = new Label("", style);
        text.setFontScale(Constants.uimixbonusfontscale);
        text.setWrap(true);
        text.setBounds(0, 0, Constants.bonustextwidth, Constants.bonustextheight);
    }

    public static Vector<MixerBonus> getBonusList(){
        Vector<MixerBonus> list = new Vector<MixerBonus>();
        // this bonus is just stupid
        //list.add(new DiscardPointBonus());
        list.add(new DoubleComboBonus());
        list.add(new DrawBonus());
        list.add(new HandPointBonus());
        list.add(new HealBonus());
        list.add(new InspirationBonus());
        list.add(new PointBonus());
        list.add(new DrawNextBonus());
        // TODO: add new bonuses

        // shuffle list
        RandomXS128 rand = new RandomXS128();
        rand.setSeed(TimeUtils.nanoTime());
        MixerBonus swap;
        for (int i = 0; i < list.size(); i++)
        {
            int r = rand.nextInt(list.size()-1) ;
            swap = list.get(r);
            list.setElementAt(list.get(i), r);
            list.setElementAt(swap, i);
        }
        return list;
    }
}
