package Character.player;

import java.awt.Shape;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Character.NPC.Spawn.Cat;

public class CatLady extends Player {

	public CatLady(int x, int y) {
		super("lib//Cat Lady standing-2.png", x, y, 29, 34, 100, 8, 13);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Spawns a new Cat that attacks enemies.
	 */
	public void special() {
		if (onASurface)
			if (isRight)
				(new Cat((int)getMaxX() + 5, (int)getMaxY()-25, true)).insertIntoPlane(getPlane());
			else
				(new Cat((int)getMinX() - 30, (int)getMaxY()-25, false)).insertIntoPlane(getPlane());
	}
	
	public void act(ArrayList<Shape> obstacles) {
		double xCoord = x;
		double yCoord = y;
		
		super.act(obstacles);
		
		double xCoord2 = x;
		double yCoord2 = y;
		
		boolean still = yCoord == yCoord2 && xCoord == xCoord2;
		
		if (xCoord2 > xCoord && !isRight) {
			isRight = true;
		}
		if (xCoord2 < xCoord && isRight) {
			isRight = false;
		}
		

		if (isRight)
			if (still)
				super.setImage(new ImageIcon("lib//Cat Lady standing-2.png").getImage());
			else
				super.setImage(new ImageIcon("lib//CL fly right.gif").getImage());
		
		if (!isRight)
			if (still)
				super.setImage(new ImageIcon("lib//Cat Lady standing left.png").getImage());
			else
				super.setImage(new ImageIcon("lib//CL fly left.gif").getImage());
		
	}

}
