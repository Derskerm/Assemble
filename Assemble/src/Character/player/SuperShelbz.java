package Character.player;

import java.awt.Shape;
import java.util.ArrayList;

public class SuperShelbz extends Player {

	boolean doubleJumped;
	
	public SuperShelbz(int x, int y) {
		super("lib//Super Shelbz.png", x, y, 19, 48, 100, 5, 12);
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
	
	public void act(ArrayList<Shape> obstacles) {
		super.act(obstacles);
		if (onASurface)
			doubleJumped = false;
	}

}
