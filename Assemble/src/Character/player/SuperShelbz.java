package Character.player;

import java.awt.Shape;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class SuperShelbz extends Player {

	boolean doubleJumped;
	
	public SuperShelbz(int x, int y) {
		super("lib//Super Shelbz.png", x, y, 35, 50, 100, 5, 12);
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
		double xCoord = x;
		double yCoord = y;
		
		super.act(obstacles);
		
		double xCoord2 = x;
		double yCoord2 = y;
		
		boolean still = xCoord == xCoord2;
		
		if (xCoord2 > xCoord && !isRight) {
			isRight = true;
		}
		if (xCoord2 < xCoord && isRight) {
			isRight = false;
		}
		
		if (still) {
			super.setImage(new ImageIcon("lib//Super Shelbz-2.png").getImage());
		} else {
			if (isRight)
					super.setImage(new ImageIcon("lib//SS run right.gif").getImage());
			if (!isRight)
					super.setImage(new ImageIcon("lib//SS run left.gif").getImage());
		}

		
		
		if (onASurface)
			doubleJumped = false;
	}

}
