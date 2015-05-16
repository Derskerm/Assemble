package Weapon;

import AnimationDemo.MovingImage;
import Character.player.Player;

/**
 * Represents a sword, the weapon of the user.
 * 
 * @author Jordyn
 *
 */
public class Sword extends MovingImage {

	private Player p;
	
	public Sword(Player play, String fileName) {
		super(fileName, (int)play.getX(), (int)play.getY(), 20, 50);
		p = play;
	}
	
	public void setPlayer(Player play) {
		p = play;
	}
	
	public Player getPlayer() {
		return p;
	}
}
