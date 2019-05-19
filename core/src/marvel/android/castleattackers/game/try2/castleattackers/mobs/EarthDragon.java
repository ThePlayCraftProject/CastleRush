package marvel.android.castleattackers.game.try2.castleattackers.mobs;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import marvel.android.castleattackers.game.try2.castleattackers.Assets;
import marvel.android.castleattackers.game.try2.castleattackers.GameLiving;
import marvel.android.castleattackers.game.try2.castleattackers.World;
import marvel.android.castleattackers.game.try2.castleattackers.World.Species;

public class EarthDragon extends GameLiving {

	private final float DRAGON_MOVE_VELOCITY = 20;
	public static float DRAGON_WIDTH = 180;
	public static float DRAGON_HEIGHT = 180;
	public float lifeTime;


	public EarthDragon(float x, float y,
			Species species, int mobLevel, int lane) {
		super(x, y, DRAGON_WIDTH, DRAGON_HEIGHT, species, lane);
		velocity.set(DRAGON_MOVE_VELOCITY, 0);
		position.set(x, y);
		setCenterX(position.x + width / 2);
		lifeTime = 0;
		this.mobLevel = mobLevel;
		
		if(mobLevel <= 4){
			DRAGON_WIDTH = mobLevel * 50;
			DRAGON_HEIGHT = mobLevel * 50;
		}
		
			hp = 300 + mobLevel * 15;
			isCaster = false;
			isRange = false;
			attackRange = 35;
			attackSpeed = 1.2f; 
			maxLivingTime = 75; 
			this.species = World.Species.earthDragon;
			attackDamage = 30 + mobLevel;

			damageType = DamageType.crush;
			fireResi = 0.25f;
			iceResi = 0.25f;
			darknessResi = 0.25f;
			slashResi = 0.45f;
			thrustResi = 0.45f;
			crushResi = 0.45f;
			
			maxLivingTime = 90;
	
		bowEquipped = false;

	}


	@Override
	public TextureRegion getAnimation() {
		switch (state) {
		case attack:
				return (TextureRegion) Assets.earthDragonAttack.getKeyFrame(stateTime, true);
		case walk:
				return (TextureRegion) Assets.earthDragonWalk.getKeyFrame(stateTime, true);
		case hit:
				return (TextureRegion) Assets.earthDragonHit.getKeyFrame(stateTime, true);
		case die:
				return (TextureRegion) Assets.earthDragonDie.getKeyFrame(stateTime, false);
		case read: 
				return (TextureRegion) Assets.earthDragonRead.getKeyFrame(stateTime, true);
			}
		return null;
	}


	@Override
	public float getStandartMoveVelocity() {
		return this.DRAGON_MOVE_VELOCITY;
	}

}
