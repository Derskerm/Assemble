package Level;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import Map.GameTile;


public class LevelGenerator {

	private ArrayList<GameTile> map;
	
	public LevelGenerator() {
		map = new ArrayList<GameTile>();
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
		for(String s : l) {
			s.
		}
	}
}
