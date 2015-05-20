package Level;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import AnimationDemo.GameImage;
import AnimationDemo.MovingImage;
import Block.Block;
import Block.GoalBlock;
import Block.GrassBlock;
import Character.player.CatLady;
import Character.player.Player;
import Character.player.PlayerOne;

public abstract class Level {

	private GameImage[][] levelItems;
	private GoalBlock gb;
	private Player player;
	private boolean completed;
	
	public Level(char[][] key) {
		levelItems = new GameImage[key.length][key[0].length];
		toGameImageArray(key);
	}
	
	private void toGameImageArray(char[][] key) {
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
					Player p = new CatLady(r*Block.BLOCK_SIDE_LENGTH, c*Block.BLOCK_SIDE_LENGTH);
					player = p;
					levelItems[c][r] = player;
				}
			}
		}
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public GameImage[][] getLevelItems() {
		return levelItems;
	}
	
	public void draw(Graphics g, ImageObserver io) {
		for (GameImage[] m : levelItems) {
			for (GameImage i : m) {
				i.draw(g, io);
			}
		}
	}
	
	public boolean hasWon() {
		if (gb.hasWon()) {
			completed = true;
		}
		return gb.hasWon();
	}
	
	public void setCompleted(boolean complete) {
		this.completed = complete;
		if (!complete) {
			gb.reset();
		}
	}
	
	public boolean getComplete() {
		if (gb.hasWon()) {
			completed = true;
		}
		return completed;
	}
	
	
	
}
