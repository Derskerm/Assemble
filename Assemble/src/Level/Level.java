package Level;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import AnimationDemo.GameImage;
import AnimationDemo.MovingImage;
import Block.Block;
import Block.GoalBlock;
import Block.GrassBlock;
import Character.NPC.Enemy.Spider;
import Character.player.CatLady;
import Character.player.Player;
import Character.player.PlayerOne;
import Character.player.SuperShelbz;
import Item.Upgrade.Heart;

public abstract class Level {

	private GameImage[][] levelItems;
	private GoalBlock gb;
	private Player player;
	private boolean completed;
	private int levelNum;
	private static int HIGHEST_LEVEL_NUM = 3;
	
	/**
	 * Creates a new level
	 * @param key the representation of the level in chars
	 */
	public Level(char[][] key, int levelNum) {
		this.levelNum = levelNum;
		if (levelNum > HIGHEST_LEVEL_NUM)
			HIGHEST_LEVEL_NUM = levelNum;
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
					gb = new GoalBlock(r*Block.BLOCK_SIDE_LENGTH, c*Block.BLOCK_SIDE_LENGTH);
					levelItems[c][r] = gb;
				} else if (h == 'P') {
					player = new SuperShelbz(r*Block.BLOCK_SIDE_LENGTH, c*Block.BLOCK_SIDE_LENGTH);
					//player = new PlayerOne(r*Block.BLOCK_SIDE_LENGTH, c*Block.BLOCK_SIDE_LENGTH);
					levelItems[c][r] = player;
				} else if (h == 'S') {
					levelItems[c][r] = new Spider(r*Block.BLOCK_SIDE_LENGTH, c*Block.BLOCK_SIDE_LENGTH, false);
				} else if (h == 'H') {
					levelItems[c][r] = new Heart(r*Block.BLOCK_SIDE_LENGTH, c*Block.BLOCK_SIDE_LENGTH);
				} else {
					levelItems[c][r] = null;
				}
			}
		}
	}
	
	/**
	 * Returns a reference to the Player in the level
	 * @return the Player
	 */
	public Player getPlayer() {
		return player;
	}
	
	public GoalBlock getGoalBlock() {
		return gb;
	}
	
	/**
	 * Returns the GameImages in the level
	 * @return the GameImages in the level
	 */
	public GameImage[][] getLevelItems() {
		return levelItems;
	}
	
	/**
	 * Draws each GameImage in the level
	 * @param g the Graphics of the component drawing the level
	 * @param io the ImageObserver
	 */
	public void draw(Graphics g, ImageObserver io) {
		for (GameImage[] m : levelItems) {
			for (GameImage i : m) {
				i.draw(g, io);
			}
		}
	}
	
	/**
	 * @return true if the GoalBlock has been triggered, false otherwise
	 */
	public boolean hasWon() {
		gb.intersects(player);
		if (gb.triggered()) {
			completed = true;
		}
		return gb.triggered();
	}
	
	public void setCompleted(boolean complete) {
		this.completed = complete;
		if (!complete) {
			gb.reset();
		}
	}
	
	public boolean getComplete() {
		gb.intersects(player);
		if (gb.triggered()) {
			completed = true;
		}
		return completed;
	}
	
	public int getLevelNum() {
		return levelNum;
	}
	
	public static int getHighestLevelNum() {
		return HIGHEST_LEVEL_NUM;
	}
	
}
