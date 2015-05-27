package Character;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import AnimationDemo.GameImage;
import AnimationDemo.MovingImage;
import Character.NPC.Spawn.Cat;
import Character.NPC.Spawn.NyanCat;
import Character.player.Player;
import Item.Item;
import Item.Weapon.Weapon;
import Plane.Plane;

public abstract class Character extends GameImage {

	private double health;
	private final double MAX_HEALTH;
	protected double power;
	protected double xAcc;
	protected double xVelocity;
	protected double yVelocity;
	protected boolean onASurface;
	protected double friction;
	protected double gravity;
	protected double jumpStrength;
	protected boolean isRight;
	
	/**
	 * Creates a new Character object
	 * @param filename the name of the source file for the image
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param w the width of the Character
	 * @param h the height of the Character
	 * @param maxHealth the maximum health the Character can have
	 * @param power the amount of damage the Character makes with an attack
	 * @param jumpStrength the maximum height reached with a jump
	 */
	public Character(String filename, int x, int y, int w, int h, double maxHealth, double power, double jumpStrength) {
		super(filename, x, y, w, h);
		setHealth(maxHealth);
		MAX_HEALTH = maxHealth;
		this.power = power;
		xVelocity = 0;
		yVelocity = 0;
		onASurface = false;
		gravity = 0.7;
		friction = .85;
		this.jumpStrength = jumpStrength;
		xAcc = 0;
		isRight = true;
	}
	
	/**
	 * Moves the Character upwards vertically
	 * @pre the Character is in the plane
	 */
	public void jump() {
		if (onASurface)
			yVelocity = -jumpStrength;
	}
	
	/**
	 * Moves the Character horizontally
	 * @pre the Character is in the plane
	 * @param amt the distance moved
	 */
	public void walk(double amt) {
		xAcc = amt;
//		if (amt != 0)
//			isRight = amt > 0;
	}
	
	/**
	 * Makes this Character attack
	 */
	public abstract void attack();
	
	/**
	 * Adds health to the Character
	 * @param power the amount of health points added
	 */
	public void addHealth(double power, GameImage gi) {
		if (gi != null || gi instanceof Item) {
			setHealth(getHealth() + power);
			if (getHealth() > MAX_HEALTH) {
				setHealth(MAX_HEALTH);
			}
	//		if (power < 0) {
	//			xVelocity = -1;
	//		}
			if (getHealth() <= 0) {
				this.removeFromGrid();
			}
		}
	}
	
	/**
	 * @return the maximum health the character can have
	 */
	public double totalHealth() {
		return MAX_HEALTH;
	}
	
	/**
	 * Makes the Character move and react to obstacles
	 * @param obstacles the Shapes with which this Character will interact
	 */
	public void act(ArrayList<Shape> obstacles) {
		double xCoord = getX();
		double yCoord = getY();
		double width = getWidth();
		double height = getHeight();
		
		if (yVelocity < 0)
			System.out.println(yVelocity + "," + y);

		// ***********Y AXIS***********

		yVelocity += gravity; // GRAVITY
		double yCoord2 = yCoord + yVelocity;

		Rectangle2D.Double stretchY = new Rectangle2D.Double(xCoord,Math.min(yCoord,yCoord2),width,height+Math.abs(yVelocity));

		onASurface = false;
		
		if (yVelocity > 0) {
			Shape standingSurface = null;
			for (Shape s : obstacles) {
				if (!s.equals(this))
					if (s.intersects(stretchY)) {
						onASurface = true;
						standingSurface = s;
						yVelocity = 0;
					}
			}
			if (standingSurface != null) {
				Rectangle r = standingSurface.getBounds();
				yCoord2 = r.getY()-height;
			}
		} else if (yVelocity < 0) {
			Shape headSurface = null;
			for (Shape s : obstacles) {
				if (!s.equals(this))
					if (s.intersects(stretchY)) {
						headSurface = s;
						yVelocity = 0;
					}
			}
			if (headSurface != null) {
				Rectangle r = headSurface.getBounds();
				yCoord2 = r.getY()+r.getHeight();
			}
		}

		if (Math.abs(yVelocity) < .5)
			yVelocity = 0;

		// ***********X AXIS***********

		if (xVelocity <= 10 && xVelocity >= -10)
			xVelocity += xAcc;
		xVelocity *= friction;

		double xCoord2 = xCoord + xVelocity;

		Rectangle2D.Double stretchX = new Rectangle2D.Double(Math.min(xCoord,xCoord2),yCoord2,width+Math.abs(xVelocity),height);

		if (xVelocity > 0) {
			Shape rightSurface = null;
			for (Shape s : obstacles) {
				if (!s.equals(this))
					if (s.intersects(stretchX)) {
						rightSurface = s;
						xVelocity = 0;
					}
			}
			if (rightSurface != null) {
				Rectangle r = rightSurface.getBounds();
				xCoord2 = r.getX()-width;
			}
		} else if (xVelocity < 0) {
			Shape leftSurface = null;
			for (Shape s : obstacles) {
				if (!s.equals(this))
					if (s.intersects(stretchX)) {
						leftSurface = s;
						xVelocity = 0;
					}
			}
			if (leftSurface != null) {
				Rectangle r = leftSurface.getBounds();
				xCoord2 = r.getX()+r.getWidth();
			}
		}


		if (Math.abs(xVelocity) < .5)
			xVelocity = 0;
		
		moveToLocation(xCoord2,yCoord2);
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}	
}