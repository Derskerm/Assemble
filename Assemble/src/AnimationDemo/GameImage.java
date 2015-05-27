package AnimationDemo;

import Plane.Plane;

/**
 * Represents an image in Assemble!
 * 
 * @author Desmond Kamas
 *
 */
public class GameImage extends MovingImage {

	private Plane plane;
	
	/**
	 * Creates a new GameImage
	 * 
	 * @param filename Name of image file
	 * @param x X-Coordinate of GameImage
	 * @param y Y-Coordinate of GameImage
	 * @param w Width of GameImage
	 * @param h Height of GameImage
	 */
	public GameImage(String filename, int x, int y, int w, int h) {
		super(filename, x, y, w, h);
		plane = null;
	}
	
	/**
	 * Places this GameImage into Plane p.
	 * 
	 * @param p Plane that the image will be inserted into.
	 */
	public void insertIntoPlane(Plane p) {
		plane = p;
		p.addGameImage(this);
	}
	
	/**
	 * Removes this GameImage from this Plane.
	 */
	public void removeFromGrid() {
		if (plane != null)
			plane.removeMovingImage(this);
		plane = null;
	}
	
	public Plane getPlane() {
		return plane;
	}
}