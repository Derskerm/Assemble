package Character.NPC.Enemy;

import java.awt.geom.Rectangle2D;

import AnimationDemo.GameImage;
import Character.NPC.NPC;
import Character.NPC.Spawn.Spawn;
import Character.player.Player;
import Character.Character;

public abstract class Enemy extends NPC {

	public Enemy(String filename, int x, int y, int w, int h, double maxHealth,
			double power, double jumpStrength, boolean right) {
		super(filename, x, y, w, h, maxHealth, power, jumpStrength, right);
		// TODO Auto-generated constructor stub
	}

	public void attack() {
		Rectangle2D.Double rekt;
		rekt = new Rectangle2D.Double(this.getCenterX()-width,this.getCenterY()-height,width*2, height*2);
		GameImage[] images = getPlane().getWithinRect(rekt.getBounds());
		for (int i = 0; i < images.length; i++) {
			GameImage gi = images[i];
			if (gi instanceof Player || gi instanceof Spawn) {
				if (gi.getMinY() <= this.getMaxY() && gi.getMaxY() >= this.getMinY()
						&& (gi.getMaxX() - this.getMinX() <= -1 || gi.getMinX() - this.getMaxX() <= 1) ||
						gi.getMinX() <= this.getMaxX() && gi.getMaxX() >= this.getMinX()
						&& (gi.getMaxY() - this.getMinY() <= -1 ))//|| gi.getMinY() - this.getMaxY() <= 1))
					((Character)gi).addHealth(-power,this);
			}
		}
	}
}
