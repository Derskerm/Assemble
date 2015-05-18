package Plane;

import java.util.ArrayList;
import java.util.List;

import AnimationDemo.MovingImage;
import Level.Level;

public class Plane {
	
	private ArrayList<MovingImage> images;
	
	public Plane(List<MovingImage> images) {
		this.images.addAll(images);
	}
	
	/**
	 * Adds a specified MovingImage into the Plane.
	 * @param mi the MovingImage added to the Plane
	 * @return the index of mi
	 */
	public int addMovingImage(MovingImage mi) {
		int size = images.size();
		images.add(mi);
		return size;
	}
	
	public MovingImage[] getWithinRadius(int pixels, int x, int y) {
		ArrayList<MovingImage> withinRadius = new ArrayList<MovingImage>();
		for (MovingImage mi : images) {
			if ((Math.abs(mi.getMaxX() - x) <= pixels || Math.abs(x - mi.getMinX()) <= pixels) &&
				(Math.abs(mi.getMaxY() - y) <= pixels || Math.abs(y - mi.getMinY()) <= pixels)) {
				withinRadius.add(mi);
			}
		}
		MovingImage[] wRArray = new MovingImage[withinRadius.size()];
		wRArray = withinRadius.toArray(wRArray);
		return wRArray;
	}
	
	public void removeMovingImage(int index) {
		images.remove(index);
	}
	
	/**
	 * Resets the plane with the specified Level.
	 * @param l the level loaded
	 */
	public void loadLevel(Level l) {
		images = new ArrayList<MovingImage>();
		MovingImage[][] miArr = l.getLevelItems();
		
	}
}
