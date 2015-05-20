package Plane;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import AnimationDemo.GameImage;
import AnimationDemo.MovingImage;
import Character.player.Player;
import Level.Level;

public class Plane {
	
	private ArrayList<GameImage> images;
	private int width, height;
	
	public Plane(int width, int height) {
		images = new ArrayList<GameImage>();
		this.width = width;
		this.height = height;
	}
	
	public Plane(Level l) {
		loadLevel(l);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public ArrayList<Shape> getShapes() {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		for (GameImage mi : images) {
			if (!(mi instanceof Player))
				shapes.add(mi);
		}
		return shapes;
	}
	
	/**
	 * Adds a specified MovingImage into the Plane.
	 * @param mi the MovingImage added to the Plane
	 * @return the index of mi
	 */
	public void addGameImage(GameImage mi) {
		images.add(mi);
	}
	
	/*public MovingImage[] getWithinRadius(int pixels, int x, int y) {
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
	}*/
	
	public GameImage[] getWithinRect(Rectangle s) {
		ArrayList<GameImage> withinShape = new ArrayList<GameImage>();
		for (GameImage mi : images) {
			if (mi.intersects(s)) {
				withinShape.add(mi);
			}
		}
		GameImage[] wRArray = new GameImage[withinShape.size()];
		wRArray = withinShape.toArray(wRArray);
		return wRArray;
	}
	
	public void removeMovingImage(MovingImage mi) {
		for (int i = 0; i < images.size(); i++) {
			if (images.get(i).equals(mi)) {
				images.remove(i);
				return;
			}
		}
	}
	
	/**
	 * Resets the plane with the specified Level.
	 * @param l the level loaded
	 */
	private void loadLevel(Level l) {
		images = new ArrayList<GameImage>();
		GameImage[][] miArr = l.getLevelItems();
		for (GameImage[] arr : miArr) {
			for (GameImage image : arr) {
				if (image != null)
					image.insertIntoPlane(this);
			}
		}
	}
	
	public void draw(Graphics g, ImageObserver io) {
		for (GameImage mi : images) {
			mi.draw(g, io);
			System.out.println(mi);
		}
	}
}
