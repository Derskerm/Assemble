package Block;

import java.awt.geom.Rectangle2D;

import javax.swing.JOptionPane;

import Character.player.Player;

public class GoalBlock extends TriggerBlock {
	
	/**
	 * Creates a new GoalBlock
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public GoalBlock(int x, int y) {
		super("lib//flag_green.png",x,y);
	}
}
