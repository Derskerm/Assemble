package Character.player;

import Character.AbstractCharacter;
import Item.Weapon.Sword;

public class Player extends AbstractCharacter {
	
	private Sword s;
	
	public Player(int x, int y) {
		super("lib//character.png", x, y, 25, 50, 100, 10);
		s = new Sword(0, 0);
		this.pickUpItem(s);
		// TODO Auto-generated constructor stub
	}

	/**
	 * A player's special increases their attack power by 2.
	 */
	@Override
	public void special() {
		addPower(2);
	}

}
