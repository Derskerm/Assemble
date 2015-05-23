package Block;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import Character.player.Player;

public class TriggerBlock extends Block {

	private boolean triggered;
	
	public TriggerBlock(String filename, int x, int y) {
		super(false, filename, x, y);
		triggered = false;
	}

	public boolean intersects(Rectangle2D r) {
		Rectangle2D rekt = this.getBounds2D();
		if (r instanceof Player && rekt.intersects(r)) {
			triggered = true;
		}
		return super.intersects(r);
	}
	
	public boolean triggered() {
		return triggered;
	}
	
	public void reset() {
		triggered = false;
	}
}
