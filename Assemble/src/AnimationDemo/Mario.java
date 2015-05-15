package AnimationDemo;

import java.awt.*;
import javax.swing.*;
import Block.Block;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.util.*;

public class Mario extends MovingImage {

	public static final int MARIO_WIDTH = 25;
	public static final int MARIO_HEIGHT = 50;
	
	private double xvel, yvel;
	private boolean onSurface = false;
	private boolean doubleJumped = false;
	
	public Mario(int x, int y) {
		super("lib//character.png", x, y, MARIO_WIDTH, MARIO_HEIGHT);
		xvel = 0;
		yvel = 0;
	}

	// METHODS
	public void walk(int dir) {
		xvel = dir * 5;
	}

	public void jump() {
		if (onSurface)
			yvel += -13;
		else if (!doubleJumped) {
			yvel += -6;
			doubleJumped = true;
		}
	}

	public void act(ArrayList<Block> obstacles) {
		Rectangle2D.Double r = new Rectangle2D.Double(x, y, width + xvel, height + yvel);
		boolean isOnSurface = false;
		for (Block b : obstacles) {
			if (b.intersects(r)) {
				isOnSurface = true;
				doubleJumped = false;
				Rectangle2D rect;
				rect = new Rectangle2D.Double(x, b.getMinY() - height, height, width);
				y = rect.getMinY();
				yvel = 0;
			}
		}
		onSurface = isOnSurface;
		if (!onSurface) {
			yvel += 0.5;
		}
		y += yvel;
		x += xvel;
	}


}
