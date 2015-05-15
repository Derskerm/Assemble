package Block;

import java.awt.geom.Rectangle2D;

import javax.swing.JOptionPane;

public class GoalBlock extends Block {
	
	private boolean hasDisplayed = false;
	
	public GoalBlock(int x, int y) {
		super(false,"flag_green.png",x,y);
	}
	
	public boolean intersects(Rectangle2D r) {
		Rectangle2D rekt = new Rectangle2D.Double(this.getBounds().getCenterX(), this.getBounds().getCenterY(), 1, 1);
		if (!hasDisplayed && rekt.intersects(r)) {
			JOptionPane.showConfirmDialog(null, "You win!!!!");
			hasDisplayed = true;
		} else if (!this.getBounds().intersects(r)) {
			hasDisplayed = false;
		}
		return super.intersects(r);
	}
}
