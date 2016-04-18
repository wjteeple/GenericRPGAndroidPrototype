package com.greenwolfinc.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.greenwolfinc.game.GenericRPG;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GenericRPG.WIDTH;
		config.height = GenericRPG.HEIGHT;
		config.title = GenericRPG.TITLE;
		new LwjglApplication(new GenericRPG(), config);
	}
}
