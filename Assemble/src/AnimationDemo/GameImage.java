package AnimationDemo;

import Plane.Plane;

public class GameImage extends MovingImage {

	private Plane plane;
	
	public GameImage(String filename, int x, int y, int w, int h) {
		super(filename, x, y, w, h);
		plane = null;
	}
	
	public void insertIntoPlane(Plane p) {
		plane = p;
		p.addGameImage(this);
	}
	
	public void removeFromGrid() {
		if (plane != null)
			plane.removeMovingImage(this);
		plane = null;
	}
	
	public Plane getPlane() {
		return plane;
	}

}
