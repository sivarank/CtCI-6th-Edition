package Q8_12_Eight_Queens;

import java.util.ArrayList;
import java.util.Arrays;

public class MyAnsQuestion {
	public static int GRID_SIZE = 8;

	
	private static Boolean placeQueen(int grid[][], int row) {
		if(row == 8) {
			return true;
		}
		
		for(int i =0; i< GRID_SIZE; i++) {
			if(canWePlace(grid, row, i)) {
				grid[row][i] = 1;
				if(placeQueen(grid, row+1)) {
					return true;
				}else {
					grid[row][i] = 0;
				}
			}
		}
		return false;
	}
	
	private static boolean canWePlace(int[][] grid, int row, int col) {
		// vertical top check
		int i = row -1 , j = col;
		while(i >= 0 && j >= 0) {
			if(grid[i][j] == 1) {
				return false;
			}
			i--;
		}
		// diagonal left traverse
		i = row -1; j = col-1;
		while(i >= 0 && j >= 0) {
			if(grid[i][j] == 1) {
				return false;
			}
			i--;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] grid = new int[GRID_SIZE][GRID_SIZE];
		
		// grid by default contains false
		Boolean result = placeQueen(grid, 0);
		System.out.println(result);
		System.out.println(grid);
		for(int i=0; i< 8; i++) {
			for(int j=0; j<8;j++) {
				System.out.print(" "+grid[i][j]);
			}
			System.out.println("\n");
		}
	}
}
