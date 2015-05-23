package Character.NPC.Spawn;

import java.awt.geom.Rectangle2D;
import Character.Character;
import AnimationDemo.GameImage;
import AnimationDemo.MovingImage;
import Character.NPC.NPC;
import Character.NPC.Enemy.Enemy;

public class Spawn extends NPC {

	public Spawn(String filename, int x, int y, int w, int h, double maxHealth,
			double power, boolean right) {
		super(filename, x, y, w, h, maxHealth, power, 0, right);
		// TODO Auto-generated constructor stub
	}
	
	public void attack() {
		Rectangle2D.Double rekt;
		if (right) {
			rekt = new Rectangle2D.Double(this.getMaxX(),this.getMinY(),25,25);
		} else {
			rekt = new Rectangle2D.Double(this.getMinX()-25,this.getMinY(),25,25);
		}
		GameImage[] images = getPlane().getWithinRect(rekt.getBounds());
		for (GameImage gi : images) {
			if (gi instanceof Enemy) {
				((Character)gi).addHealth(-power);
			}
		}
	}


}
