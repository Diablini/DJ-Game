package com.djgame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

public class Assets {
    public final AssetManager manager = new AssetManager();

    public Assets()
    {
    }

    public void loadcardimages()
    {
        manager.load("background.jpg", Texture.class);
        manager.load("image-drum1.jpg", Texture.class);
        manager.load("image-lead1.jpg", Texture.class);
        manager.load("jacks.jpg", Texture.class);
        manager.load("mixer-1.png", Texture.class);
        manager.load("mixer-knob.png", Texture.class);
        manager.load("mixing-pic.jpg", Texture.class);
        manager.load("pictureplaceholder.jpg", Texture.class);
        manager.load("tracks-point1.png", Texture.class);
        manager.load("tracks-point2.png", Texture.class);
        manager.load("tracks-point3.png", Texture.class);
        manager.load("turntable.jpg", Texture.class);
        manager.load("winamp.jpg", Texture.class);
        manager.load("skipicon.jpg", Texture.class);
        manager.load("sampler.jpg", Texture.class);
        manager.load("stats-bar.png", Texture.class);
        manager.load("cardplaceholder.png", Texture.class);
        manager.load("davaj-davaj.png", Texture.class);
        manager.load("background.jpg", Texture.class);
    }

    public void loadfonts()
    {
        FileHandleResolver resolver = new InternalFileHandleResolver();
        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

        FreetypeFontLoader.FreeTypeFontLoaderParameter aparam =
                new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        aparam.fontFileName = "arial.ttf";
        aparam.fontParameters.size = 40;

        // TODO: load fonts


        //manager.load("fonts/Arial.ttf", BitmapFont.class);
        //manager.load("fonts/CharisSILB.ttf", BitmapFont.class);
    }

    public void loadmusic()
    {
        manager.load("audio/HipHopBass.wav", Sound.class);
        manager.load("audio/HipHopDrums.wav", Sound.class);
        manager.load("audio/HipHopSynths.wav", Sound.class);
        manager.load("audio/HouseBass.wav", Sound.class);
        manager.load("audio/HouseDrums.wav", Sound.class);
        manager.load("audio/HouseSynths.wav", Sound.class);
        manager.load("audio/TrapBass.wav", Sound.class);
        manager.load("audio/TrapDrums.wav", Sound.class);
        manager.load("audio/TrapSynths.wav", Sound.class);
    }
}
