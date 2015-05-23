package Block;

import java.awt.geom.Rectangle2D;
import Character.player.Player;

public class ToggleBlock extends Block {

	private boolean toggled;
	
	public ToggleBlock(String filename, int x, int y, boolean toggled) {
		super(false,filename, x, y);
		this.toggled = toggled;
	}
	
	public boolean intersects(Rectangle2D r) {
		Rectangle2D rekt = this.getBounds2D();
		if (r instanceof Player && rekt.intersects(r)) {
			toggled = !toggled;
		}
		return super.intersects(r);
	}
	
	public boolean toggled() {
		return toggled;
	}

}
