package Item.Weapon;

import Character.Character;
import Item.Item;

public interface Weapon extends Item {

	int getPower();
	void discard();
	void setPlayer(Character p);
}
