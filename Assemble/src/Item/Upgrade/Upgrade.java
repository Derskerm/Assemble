package Item.Upgrade;

import Item.Item;

public abstract class Upgrade extends Item {
	
	private int healthBonus;
	private int powerBonus;
	
	public Upgrade(String filename, int x, int y, int w, int h, int healthBonus, int powerBonus) {
		super(filename, x, y, w, h);
		this.healthBonus = healthBonus;
		this.powerBonus = powerBonus;
	}
	
	public int getHealthBonus() {
		return healthBonus;
	}
	
	public int getPowerBonus() {
		return powerBonus;
	}
	
	public void use() {
		removeFromGrid();
	}
}
