package Character.player;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import AnimationDemo.GameImage;
import AnimationDemo.MovingImage;
import Block.AttackBlock;
import Block.Block;
import Character.Character;
import Character.NPC.Enemy.Enemy;
import Item.Item;
import Item.Upgrade.Upgrade;
import Item.Weapon.Weapon;
import Plane.Plane;

public abstract class Player extends Character {
	
	protected Weapon weapon;

	public Player(String filename, int x, int y, int w, int h,
			double maxHealth, double power, double jumpStrength) {
		super(filename, x, y, w, h, maxHealth, power, jumpStrength);
		weapon = null;
		// TODO Auto-generated constructor stub
	}
	
	public abstract void special();

	/**
	 * Attacks Characters of type Enemy within a radius of 50
	 */
	public void attack() {
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
			}
		}
	}
	
	/**
	 * Adds to the power this Character attacks with
	 * @param power
	 */
	public void addPower(double power) {
		super.power += power;
	}
	
	/**
	 * The Character uses the item
	 * @param i the item used
	 */
	public void useItem(Item i) {
		if (i instanceof Weapon) {
			if (weapon == null) {
				weapon = (Weapon)i;
				weapon.use();
			} else {
				weapon.discard();
				weapon.moveToLocation(this.getMinX(), this.getMaxY() - weapon.height);
				weapon.insertIntoPlane(this.getPlane());
				weapon = (Weapon)i;
				weapon.use();
			}
		} else if (i instanceof Upgrade) {
			i.use();
			Upgrade m = (Upgrade)i;
			addPower(m.getPowerBonus());
			addHealth(m.getHealthBonus(),m);
		}
	}
	
	
	/**
	 * Any weapon that is held is discarded
	 */
	public void discardItem() {
		weapon.discard();
		weapon = null;
	}
	
	public void act(ArrayList<Shape> obstacles) {
		double yCoord = y;
		double xCoord = x;
		double yCoord2 = y + yVelocity;
		if (yCoord2 > yCoord) {
			Rectangle2D.Double stretchY = new Rectangle2D.Double(xCoord,Math.min(yCoord,yCoord2),width,height+Math.abs(yVelocity));
			GameImage[] gi = getPlane().getWithinRect(stretchY.getBounds());
			for (int i = 0; i < gi.length; i++) {
				if (gi[i] instanceof Enemy) {
					Enemy e = (Enemy)gi[i];
					e.addHealth(-e.totalHealth(), this);
				}
			}
		}
		Rectangle2D.Double around = new Rectangle2D.Double(xCoord-5, yCoord-5, width+10, height+10);
		GameImage[] gi = getPlane().getWithinRect(around.getBounds());
		for (int i = 0; i < gi.length; i++) {
			if (gi[i] instanceof Item) {
				Item e = (Item)gi[i];
				this.useItem(e);
			}
		}
		super.act(obstacles);
	}
	
}

/*
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
	 *
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
*/