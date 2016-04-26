package com.greenwolfinc.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.greenwolfinc.game.GenericRPG;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GenericRPG.WIDTH;
		config.height = GenericRPG.HEIGHT;
		config.title = GenericRPG.TITLE;
		new LwjglApplication(new GenericRPG(), config);
	}
}
