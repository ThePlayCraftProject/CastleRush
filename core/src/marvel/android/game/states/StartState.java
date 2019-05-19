package marvel.android.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import marvel.android.game.CastleRush;

public class StartState extends State {
    private Texture bg;
    private Texture pb;
    private Rectangle pbBounds;
    private Vector3 touchPos;

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
            touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            Rectangle point = new Rectangle(touchPos.x, touchPos.y, 1, 1);
            if (point.overlaps(pbBounds)) {
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
        sb.draw(pb, pbBounds.x, pbBounds.y, pbBounds.width, pbBounds.height);
        sb.end();
    }

    @Override
    public void dispose() {
        pb.dispose();
        bg.dispose();
    }
}
