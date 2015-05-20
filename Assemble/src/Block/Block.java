package Block;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

import AnimationDemo.GameImage;
import AnimationDemo.MovingImage;

public abstract class Block extends GameImage {

	private boolean solid;
	public static final int BLOCK_SIDE_LENGTH = 25;
	
	public Block(boolean solid, String filename, int x, int y) {
		super(filename, x, y, BLOCK_SIDE_LENGTH, BLOCK_SIDE_LENGTH);
		this.solid = solid;
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSolid() {
		return solid;
	}
	
	public void setSolid(boolean solid) {
		this.solid = solid;
	}
	
	public void toggleSolidity() {
		solid = !solid;
	}
	
	public boolean intersects(Rectangle2D r) {
		if (!solid) {
			return false;
		} else {
			return super.intersects(r);
		}
	}
	
	
}
