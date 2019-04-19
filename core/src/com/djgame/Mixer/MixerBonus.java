package com.djgame.Mixer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.TimeUtils;
import com.djgame.Mixer.Bonuses.DoubleComboBonus;
import com.djgame.Mixer.Bonuses.DrawBonus;
import com.djgame.Mixer.Bonuses.HandPointBonus;
import com.djgame.Mixer.Bonuses.HealBonus;
import com.djgame.Mixer.Bonuses.InspirationBonus;
import com.djgame.Mixer.Bonuses.PointBonus;

import java.util.Vector;

public class MixerBonus {
    public Label text;
    public boolean activated;
    public void Play(){
    }

    public MixerBonus(){
        BitmapFont font = new BitmapFont();
        Label.LabelStyle style = new Label.LabelStyle();
        style.fontColor = Color.WHITE;
        style.font = font;
        activated = false;
        text = new Label("", style);
        text.setFontScale(1.5f);
    }

    public static Vector<MixerBonus> getBonusList(){
        Vector<MixerBonus> list = new Vector<MixerBonus>();
        list.add(new DoubleComboBonus());
        list.add(new DrawBonus());
        list.add(new HandPointBonus());
        list.add(new HealBonus());
        list.add(new InspirationBonus());
        list.add(new PointBonus());
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
