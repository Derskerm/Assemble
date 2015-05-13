

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.*;

public class Mario extends MovingImage {

	public static final int MARIO_WIDTH = 40;
	public static final int MARIO_HEIGHT = 60;
	
	public Mario(int x, int y) {
		super("lib\\character.png", x, y, MARIO_WIDTH, MARIO_HEIGHT);
	}

	// METHODS
	public void walk(int dir) {
		// WALK!
	}

	public void jump() {
		// JUMP!
	}

	public void act(ArrayList<Shape> obstacles) {
		// FINISH ME!
	}


}
