package facebookCup.squareDetector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filePath = args[0];
		Scanner file = null;
		try {
			file = new Scanner(new InputStreamReader (new FileInputStream(filePath)));
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		}
		int numCases = file.nextInt();
		file.nextLine();
		for(int i = 0; i < numCases; i++){
			System.out.print("Case #" + (i+1) + ": ");
			int gridSize = file.nextInt();
			file.nextLine();
			Importer importer = new Importer(file);
			char[][] grid = importer.importGrid(filePath, gridSize);
			Solver solver = new Solver(grid);
			boolean solved = solver.solve();
			if(solved){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
		file.close();	
	}

}
