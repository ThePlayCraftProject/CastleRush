package marvel.android.castleattackers.game.try2.castleattackers.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import marvel.android.castleattackers.game.try2.castleattackers.Assets;
import marvel.android.castleattackers.game.try2.castleattackers.CastleInvaders;
import marvel.android.castleattackers.game.try2.castleattackers.Player;
import marvel.android.castleattackers.game.try2.utils.OverlapTester;
import marvel.android.castleattackers.game.try2.utils.exceptions.OutOfBoundingException;

public class MainMenuScreen implements Screen {

	final CastleInvaders game;

	OrthographicCamera camera;
	Rectangle playBounds;
	Rectangle exitBounds;
	Vector3 touchPoint;

	private Rectangle storeBounds;

	private Rectangle settingBounds;

	private Player player;

	public MainMenuScreen(final CastleInvaders gam, Player player) {
		game = gam;
		this.player = player;
		//Assets.load(game);
		touchPoint = new Vector3();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 768);
		playBounds = new Rectangle(80, 494, 150, 150);
		storeBounds = new Rectangle(80, 344, 150, 150);
		settingBounds = new Rectangle(80, 194, 150, 150);
		exitBounds = new Rectangle(80, 34, 150, 150);

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_TEXTURE_2D);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		game.batch.draw(Assets.menuBackground, 0, 0);
		game.batch.draw(Assets.exitRegion, 80, 34, 150, 150);
		game.batch.draw(Assets.settingsRegion, 80, 194, 150, 150);
		game.batch.draw(Assets.storeRegion, 80, 344, 150, 150);
		game.batch.draw(Assets.playRegion, 80, 494, 150, 150);
		game.batch.end();

		if(Gdx.input.justTouched()) {
			camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(),
					0));
			if (Gdx.input.isCatchBackKey()) {
				System.exit(0);
				this.dispose();
			}
			if(OverlapTester.pointInRectangle(playBounds, touchPoint.x,touchPoint.y))
				try {
					game.setScreen(new GameScreen(game));
				} catch (OutOfBoundingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.dispose();
			
			if(OverlapTester.pointInRectangle(exitBounds, touchPoint.x, touchPoint.y)){
				System.exit(0);
				this.dispose();
				}	
			
			if(OverlapTester.pointInRectangle(storeBounds, touchPoint.x, touchPoint.y)){
				//game.setScreen(new StoreScreen(game, camera, player)); //Because it doesn't work how it must!
				this.dispose();
			}
		}

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}

	