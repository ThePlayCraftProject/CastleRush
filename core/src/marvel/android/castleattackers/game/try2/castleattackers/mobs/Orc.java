package marvel.android.castleattackers.game.try2.castleattackers.mobs;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import marvel.android.castleattackers.game.try2.castleattackers.Assets;
import marvel.android.castleattackers.game.try2.castleattackers.GameLiving;
import marvel.android.castleattackers.game.try2.castleattackers.World.Species;


public class Orc extends GameLiving {
	public final int ORC_MOVE_VELOCITY = -25;
	public static final float ORC_WIDTH = 120;
	public static final float ORC_HEIGHT = 120;

	public Orc(float x, float y, Species species, int mobLevel, int lane) {
		super(x, y, ORC_WIDTH, ORC_HEIGHT, species, lane);
		// TODO Auto-generated constructor stub
		hp = 180 + mobLevel;
		isCaster = false;
		isRange = false;
		attackRange = 35;
		attackSpeed = 1.1f;
		velocity.set(ORC_MOVE_VELOCITY, 0);
		position.set(x, y);
		maxLivingTime = 100000000;
		attackDamage = 40 + mobLevel / 8;
		this.mobLevel = mobLevel;
		fireResi = 0.25f /* mobLevel / 200 */;
		iceResi = 0.25f;
		darknessResi = 0.25f;
		slashResi = 0.25f;
		thrustResi = 0.25f;
		crushResi = 0.25f;
		damageType = DamageType.slash;
		deadTime = 0;
		swingTimer = 0;
		setCenterX(position.x + width / 2);
		bowEquipped = false;
	}

	public TextureRegion getAnimation() {
		switch (state) {
		case attack:
			return (TextureRegion) Assets.orca.getKeyFrame(stateTime, true);
		case walk:
			return (TextureRegion) Assets.orcw.getKeyFrame(stateTime, true);
		case run:
			return (TextureRegion) Assets.orcr.getKeyFrame(stateTime, true);
		case hit:
			return (TextureRegion) Assets.orch.getKeyFrame(stateTime, true);
		case die:
			return (TextureRegion) Assets.orcd.getKeyFrame(stateTime, false);
		case kwalk:
			return (TextureRegion) Assets.orckw.getKeyFrame(stateTime, true);
			/*
			 * case look: return Assets.murlocLook;
			 */

		}
		return null;
	}
	
	@Override
	public float getStandartMoveVelocity() {
		return this.ORC_MOVE_VELOCITY;
	}

}
