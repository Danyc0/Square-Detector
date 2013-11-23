package facebookCup.squareDetector;

import java.util.Scanner;

public class Importer {

	private Scanner file;
	public Importer(Scanner file) {
		this.file = file;
	}

	public char[][] importGrid(String filePath, int gridSize) {
		String line;
		char[][] grid = new char[gridSize][gridSize];
		for(int i = 0; i < gridSize; i++){
			line = file.nextLine();
			for(int j = 0; j < line.length(); j++){
				if(line.charAt(j) != '.'){
					grid[i][j] = line.charAt(j);
				}
			}
		}
		return grid;
	}

}