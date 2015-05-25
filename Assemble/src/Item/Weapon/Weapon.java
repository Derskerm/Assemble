package Item.Weapon;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import AnimationDemo.GameImage;
import AnimationDemo.MovingImage;
import Character.Character;
import Character.player.Player;
import Item.Item;

public abstract class Weapon extends Item {

	private int power;
	private boolean used;
	
	public Weapon(String filename, int x, int y, int w, int h, int power) {
		super(filename, x, y, w, h);
		used = false;
		this.power = power;
	}

	public int getPower() {
		return power;
	}
	
	public void use() {
		this.used = true;
	}
	
	public void discard() {
		this.used = false;
	}
	
	public boolean isUsed() {
		return used;
	}
	
	public boolean intersects(Rectangle2D r) {
		if (used) {
			return false;
		} else {
			return super.intersects(r);
		}
	}
	
	public void draw(Graphics g, ImageObserver io) {
		if (!used) {
			super.draw(g, io);
		}
	}
}
