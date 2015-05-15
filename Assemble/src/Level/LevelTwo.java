package Level;

public class LevelTwo extends Level {

	//Legend:
	//0 = empty
	//G = GrassBlock
	//S = spider
	//P = player
	//F = flag/GoalBlock
	private static char[][] key = new char[][]{
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','F'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','G','G'},
		{'G','0','0','0',  'G','G','G','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  'G','G','G','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','P','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G',  '0','0','0','0',  '0','0','0','0',  '0','0','0','0',  '0','0','0','G'},
		{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
		{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
		{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
		{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'},
		{'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G',  'G','G','G','G'}
		};
	
	public LevelTwo() {
		super(key);
	}

}
