/**
 * 
 */
package marvel.android.castleattackers.game.try2.castleattackers.mobs;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import marvel.android.castleattackers.game.try2.castleattackers.Assets;
import marvel.android.castleattackers.game.try2.castleattackers.GameLiving;
import marvel.android.castleattackers.game.try2.castleattackers.World;
import marvel.android.castleattackers.game.try2.castleattackers.World.Species;
import marvel.android.castleattackers.game.try2.castleattackers.World.States;

public class Croco extends GameLiving {

	private static final float CROCO_WIDTH = 120;
	private static final float CROCO_HEIGHT = 120;
	private static final float CROCO_MOVE_VELOCITY = -25;
	public float lifeTime;

	public Croco(float x, float y,
			Species species, int mobLevel, int lane) {
		super(x, y, CROCO_WIDTH, CROCO_HEIGHT, species, lane);
		velocity.set(CROCO_MOVE_VELOCITY, 0);
		position.set(x, y);
		setCenterX(position.x + width / 2);
		lifeTime = 0;

		hp = 100 + mobLevel * 10;
		isCaster = false;
		isRange = false;
		attackRange = 35;

		attackSpeed = 1.2f; // 0.4f = Soll 0.4x/sec
		maxLivingTime = 75;
		this.species = World.Species.croco;
		attackDamage = 30 + mobLevel;
		this.mobLevel = mobLevel;
		damageType = DamageType.slash;
		fireResi = 0.25f;
		iceResi = 0.25f;
		darknessResi = 0.25f;
		slashResi = 0.35f;
		thrustResi = 0.35f;
		crushResi = 0.35f;
		state = States.walk;
		bowEquipped = false;
	}

	@Override
	public TextureRegion getAnimation(){
		switch (state) {
		case attack:
			return (TextureRegion) Assets.crocoAttack.getKeyFrame(stateTime, true);
		case walk:
			return (TextureRegion) Assets.crocoWalk.getKeyFrame(stateTime, true);
		case run:
			return (TextureRegion) Assets.crocoRun.getKeyFrame(stateTime, true);
		case hit:
			return (TextureRegion) Assets.crocoHit.getKeyFrame(stateTime, true);
		case die:
			return (TextureRegion) Assets.crocoDie.getKeyFrame(stateTime, false);
		case look:
			return (TextureRegion) Assets.crocoLook.getKeyFrame(stateTime, true);
		}
		return null;
	}

	@Override
	public float getStandartMoveVelocity() {
		
		return Croco.CROCO_MOVE_VELOCITY;
	}
}
