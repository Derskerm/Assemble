import java.awt.Shape;
import java.util.ArrayList;

public interface Character {
	/**
	 * Moves the Character upwards
	 */
	void jump();
	/**
	 * Moves the Character horizontally amt distance
	 * @param amt the distance moved
	 */
	void walk(int amt);
	/**
	 * Attacks other, causing other to lose health
	 * @param other the enemy attacked
	 */
	void attack(Enemy other);
	/**
	 * Performs this Character's special attack.
	 * If the character does not have one, nothing
	 * will occur.
	 */
	void special();
	/**
	 * Adds amt health points to the Character's health.
	 * @param power the health points added
	 * @return true if the character is dead, false
	 * otherwise.
	 */
	boolean addHealth(double power);
	/**
	 * Returns the remaining health the Character has
	 * @return the health left
	 */
	double healthLeft();
	/**
	 * Returns the maximum amount of health the 
	 * character can have.
	 * @return the max health
	 */
	double totalHealth();
	/**
	 * Makes this character act
	 * @param obstacles Shapes in the way of the Character
	 */
	void act(ArrayList<Shape> obstacles);
}
