package Level;

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
	{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','H','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','H','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','G','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','G','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','S','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  'G','0','0','0',  '0','0','0','0',  '0','G','G','G',  '0','0','0','0',  '0','0','S','0',  '0','0','0','0',  '0','S','F','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  'G','G','G','G',  '0','0','0','0',  '0','0','H','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','G','G','0',  '0','0','0','0',  'G','G','G','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  'G','G','G','G',  'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','S','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','S','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  'G','G','G','G',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','S','0',  '0','0','0','0',  '0','G','G','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','G','G','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  'G','G','G','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','S','0',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  'G','G','G','G',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','P','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','S','0','0',  '0','0','0','0',  '0','S','0','0',  '0','0','S','0',  '0','0','0','0',  '0','S','0','0',  '0','S','0','0',  '0','0','0','0',  '0','0','0','G'},
	{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
	{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
	{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
	{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
	{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'}
	};
	
	/**
	 * Creates a new LevelOne
	 */
	public LevelOne(int charNum) {
		super(key,1,charNum);
	}
}
