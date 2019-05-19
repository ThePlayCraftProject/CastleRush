package marvel.android.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import marvel.android.game.CastleRush;
import marvel.android.game.sprites.Castle;

public class GameState extends State {

    public static final int CASTLE_OFFSET = 150;

    Texture bg;
    Castle[] castles;


    public GameState(GameStateManager gsm) {
        super(gsm);
        bg = new Texture("valley.jpg");
        camera.setToOrtho(false, CastleRush.WIDTH, CastleRush.HEIGHT);
        castles = new Castle[2];
        int[] teams = Castle.Forge.create2Teams();
        castles[0] = new Castle(-CASTLE_OFFSET, 0, true, teams[0]);
        castles[1] = new Castle((int) (camera.viewportWidth-castles[0].getBounds().width + CASTLE_OFFSET), 0, false, teams[1]);
    }

    @Override
    protected void handlInput() {

    }

    @Override
    public void update(float dt) {
        handlInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg, 0, 0, camera.viewportWidth, camera.viewportHeight);
        for (Castle castle : castles) {
            sb.draw(castle.getCastle(), castle.getBounds().x, castle.getBounds().y, castle.getBounds().width, castle.getBounds().height);
        }
        sb.end();

    }

    @Override
    public void dispose() {
        for (Castle castle : castles) {
            castle.dispose();
        }
        bg.dispose();
    }
}
