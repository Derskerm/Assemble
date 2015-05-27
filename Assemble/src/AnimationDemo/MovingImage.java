package AnimationDemo;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;

import javax.swing.*;

/**
 * Represents a moving image.
 *
 * by: Shelby
 * on: 5/3/13
 */
 
public class MovingImage extends Rectangle2D.Double {
	
	// FIELDS
	private Image image;
	
	// CONSTRUCTORS
	/**
	 * 
	 * @param filename Name of image file
	 * @param x X-Coordinate of MovingImage
	 * @param y Y-Coordinate of MovingImage
	 * @param w Width of MovingImage
	 * @param h Height of MovingImage
	 */
	public MovingImage(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}
	
	/**
	 * 
	 * @param img The image to be created into a MovingImage
	 * @param x X-Coordinate of MovingImage
	 * @param y Y-Coordinate of MovingImage
	 * @param w Width of MovingImage
	 * @param h Height of MovingImage
	 */
	public MovingImage(Image img, int x, int y, int w, int h) {
		super(x,y,w,h);
		image = img;
	}
	
	
	// METHODS	
	/**
	 * Moves the MovingImage to the x and y parameters
	 * @param x X-Coordinate the MovingImage will be moved to
	 * @param y Y-Coordinate the MovingImage will be moved to
	 */
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}
	
	/**
	 * Moves the MovingImage by x and y amount
	 * @param x Moves the MovingImage by x amount
	 * @param y Moves the MovingImage by y amount
	 */
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-width);
		y = Math.min(y,windowHeight-height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	/**
	 * Draws the MovingImage
	 * @param g Graphics used to draw the image
	 * @param io ImageObserver is null
	 */
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(image,(int)x,(int)y,(int)width,(int)height,io);
	}
	
	public void setImage(Image i)  {
		image = i;
	}
	
	public Image getImage() {
		return image;
	}
}