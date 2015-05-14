package Map;

import java.awt.Graphics;
import Image.MovingImage;
import java.awt.Image;

/**
 * Class represents a 5x30 rectangle, or "tile", within a level.
 * 
 * @author Jordyn
 * Date: 5/13/15
 * Updates: 5/14/15,
 */
public class GameTile extends MovingImage {

	public GameTile(String image, int xC, int yC, int w, int h) {
		super(image, xC, yC, w, h);
	}
	
	public GameTile(MovingImage c, int x, int y, int w, int h) {
		super(c.getImage(), x, y, w, h);
	}
}
