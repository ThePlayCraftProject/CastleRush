package marvel.android.castleattackers.game.try2.castleattackers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import marvel.android.castleattackers.game.try2.castleattackers.screens.SplashScreen;

/**@author MrMarvel [S30]**/
public class CastleInvaders extends Game {

	public SpriteBatch batch;
	public BitmapFont font;
	
	public Preferences prefs;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		prefs = Gdx.app.getPreferences("CastleInvaders");
		this.setScreen(new SplashScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	public static void startActivity() {

	}

}