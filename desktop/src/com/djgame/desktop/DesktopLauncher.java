package com.djgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.djgame.DJgame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 1080;
		config.width = 1920;
		config.fullscreen = false;
		config.useGL30 = false;
		config.foregroundFPS = 120;
		config.backgroundFPS = 120;
		config.fullscreen = true;
		new LwjglApplication(new DJgame(), config);
	}
}
