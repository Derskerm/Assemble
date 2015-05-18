package Block;

import java.awt.geom.Rectangle2D;

import javax.swing.JOptionPane;

public class GoalBlock extends Block {
	
	private boolean hasWon = false;
	
	public GoalBlock(int x, int y) {
		super(false,"lib//flag_green.png",x,y);
	}
	
	public boolean hasWon() {
		return hasWon;
	}
	
	public boolean intersects(Rectangle2D r) {
		Rectangle2D rekt = new Rectangle2D.Double(this.getBounds().getCenterX(), this.getBounds().getCenterY(), 1, 1);
		if (rekt.intersects(r)) {
			hasWon = true;
		}
		return super.intersects(r);
	}

	public void reset() {
		hasWon = false;
	}
}
