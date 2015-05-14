import java.awt.Graphics;
import java.awt.Image;

/**
 * Class represents a square, or "tile", within a level.
 * 
 * @author Jordyn
 *
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
