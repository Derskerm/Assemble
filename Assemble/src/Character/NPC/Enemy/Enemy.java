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
		if (right) {
			rekt = new Rectangle2D.Double(this.getMaxX(),this.getMinY(),25,25);
		} else {
			rekt = new Rectangle2D.Double(this.getMinX()-25,this.getMinY(),25,25);
		}
		GameImage[] images = getPlane().getWithinRect(rekt.getBounds());
		for (GameImage gi : images) {
			if (gi instanceof Player || gi instanceof Spawn) {
				((Character)gi).addHealth(-power);
			}
		}
	}
}
