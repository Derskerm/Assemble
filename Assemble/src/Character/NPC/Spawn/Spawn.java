package Character.NPC.Spawn;

import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.Timer;

import Character.Character;
import AnimationDemo.GameImage;
import AnimationDemo.MovingImage;
import Character.NPC.NPC;
import Character.NPC.Enemy.Enemy;
import Character.player.Player;
import Plane.Plane;

public class Spawn extends NPC implements ActionListener {
	
	private Timer t = new Timer(1000, this);
	
	public Spawn(String filename, int x, int y, int w, int h, double maxHealth,
			double power, boolean right) {
		super(filename, x, y, w, h, maxHealth, power, 0, right);
	}
	
	public void attack() {
		Rectangle2D.Double rekt;
		rekt = new Rectangle2D.Double(this.getCenterX()-width,this.getCenterY()-height,width*2, height*2);
		if (getPlane() != null) {
			GameImage[] images = getPlane().getWithinRect(rekt.getBounds());
			for (GameImage gi : images) {
				if (gi instanceof Enemy) {
					if (gi.getPlane() != null && (gi.getMinY() <= this.getMaxY() && gi.getMaxY() >= this.getMinY()
							&& (gi.getMaxX() - this.getMinX() < -5 || gi.getMinX() - this.getMaxX() < 5) ||
							gi.getMinX() <= this.getMaxX() && gi.getMaxX() >= this.getMinX()
							&& (gi.getMaxY() - this.getMinY() < -5 || gi.getMinY() - this.getMaxY() < 5))) {
						((Character)gi).addHealth(-power, this);
					}
				}
			}
		}
	}

	public void insertIntoPlane(Plane p) {
		super.insertIntoPlane(p);
		t.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		removeFromGrid();
		t.stop();
	}

	public void act(ArrayList<Shape> obstacles) {
		if (getPlane() != null && !t.isRunning()) {
			t.start();
		}
		super.act(obstacles);
	}

}
