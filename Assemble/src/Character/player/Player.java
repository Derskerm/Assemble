package Character.player;

import java.awt.Image;
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
	
	protected boolean injured = false;
	protected boolean attacking = false;
	protected int count = 100;
	protected int attackCount = 20;
	protected Weapon weapon;
	protected Image[] images;

	/**
	 * 
	 * @param filenames in the order still, run right, run left, attack right, attack left, injured left, injured right, attackblock
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param maxHealth
	 * @param power
	 * @param jumpStrength
	 */
	public Player(String[] filenames, int x, int y, int w, int h,
			double maxHealth, double power, double jumpStrength) {
		super(filenames[0], x, y, w, h, maxHealth, power, jumpStrength);
		
		weapon = null;
		images = new Image[7];
		images[0] = new ImageIcon(filenames[0]).getImage();
		images[1] = new ImageIcon(filenames[1]).getImage();
		images[2] = new ImageIcon(filenames[2]).getImage();
		images[3] = new ImageIcon(filenames[3]).getImage();
		images[4] = new ImageIcon(filenames[4]).getImage();
		images[5] = new ImageIcon(filenames[5]).getImage();
		images[6] = new ImageIcon(filenames[6]).getImage();
		// TODO Auto-generated constructor stub
	}
	
	public abstract void special();

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
					super.setImage(images[0]);
					injured = false;
					count = 0;
				}
			}
		}
	}
	
	/**
	 * Attacks Characters of type Enemy within a radius of 50
	 */
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
		double xCoord = x;
		double yCoord = y;
		double yCoordAfter = y + yVelocity;
		if (yCoordAfter > yCoord) {
			Rectangle2D.Double stretchY = new Rectangle2D.Double(xCoord,Math.min(yCoord,yCoordAfter),width,height+Math.abs(yVelocity));
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
						super.setImage(images[3]);
					else
						super.setImage(images[4]);
				} else {
					super.setImage(images[0]);
				}
			} else {
				if (isRight)
						super.setImage(images[1]);
				if (!isRight)
						super.setImage(images[2]);
			}
		} else {
			if (isRight) {
				super.setImage(images[5]);
			} else {
				super.setImage(images[6]);
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
		
	}
	
}