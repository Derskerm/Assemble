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
	boolean injured = false;
	boolean attacking = false;
	int count = 100;
	int attackCount = 20;
	
	
	public SuperShelbz(int x, int y) {
		super("lib//Super Shelbz-2.png", x, y, 35, 50, 100, 10, 13);
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
					injured = false;
					count = 0;
				}
			}
		}
	}
	
	public void attack() {
		attacking = true;
		boolean enemies = false;
		if (isRight)
			super.setImage(new ImageIcon("lib//SS attack right.png").getImage());
		else
			super.setImage(new ImageIcon("lib//SS attack left.png").getImage());
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
	}

}
