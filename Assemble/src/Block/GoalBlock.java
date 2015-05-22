package Block;

import java.awt.geom.Rectangle2D;

import javax.swing.JOptionPane;

public class GoalBlock extends Block {
	
	private boolean hasWon = false;
	
	/**
	 * Creates a new GoalBlock
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public GoalBlock(int x, int y) {
		super(false,"lib//flag_green.png",x,y);
	}
	
	/**
	 * @return true if it has been triggered, false otherwise
	 */
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

	/**
	 * Resets whether
	 */
	public void reset() {
		hasWon = false;
	}
}
