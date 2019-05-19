package marvel.android.castleattackers.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import marvel.android.castleattackers.game.try2.castleattackers.store.StoreObject;
import marvel.android.castleattackers.game.try2.utils.ui.ClickableElement;

public class StoreElement extends ClickableElement {
	StoreObject obj;
	
	public StoreElement(Rectangle position, Texture tex, StoreObject obj) {
		super(position, tex);
		this.obj = obj;
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}

}
