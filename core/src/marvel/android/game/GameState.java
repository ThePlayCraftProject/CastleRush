package marvel.android.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import marvel.android.game.sprites.Castle;
import marvel.android.game.states.GameStateManager;
import marvel.android.game.states.State;

class GameState extends State {
    Castle[] castles;

    public GameState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, CastleRush.WIDTH, CastleRush.HEIGHT);
        castles = new Castle[2];
        int[] teams = Castle.Forge.create2Teams();
        castles[0] = new Castle(0, 0, true, teams[0]);
        castles[1] = new Castle((int) (camera.position.x-castles[0].getCastle().getWidth()), 0, false, teams[1]);
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
        for (Castle castle : castles) {
            sb.draw(castle.getCastle(), castle.getBounds().x, castle.getBounds().y);
        }
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
