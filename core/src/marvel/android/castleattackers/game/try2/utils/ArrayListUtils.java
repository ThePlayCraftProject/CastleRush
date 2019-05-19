package marvel.android.castleattackers.game.try2.utils;

import java.util.ArrayList;

import marvel.android.castleattackers.game.try2.castleattackers.GameObject;

public class ArrayListUtils {
	
	public ArrayList<GameObject> moveObjectsX(ArrayList<GameObject> list, int deltaX){
		if(list.isEmpty())
			return null;
		if(deltaX == 0)
			return list;
		
		for(GameObject obj: list){
			obj.position.x+=deltaX;
			return list;
		}
		return null;
	}
}
