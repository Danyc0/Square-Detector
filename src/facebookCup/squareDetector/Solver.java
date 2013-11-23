package facebookCup.squareDetector;

import java.awt.Point;

public class Solver {
	char[][] grid;
	public Solver(char[][] grid) {
		this.grid = grid;
	}

	public boolean solve() {
		boolean isSquare = false;
		//Search line by line for square
		Point firstPoint = findFirstSquare();
		if(firstPoint != null){
			//On the first line found containing a square, map every contiguous square after it
			int numHashes = countOtherHashes(firstPoint);
			//Generate The Correct Square
			char[][] correctGrid = generateCorrectGrid(firstPoint, numHashes);
			//Compare the two
			isSquare = compareGrids(correctGrid);
		}
		else{
			System.out.println("No #'s found");
		}
		return isSquare;
	}
	
	private Point findFirstSquare() {
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] == '#'){
					return new Point(i, j);
				}
			}
		}
		return null;
	}
	
	private int countOtherHashes(Point firstPoint) {
		int count = 0;
		for(int j = firstPoint.y; j < grid.length; j++){
			if(grid[firstPoint.x][j] == '#'){
				count++;
			}
		}
		return count;
	}
	
	private char[][] generateCorrectGrid(Point firstPoint, int numHashes) {
		char[][] correctSquare = new char[grid.length][grid[0].length];
		//Go from the row of the firstPoint downwards, numHashes number of times
		for(int i = firstPoint.x; i < (firstPoint.x + numHashes); i++){
			//Go from the column of the firstPoint right, numHashes number of times
			for(int j = firstPoint.y; j < (firstPoint.y + numHashes); j++){
				//Put a has in the current square
				correctSquare[i][j] = '#';
			}
		}
		return correctSquare;
	}

	private boolean compareGrids(char[][] correctGrid) {
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] != correctGrid[i][j]){
					return false;
				}
			}
		}
		return true;
	}
}
