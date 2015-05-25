package Character.NPC.Spawn;

import java.awt.geom.Rectangle2D;

import Character.Character;
import AnimationDemo.GameImage;
import AnimationDemo.MovingImage;
import Character.NPC.NPC;
import Character.NPC.Enemy.Enemy;
import Character.player.Player;

public class Spawn extends NPC {

	public Spawn(String filename, int x, int y, int w, int h, double maxHealth,
			double power, boolean right) {
		super(filename, x, y, w, h, maxHealth, power, 0, right);
		// TODO Auto-generated constructor stub
	}
	
	public void attack() {
		Rectangle2D.Double rekt;
		rekt = new Rectangle2D.Double(this.getCenterX()-width,this.getCenterY()-height,width*2, height*2);
		GameImage[] images = getPlane().getWithinRect(rekt.getBounds());
		for (GameImage gi : images) {
			if (gi instanceof Enemy) {
				if (gi.getMinY() <= this.getMaxY() && gi.getMaxY() >= this.getMinY()
						&& (gi.getMaxX() - this.getMinX() < -5 || gi.getMinX() - this.getMaxX() < 5) ||
						gi.getMinX() <= this.getMaxX() && gi.getMaxX() >= this.getMinX()
						&& (gi.getMaxY() - this.getMinY() < -5 || gi.getMinY() - this.getMaxY() < 5))
					((Character)gi).addHealth(-power, this);
			}
		}
	}


}
