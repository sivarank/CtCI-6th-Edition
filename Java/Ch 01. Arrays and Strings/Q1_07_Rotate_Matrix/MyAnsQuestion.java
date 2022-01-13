package Q1_07_Rotate_Matrix;

import CtCILibrary.*;

public class MyAnsQuestion {

	public static boolean rotate(int[][] matrix) {
		if(matrix.length < 2 || matrix[0].length != matrix.length) {
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		for(int i=0; i< rows/2; i++) {
			for(int j = i; j< cols -i-1;j++) {
				int temp = matrix[i][j];
				// left to top
				matrix[i][j] = matrix[cols-j-1][i];
				// bottom to left
				matrix[cols-j-1][i] = matrix[rows-i-1][cols-j-1];
				// right to bottom
				matrix[rows-i-1][cols-j-1] = matrix[j][rows-i-1];
				// top to right
				matrix[j][rows-i-1] = temp;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
		AssortedMethods.printMatrix(matrix);
		rotate(matrix);
		System.out.println();
		AssortedMethods.printMatrix(matrix);
		System.out.println();
		System.out.println();
		
		matrix = AssortedMethods.randomMatrix(4, 4, 0, 16);
		AssortedMethods.printMatrix(matrix);
		rotate(matrix);
		System.out.println();
		AssortedMethods.printMatrix(matrix);
	}

}
