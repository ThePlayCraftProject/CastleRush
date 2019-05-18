package marvel.android.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import marvel.android.game.CastleRush;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = CastleRush.WIDTH;
		config.height = CastleRush.HEIGHT;
		config.title = CastleRush.TITLE;
		new LwjglApplication(new CastleRush(), config);
	}
}
