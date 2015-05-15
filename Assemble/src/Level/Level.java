package Level;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import AnimationDemo.MovingImage;
import Block.Block;
import Block.GoalBlock;
import Block.GrassBlock;
import Character.player.Player;

public abstract class Level {

	private MovingImage[][] levelItems;
	GoalBlock gb;
	
	public Level(char[][] key) {
		levelItems = new MovingImage[key.length][key[0].length];
		toMovingImageArray(key);
	}
	
	private void toMovingImageArray(char[][] key) {
		for (int c = 0; c < key.length; c++) {
			for (int r = 0; r < key[c].length; r++) {
				char h = key[c][r];
				if (h == '0') {
					levelItems[c][r] = null;
				} else if (h == 'G') {
					levelItems[c][r] = new GrassBlock(r*Block.BLOCK_SIDE_LENGTH, c*Block.BLOCK_SIDE_LENGTH);
				} else if (h == 'F') {
					levelItems[c][r] = new GoalBlock(r*Block.BLOCK_SIDE_LENGTH, c*Block.BLOCK_SIDE_LENGTH);
					gb = (GoalBlock)levelItems[c][r];
				} else if (h == 'P') {
					levelItems[c][r] = new Player(r*Block.BLOCK_SIDE_LENGTH, c*Block.BLOCK_SIDE_LENGTH);
				}
			}
		}
	}
	
	public MovingImage[][] getLevelItems() {
		return levelItems;
	}
	
	public void draw(Graphics g, ImageObserver io) {
		for (MovingImage[] m : levelItems) {
			for (MovingImage i : m) {
				i.draw(g, io);
			}
		}
	}
	
	public boolean hasWon() {
		return gb.hasWon();
	}
	
	
	
}
