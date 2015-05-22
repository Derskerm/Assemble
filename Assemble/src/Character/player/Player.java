package Character.player;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import AnimationDemo.GameImage;
import AnimationDemo.MovingImage;
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
				e.addHealth(-power);
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
				weapon.removeFromGrid();
			} else {
				weapon.discard();
				weapon.moveToLocation(this.getMinX(), this.getMaxY() - weapon.height);
				weapon.insertIntoPlane(this.getPlane());
				weapon = (Weapon)i;
				weapon.use();
			}
		} else if (i instanceof Upgrade) {
			i.use();
			addPower(((Upgrade) i).getPowerBonus());
			addHealth(((Upgrade)i).getHealthBonus());
		}
	}
	
	
	/**
	 * Any weapon that is held is discarded
	 */
	public void discardItem() {
		weapon.discard();
		weapon = null;
	}
	
}