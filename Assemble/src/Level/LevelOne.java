package Level;
/*
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import Character.AbstractCharacter;
import Character.Enemy.AbstractEnemy;
import OtherObjects.Platform;

public class LevelOne {
=======
import java.awt.Graphics;
import java.awt.image.ImageObserver;
*/
import Character.player.Player;
import AnimationDemo.MovingImage;
import Block.Block;
import Block.GoalBlock;
import Block.GrassBlock;

public class LevelOne extends Level {

	//Legend:
	//0 = empty
	//G = GrassBlock
	//S = spider
	//P = player
	//F = flag/GoalBlock
	private static char[][] key = new char[][]{
	{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','S','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  'G','G','G','G',  '0','0','0','0',  '0','0','H','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  'G','G','G','G',  'G','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  'G','G','G','G',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','S','0',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  'G','G','G','G',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','P','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','S','F','G'},
	{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
	{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
	{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
	{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
	{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'}
	};
	
/*	//Fields
	private ArrayList<Platform> platforms;
	private ArrayList<AbstractCharacter> allies;
	private ArrayList<AbstractEnemy> enemies;
	
	public LevelOne() {
		platforms = new ArrayList<Platform>();
		addPlatforms();
		allies = new ArrayList<AbstractCharacter>();
		enemies = new ArrayList<AbstractEnemy>();
	}
	
	private void addPlatforms() {
		platforms.add(new Platform(100, 400, 65, 30));
		platforms.add(new Platform(195, 200, 110, 30));
		platforms.add(new Platform(550, 250, 80, 30));
		platforms.add(new Platform(375, 350, 80, 30));
	}
	
	private void addAllies() {
		//allies.add(new AbstractCharacter());
	}
	
	public void draw(Graphics2D g, ImageObserver io) {
		for(Platform p : platforms) {
			p.draw(g, io);
		}
	}
=======*/
	/**
	 * Creates a new LevelOne
	 */
	public LevelOne(int charNum) {
		super(key,1,charNum);
	}
}
