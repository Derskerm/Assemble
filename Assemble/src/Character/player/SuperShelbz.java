package Character.player;

import java.awt.Shape;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import AnimationDemo.GameImage;
import Item.Item;

public class SuperShelbz extends Player {

	boolean doubleJumped;
	boolean injured = false;
	int count = 100;
	
	
	public SuperShelbz(int x, int y) {
		super("lib//Super Shelbz-2.png", x, y, 35, 50, 100, 10, 12);
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
	
	public void addHealth(double power, GameImage gi) {
		if (gi.getPlane() != null || gi instanceof Item) {
			if (!injured) {
				if (power < 0) {
					injured = true;
					if (isRight) {
						xVelocity = -1;
					} else {
						xVelocity = 1;
					}
					xAcc = 0;
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (gi.getPlane() != null || gi instanceof Item) {
						super.addHealth(power,gi);
				} else {
					super.setImage(new ImageIcon("lib//Super Shelbz-2.png").getImage());
					count = 0;
					injured = false;
				}
			}
		}
	}
	
	public void act(ArrayList<Shape> obstacles) {
		double xCoord = x;
		double yCoord = y;
		
		//y += 8;
		//width = 19;
		super.act(obstacles);
		//y -= 8;
		//width = 35;
		
		double xCoord2 = x;
		double yCoord2 = y;
		
		boolean still = xCoord == xCoord2;
		
		if (!injured) {
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
		} else {
			if (isRight) {
				super.setImage(new ImageIcon("lib//SS injured right.gif").getImage());
			} else {
				super.setImage(new ImageIcon("lib//SS injured left.gif").getImage());
			}
			count--;
			if (count <= 0) {
				injured = !injured;
				count = 100;
			}
		}
		
		if (onASurface)
			doubleJumped = false;
	}

}
