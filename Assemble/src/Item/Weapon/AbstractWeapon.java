package Item.Weapon;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import AnimationDemo.MovingImage;
import Character.AbstractCharacter;
import Character.player.Player;
import Character.Character;

public abstract class AbstractWeapon extends MovingImage implements Weapon {

	private int power;
	private boolean used;
	private Character p;
	
	public AbstractWeapon(String filename, int x, int y, int w, int h, int power) {
		super(filename, x, y, w, h);
		p = null;
		used = false;
		this.power = power;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return power;
	}
	
	public void use() {
		this.used = true;
	}
	
	public void setPlayer(Character p) {
		this.p = p;
		use();
	}
	
	public void discard() {
		x = p.getBounds2D().getMinX();
		y = p.getBounds2D().getMaxY() - this.height;
		p = null;
		this.used = false;
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
