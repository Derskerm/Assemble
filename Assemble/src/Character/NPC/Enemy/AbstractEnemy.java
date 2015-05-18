package Character.NPC.Enemy;

import Character.AbstractCharacter;

public abstract class AbstractEnemy extends AbstractCharacter implements Enemy {

	public AbstractEnemy(String filename, int x, int y, int w, int h,
			double maxHealth, double power) {
		super(filename, x, y, w, h, maxHealth, power);
		// TODO Auto-generated constructor stub
	}

}
