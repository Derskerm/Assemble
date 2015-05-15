package Level;

import java.util.ArrayList;

public class LevelLibrary {

	private ArrayList<Level> levels;
	private ArrayList<Boolean> progress;
	public static final int HIGHEST_LEVEL_NUM = 2;
	Level currentLevel;
	
	public LevelLibrary(int start) {
		levels = new ArrayList<Level>();
		for (int i = start; i < HIGHEST_LEVEL_NUM; i++) {
			levels.add(LevelLibrary.getLevel(i));
		}
	}
	
	public static Level getLevel(int num) {
		if (num == 1) {
			return new LevelOne();
		} else if (num == 2) {
			return new LevelTwo();
		}
	}
	
	public Level getCurrentLevel() {
		return currentLevel;
	}
	
	public void checkLevels() {
		
	}
	
}
