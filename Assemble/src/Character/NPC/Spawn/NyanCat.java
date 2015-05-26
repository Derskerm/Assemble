package Character.NPC.Spawn;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class NyanCat extends Spawn {

	public NyanCat(int x, int y, boolean right) {
		super("lib//Nyan_cat_animated.gif", x, y, 30, 24, 100, 26, right);
		if (!right) {
			super.setImage(new ImageIcon("lib//Nyan_cat_animated_left.gif").getImage());
		}
		gravity = 0;
	}

	public void act(ArrayList<Shape> obstacles) {
		if (getPlane() != null && !t.isRunning()) {
			t.start();
		}
		if (isRight)
			this.walk(1);
		else
			this.walk(-1);
		attack();
		double xCoord = x;
		super.act(obstacles);
		if (xCoord == x) {
			removeFromGrid();
		}
	}
	
	public void draw(Graphics g, ImageObserver io) {
		if (isRight)
			g.drawImage(getImage(),(int)(x - 30),(int)y,(int)(width + 30),(int)height,io);
		else
			g.drawImage(getImage(),(int)x,(int)y,(int)(width + 30),(int)height,io);
	}
	
}
