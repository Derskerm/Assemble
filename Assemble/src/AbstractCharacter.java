import java.awt.Shape;
import java.util.ArrayList;


public abstract class AbstractCharacter extends MovingImage implements Character {

	private double health;
	private final double MAX_HEALTH;
	private double power;
	private double xvel, yvel;
	
	public AbstractCharacter(String filename, int x, int y, int w, int h, double maxHealth, double power) {
		super(filename, x, y, w, h);
		health = maxHealth;
		MAX_HEALTH = maxHealth;
		this.power = power;
		xvel = 0;
		yvel = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void walk(int amt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(Enemy other) {
		other.addHealth(power);
	}

	@Override
	public boolean addHealth(double amt) {
		health -= amt;
		return health <= 0;
	}

	public double healthLeft() {
		return health;
	}

	@Override
	public double totalHealth() {
		// TODO Auto-generated method stub
		return MAX_HEALTH;
	}

	@Override
	public void act(ArrayList<Shape> obstacles) {
		// TODO Auto-generated method stub
		
	}

}
