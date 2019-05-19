package marvel.android.castleattackers.game.try2.castleattackers.mobs;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import marvel.android.castleattackers.game.try2.castleattackers.Assets;
import marvel.android.castleattackers.game.try2.castleattackers.GameLiving;
import marvel.android.castleattackers.game.try2.castleattackers.World;
import marvel.android.castleattackers.game.try2.castleattackers.World.Species;

public class FireTroll extends GameLiving {

	public final int TROLL_MOVE_VELOCITY = 15*3;
	public static final float TROLL_WIDTH = 120;
	public static final float TROLL_HEIGHT = 120;

	public float lifeTime;

	public FireTroll(float x, float y, Species species, int mobLevel, int lane) {
		super(x, y, TROLL_WIDTH, TROLL_HEIGHT, species, lane);

		velocity.set(TROLL_MOVE_VELOCITY, 0);
		position.set(x, y);
		setCenterX(position.x + width / 2);
		lifeTime = 0;
		hp = 70 + mobLevel * 5;
		mana = 100;
		isCaster = true;
		isRange = false;
		attackRange = 35;

		castRange = 400;
		attackSpeed = 1.4f;
		maxLivingTime = 35;
		damageType = DamageType.fire;
		this.species = World.Species.lavaTroll;
		this.mobLevel = mobLevel;
		fireResi = 0.75f;
		iceResi = 0.05f;
		darknessResi = 0.15f;
		slashResi = 0.10f;
		thrustResi = 0.10f;
		crushResi = 0.10f;

	}

	@Override
	public TextureRegion getAnimation() {
		switch (state) {
		case attack:
			return (TextureRegion) Assets.lta.getKeyFrame(stateTime, true);
		case walk:
			return (TextureRegion) Assets.ltw.getKeyFrame(stateTime, true);
		case hit:
			return (TextureRegion) Assets.lth.getKeyFrame(stateTime, true);
		case die:
			return (TextureRegion) Assets.ltd.getKeyFrame(stateTime, false);
		case rangeAttack:
			return (TextureRegion) Assets.lta.getKeyFrame(stateTime, true);
		}
		return null;
	}
	
	@Override
	public float getStandartMoveVelocity() {
		return this.TROLL_MOVE_VELOCITY;
	}

}
