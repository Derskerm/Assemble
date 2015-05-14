package Map;

import java.awt.Graphics;
import java.awt.Image;

/**
 * Class represents a 5x30 rectangle, or "tile", within a level.
 * 
 * @author Jordyn
 * Date: 5/13/15
 * Updates: 5/14/15,
 */
public class GameTile {

	private int x, y;
	private Image i;
	
	public GameTile(int xC, int yC, Image image) {
		x = xC;
		y = yC;
		i = image;
	}
	
	public void draw(Graphics g) {
		g.drawImage(i, x, y, 10, 15, null);
	}
}
