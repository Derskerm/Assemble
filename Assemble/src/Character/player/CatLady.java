package Character.player;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import AnimationDemo.GameImage;
import Block.AttackBlock;
import Character.NPC.Enemy.Enemy;
import Character.NPC.Spawn.Cat;
import Character.NPC.Spawn.CatBlock;
import Character.NPC.Spawn.NyanCat;
import Plane.Plane;

public class CatLady extends Player {

	public CatLady(int x, int y) {
		super(new String[]{"lib//Cat Lady standing-2.png","lib//CL fly right.gif","lib//CL fly left.gif","lib//CL fly right.gif","lib//CL fly left.gif","lib//CL fly right.gif","lib//CL fly left.gif"}, x, y, 35, 50, 100, 8, 13);
		gravity = 1;
	}
	
	public void attack() {
		attacking = true;
		if (isRight)
			super.setImage(images[3]);
		else
			super.setImage(images[4]);
		Plane p = getPlane();
		NyanCat c;
		if (isRight) {
			c = new NyanCat((int)(this.getMaxX() + 12), (int)(this.getMinY() + 12), true);
		} else {
			c = new NyanCat((int)(this.getMinX() - 30 - 12), (int)(this.getMinY() + 12), false);
		}
		c.insertIntoPlane(getPlane());
	}

	/**
	 * Spawns a new Cat that attacks enemies.
	 */
	public void special() {
		if (onASurface)
			if (isRight)
				(new CatBlock((int)getMaxX() + 5, (int)getMaxY()-24)).insertIntoPlane(getPlane());
			else
				(new CatBlock((int)getMinX() - 30, (int)getMaxY()-24)).insertIntoPlane(getPlane());
	}
	
	public void act(ArrayList<Shape> obstacles) {
		double xCoord = x;
		double yCoord = y;
		
		super.act(obstacles);
		
		double xCoord2 = x;
		double yCoord2 = y;
		
		boolean still = yCoord == yCoord2 && xCoord == xCoord2;
		
		if (still && !injured && !attacking) {
			if (isRight) {
				super.setImage(new ImageIcon("lib//CL fly right.gif").getImage());
			} else {
				super.setImage(new ImageIcon("lib//CL fly left.gif").getImage());
			}
		}
	}
}
