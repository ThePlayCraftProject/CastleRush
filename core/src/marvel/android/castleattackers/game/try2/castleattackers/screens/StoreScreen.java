package marvel.android.castleattackers.game.try2.castleattackers.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import marvel.android.castleattackers.ui.StoreElement;
import marvel.android.castleattackers.game.try2.castleattackers.Assets;
import marvel.android.castleattackers.game.try2.castleattackers.CastleInvaders;
import marvel.android.castleattackers.game.try2.castleattackers.Player;
import marvel.android.castleattackers.game.try2.castleattackers.store.Store;
import marvel.android.castleattackers.game.try2.castleattackers.store.StoreObject;
import marvel.android.castleattackers.game.try2.utils.exceptions.OutOfBoundingException;
import marvel.android.castleattackers.game.try2.utils.ui.Table;

public class StoreScreen extends Store implements Screen, InputProcessor {

	private OrthographicCamera camera;
	private final CastleInvaders game;
	private Store store;
	private Table table;

	public StoreScreen(CastleInvaders game, OrthographicCamera camera,
			Player player) {
		super(player);
		this.store = new Store(player);
		this.camera = camera;
		this.game = game;
		table = new Table(new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), Assets.window);
		if (store.getItems() != null)
			for (StoreObject obj : store.getItems()) {
				try {
					table.addElement(new StoreElement(new Rectangle(200 * table
							.getElements().size, 100 * table.getElements().size,
							80, 80), Assets.window, obj));
				} catch (OutOfBoundingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		//game.font.scale(3);

	}

	@Override
	public void render(float delta) {
		game.batch.begin();
		game.batch.draw(Assets.menuBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		game.font.draw(game.batch, "Store", 500, 750);
		table.draw(game.batch);
		game.batch.end();

		if (Gdx.input.justTouched()) {
			game.setScreen(new MainMenuScreen(game, player));
			this.dispose();
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
		// TODO Auto-generated method stub

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

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
