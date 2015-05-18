package Level;

import java.util.ArrayList;

public class LevelLibrary {

	private ArrayList<Level> levels;
	public static final int HIGHEST_LEVEL_NUM = 2;
	Level currentLevel;
	
	/**
	 * Creates a new library of levels in a game.
	 * @param start the highest level not completed, or zero if no levels have been completed.
	 * @pre 0 <= start <= HIGHEST_LEVEL_NUM
	 */
	public LevelLibrary(int start) {
		levels = new ArrayList<Level>();
		for (int i = 1; i <= HIGHEST_LEVEL_NUM; i++) {
			levels.add(LevelLibrary.getLevel(i));
		}
		for (int i = 0; i < start; i++) {
			levels.get(i).setCompleted(true);
		}
		currentLevel = levels.get(start);
	}
	
	public static Level getLevel(int num) {
		if (num == 1) {
			return new LevelOne();
		} else if (num == 2) {
			return new LevelTwo();
		} else {
			return null;
		}
	}
	
	/**
	 * Returns the highest uncompleted level.
	 * @return the highest uncompleted level.  If all are completed, returns null
	 */
	public Level getCurrentLevel() {
		this.checkLevels();
		return currentLevel;
	}
	
	public void checkLevels() {
		currentLevel = null;
		for (Level l : levels) {
			if (!l.getComplete()) {
				currentLevel = l;
			}
		}
	}
	
	public void reset() {
		for (Level l : levels) 
			l.setCompleted(false);
		currentLevel = levels.get(0);
	}
	
}
