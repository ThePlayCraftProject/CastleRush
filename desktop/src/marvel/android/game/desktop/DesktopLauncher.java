package marvel.android.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import marvel.android.castleattackers.game.try2.castleattackers.CastleInvaders;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Castle_Invaders";
		//cfg.useGL20 = true;
		cfg.width = 840;
		cfg.height = 640;
		cfg.addIcon("data/icon.png", Files.FileType.Internal);
		new LwjglApplication(new CastleInvaders(), cfg);
	}
}
