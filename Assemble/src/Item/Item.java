package Item;

import AnimationDemo.GameImage;

public abstract class Item extends GameImage {

	public Item(String filename, int x, int y, int w, int h) {
		super(filename, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	public abstract void use();
	
}
