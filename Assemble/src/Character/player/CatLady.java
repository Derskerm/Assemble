package Character.player;

import Character.AbstractCharacter;
import Character.NPC.Spawn.Cat;

public class CatLady extends AbstractCharacter {

	public CatLady(String filename, int x, int y, int w, int h,
			double maxHealth, double power) {
		super(filename, x, y, w, h, maxHealth, power);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Spawns a new Cat that attacks enemies.
	 */
	public void special() {
		// TODO Auto-generated method stub
		new Cat("cat.jpg", (int)x, (int)y, 10, 5);
	}

}
