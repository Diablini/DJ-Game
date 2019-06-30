package com.djgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Fonts {
    Fonts()
    {
        FreeTypeFontGenerator generator =
                new FreeTypeFontGenerator(Gdx.files.internal("fonts/IntroRustG-Base2Line.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter para =
                new FreeTypeFontGenerator.FreeTypeFontParameter();
        para.size = 36;
        para.genMipMaps = true;
        para.magFilter = Texture.TextureFilter.MipMapLinearLinear;
        para.minFilter = Texture.TextureFilter.MipMapLinearLinear;
        //para.spaceY = -20;
        carddesc = cardflav = cardtitle = generator.generateFont(para);
        generator.dispose();

        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Arial.ttf"));
        para = new FreeTypeFontGenerator.FreeTypeFontParameter();
        para.size = 40;
        para.genMipMaps = true;
        para.magFilter = Texture.TextureFilter.MipMapLinearLinear;
        para.minFilter = Texture.TextureFilter.MipMapLinearLinear;
        uilabel = generator.generateFont(para);
        generator.dispose();



    }


    public BitmapFont cardtitle, carddesc, cardflav, uilabel;
}
