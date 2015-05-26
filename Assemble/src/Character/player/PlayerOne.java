package Character.player;

import Character.Character;
import Item.Weapon.Sword;

public class PlayerOne extends Player {
	
	private Sword s;
	
	public PlayerOne(int x, int y) {
		super(null, x, y, 25, 50, 100, 25, 15);
		s = new Sword(0, 0);
		weapon = s;
		// TODO Auto-generated constructor stub
	}

	/**
	 * A player's special increases their attack power by 2.
	 */
	@Override
	public void special() {
		addPower(2);
	}
	
	public void discard() {
		if (!(weapon instanceof Sword)) {
			discard();
			weapon = s;
		}
	}

}
