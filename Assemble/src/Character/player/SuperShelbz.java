package Character.player;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import AnimationDemo.GameImage;
import Block.AttackBlock;
import Character.NPC.Enemy.Enemy;
import Item.Item;
import Plane.Plane;

public class SuperShelbz extends Player {

	boolean doubleJumped;
	
	
	public SuperShelbz(int x, int y) {
		super(new String[]{"lib//Super Shelbz-2.png", "lib//SS run right.gif", "lib//SS run left.gif", "lib//SS attack right.png", "lib//SS attack left.png", "lib//SS injured right.gif", "lib//SS injured left.gif"}, x, y, 35, 50, 100, 10, 13);
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
	
	public void attack() {
		attacking = true;
		boolean enemies = false;
		if (isRight)
			super.setImage(images[3]);
		else
			super.setImage(images[4]);
		Plane p = getPlane();
		Rectangle2D r;
		if (isRight) {
			r = new Rectangle2D.Double(this.getMaxX(), this.getMinY(), 50, 50);
		} else {
			r = new Rectangle2D.Double(this.getMinX() - 50, this.getMinY(), 50, 50);
		}
		GameImage[] neighbors = p.getWithinRect(r.getBounds());
		for (GameImage mi : neighbors) {
			if (mi instanceof Enemy) {
				Enemy e = (Enemy)mi;
				e.addHealth(-power,this);
				enemies = true;
				AttackBlock b = new AttackBlock("lib//glitch.gif", (int)e.getX(), (int)e.getY());
				b.insertIntoPlane(getPlane());
			}
		}
		if (!enemies) {
			AttackBlock b = new AttackBlock("lib//glitch.gif", (int)r.getX() + 12, (int)r.getY() + 12);
			b.insertIntoPlane(getPlane());
		}
	}
	
	public void act(ArrayList<Shape> obstacles) {
		super.act(obstacles);
		if (onASurface)
			doubleJumped = false;
	}
	
	/*public void act(ArrayList<Shape> obstacles) {
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
				if (attacking) {
					if (isRight)
						super.setImage(new ImageIcon("lib//SS attack right.png").getImage());
					else
						super.setImage(new ImageIcon("lib//SS attack left.png").getImage());
				} else {
					super.setImage(new ImageIcon("lib//Super Shelbz-2.png").getImage());
				}
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
				injured = false;
				count = 50;
			}
		}
		if (attacking) {
			attackCount--;
			if (attackCount <= 0) {
				attacking = false;
				attackCount = 20;
			}
		}
		
		if (onASurface)
			doubleJumped = false;
	}*/

}
