package Character.player;

import Character.AbstractCharacter;
import Character.NPC.Spawn.Cat;

public class SuperShelbz extends AbstractCharacter {

	boolean doubleJumped;
	
	public SuperShelbz(int x, int y) {
		super("lib//Shelbzzz.png", x, y, 25, 50, 100, 5);
		doubleJumped = true;
	}

	/**
	 * Hacks into the system to allow for double jumping.
	 */
	public void special() {
		if (!doubleJumped) {
			yVelocity =- jumpStrength;
			doubleJumped = true;
		}
	}
	
	public void jump() {
		super.jump();
		doubleJumped = false;
	}

}
