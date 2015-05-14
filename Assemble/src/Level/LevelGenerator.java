package Level;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import Map.GameTile;


public class LevelGenerator {

	//A list of GameTiles that is 
	private GameTile[][] map;
	
	public LevelGenerator() {
		map = new GameTile[20][150];
	}
	
	public void generateLevel(String fileName) {
		String[] lines;
		//Scanner in = new Scanner(fileName);
		FileReader r;
		try {
			r = new FileReader(fileName);
			BufferedReader breader = new BufferedReader(r);
			String lineSeparator = System.getProperty("line.separator");
			lines = new String[21];
			lines = fileName.split(lineSeparator);
			generate(lines);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void generate(String[] l) {
		for(int i  = 1; i < l.length; i++) {
			String s = l[i];
			char[] blocks = s.toCharArray();
			for(int j = 0; j < blocks.length; j++) {
				char c = blocks[j];
				if(c == 'f') {
					map[i][j] = new GameTile("floor.jpg", i, j, 5, 30);
				}
				else if(c == 'p') {
					map[i][j] = new GameTile(new Player(), i, j, 10, 15);
				}
				else if(c == 'e') {
					map[i][j] = new GameTile(new Enemy(), i, j, 10 , 15);
				}
				else if(c == 'P') {
					map[i][j] = new GameTile("platform.jpg", i, j, 5, 30);
				}
				else if(c == 'A') {
					map[i][j] = new GameTile(new SuperShelbz(), i, j, 10, 15);
				}
			}
		}
	}
}
