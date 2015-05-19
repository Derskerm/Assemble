package Item.Weapon;

import AnimationDemo.MovingImage;
import Character.player.Player;

/**
 * Represents a sword, the weapon of the user.
 * 
 * @author Jordyn
 *
 */
public class Sword extends Weapon {
	
	private static final int SWORD_POWER = 50;
	
	public Sword(int x, int y) {
		super("", x, y, 20, 50, SWORD_POWER);
	}
}
