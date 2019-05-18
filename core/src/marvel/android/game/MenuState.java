package marvel.android.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Rectangle;

import marvel.android.game.sprites.Castle;
import marvel.android.game.states.GameStateManager;
import marvel.android.game.states.State;

class StartState extends State {
    private Texture bg;
    private Texture pb;
    private Rectangle pbBounds;

    public StartState(GameStateManager gsm) {
        super(gsm);

        camera.setToOrtho(false, CastleRush.WIDTH, CastleRush.HEIGHT);
        bg = new Texture("valley.jpg");
        pb = new Texture("playbtn.png");
        pbBounds = new Rectangle((int) (camera.position.x-pb.getWidth()/2),
                (int) (camera.position.y-pb.getHeight()/2), pb.getWidth(), pb.getHeight());

    }

    @Override
    protected void handlInput() {
        if (Gdx.input.justTouched()) {
            Rectangle point = new Rectangle(Gdx.input.getX(), Gdx.input.getY(), 1, 1);
            if (pbBounds.intersects(point)) {
                gsm.set(new GameState(gsm));
            }
        }
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
        sb.draw(pb, pbBounds.x, pbBounds.y);
        sb.end();
    }

    @Override
    public void dispose() {
        pb.dispose();
        bg.dispose();
    }
}
