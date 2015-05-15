package Character;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import AnimationDemo.MovingImage;
import Block.GoalBlock;


public abstract class AbstractCharacter extends MovingImage implements Character {

	private double health;
	private final double MAX_HEALTH;
	private double power;
	private double xAcc;
	private double xVelocity, yVelocity;
	private boolean onASurface;
	private double friction;
	private double gravity;
	private double jumpStrength;
	
	public AbstractCharacter(String filename, int x, int y, int w, int h, double maxHealth, double power) {
		super(filename, x, y, w, h);
		health = maxHealth;
		MAX_HEALTH = maxHealth;
		this.power = power;
		xVelocity = 0;
		yVelocity = 0;
		onASurface = false;
		gravity = 0.7;
		friction = .85;
		jumpStrength = 15;
		xAcc = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void jump() {
		if (onASurface)
			yVelocity -= jumpStrength;
		
	}

	@Override
	public void walk(int amt) {
		xAcc = amt;
		
	}

	@Override
	public void attack(Enemy other) {
		other.addHealth(power);
	}

	@Override
	public boolean addHealth(double amt) {
		health -= amt;
		return health <= 0;
	}

	public double healthLeft() {
		return health;
	}

	@Override
	public double totalHealth() {
		// TODO Auto-generated method stub
		return MAX_HEALTH;
	}

	@Override
	public void act(ArrayList<Shape> obstacles) {
		double xCoord = getX();
		double yCoord = getY();
		double width = getWidth();
		double height = getHeight();
		
		

		// ***********Y AXIS***********

		yVelocity += gravity; // GRAVITY
		double yCoord2 = yCoord + yVelocity;

		Rectangle2D.Double stretchY = new Rectangle2D.Double(xCoord,Math.min(yCoord,yCoord2),width,height+Math.abs(yVelocity));

		onASurface = false;
		
		if (yVelocity > 0) {
			Shape standingSurface = null;
			for (Shape s : obstacles) {
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
	
	public abstract void special();

}

/*
 * package AnimationDemo;



import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;

import javax.swing.JOptionPane;

import Block.GoalBlock;

public class Mario3 extends MovingImage {

	public static final int MARIO_WIDTH = 40;
	public static final int MARIO_HEIGHT = 60;

	private double xAcc;
	private double xVelocity, yVelocity;
	private boolean onASurface;
	private double friction;
	private double gravity;
	private double jumpStrength;

	public Mario3(int x, int y) {
		super("character.png", x, y, MARIO_WIDTH, MARIO_HEIGHT);
		xVelocity = 0;
		yVelocity = 0;
		onASurface = false;
		gravity = 0.7;
		friction = .85;
		jumpStrength = 15;
		xAcc = 0;
	}

	// METHODS
	public void walk(int dir) {
		xAcc = dir;
	}

	public void jump() {
		if (onASurface)
			yVelocity -= jumpStrength;
	}

	public void act(ArrayList<MovingImage> obstacles) {
		
		double xCoord = getX();
		double yCoord = getY();
		double width = getWidth();
		double height = getHeight();
		
		

		// ***********Y AXIS***********

		yVelocity += gravity; // GRAVITY
		double yCoord2 = yCoord + yVelocity;

		Rectangle2D.Double stretchY = new Rectangle2D.Double(xCoord,Math.min(yCoord,yCoord2),width,height+Math.abs(yVelocity));

		onASurface = false;
		
		if (yVelocity > 0) {
			Shape standingSurface = null;
			for (Shape s : obstacles) {
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

		for (Shape s : obstacles) {
			if (s instanceof GoalBlock && (s.intersects(stretchY) || s.intersects(stretchX))) {
				JOptionPane.showMessageDialog(null, "You win!!!");
				System.out.println("YAY!");
			}
		}
		
		moveToLocation(xCoord2,yCoord2);

	}


}
*/
