package Character.player;

import Character.NPC.Spawn.Cat;

public class CatLady extends Player {

	public CatLady(int x, int y) {
		super("lib//Cat Lady standing-2.png", x, y, 29, 34, 100, 8, 13);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Spawns a new Cat that attacks enemies.
	 */
	public void special() {
		if (onASurface)
			if (isRight)
				(new Cat((int)getMaxX() + 5, (int)getMaxY()-25, true)).insertIntoPlane(getPlane());
			else
				(new Cat((int)getMinX() - 30, (int)getMaxY()-25, false)).insertIntoPlane(getPlane());
	}

}
