package marvel.android.castleattackers.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;



import marvel.android.castleattackers.game.try2.castleattackers.World.Species;
import marvel.android.castleattackers.game.try2.utils.ui.ClickableElement;

/**
 * A TextureElement is a ClickableElement having a Species connected to it
 * @see ClickableElement
 * @see Species
 * @author Nerzal
 *
 */
public class TextureElement extends ClickableElement{
	
	Species species;
	public TextureElement(Rectangle position, Texture tex, Species species) {
		super(position, tex);
		this.species = species;
	}

	@Override
	public void onClick() {
	}

	public Species getSpecies() {
		return species;
	}

}
