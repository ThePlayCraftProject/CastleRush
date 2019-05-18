package marvel.android.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

import java.awt.Rectangle;
import java.io.File;

public class Castle implements Disposable {

    public static final int CASTLE_WIDTH = 200;
    public static final int CASTLE_HEIGHT = 300;

    private Texture[] castle;
    private Rectangle[] bounds;
    private boolean isLeft;
    private int team;
    private int stage;
    private int HP;

    public Castle(int x, int y, boolean isLeft, int team) {
        this.isLeft = isLeft;
        team%=3;
        this.team = team;
        castle = new Texture[3];
        bounds = new Rectangle[3];
        for (int i = 0; i < castle.length; i++) {
            castle[i] = new Texture(team+File.separator+i+".png");
            bounds[i] = new Rectangle(x, y, castle[i].getWidth(), castle[i].getHeight());
        }
        stage = 0;
        HP = 120;
    }

    public Texture getCastle() {
        return castle[stage];
    }
    public Rectangle getBounds() {
        return bounds[stage];
    }

    public void update(float dt) {
        switch (stage) {
            case 0:
                if (HP < 80) stage = 1;
                break;
            case 1:
                if (HP < 30) stage = 2;
                break;
        }
    }







    @Override
    public void dispose() {
        for (Texture t : castle) {
            t.dispose();
        }
    }

    public static class Forge {
        public static int[] create2Teams() {
            int team = MathUtils.random(0, 2);
            int team2 = MathUtils.random(0, 1);
            return new int[]{team, team2};
        }
    }
}
