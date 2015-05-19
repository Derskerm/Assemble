package Character.NPC;

import java.awt.Shape;
import java.util.ArrayList;

import Character.Character;

public class NPC extends Character {

	boolean right;
	
	
	public NPC(String filename, int x, int y, int w, int h, double maxHealth,
			double power, double jumpStrength, boolean right) {
		super(filename, x, y, w, h, maxHealth, power, jumpStrength);
		this.right = right;
	}

	public void attack() {
		
	}

	public void act(ArrayList<Shape> obstacles) {
		if (right)
			this.walk(1);
		else
			this.walk(-1);
		super.act(obstacles);
	}
	
	

}
