package Q1_08_Zero_Matrix;

import CtCILibrary.AssortedMethods;
/**
 * 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.
 * @author SIVAR1
 *
 */

// No extra space
public class MyAnsQuestion2 {

	private static void setZeros(int[][] matrix) {
		if(matrix.length == 0 || matrix[0].length ==0) {
			return;
		}
//		int[] zeroRows = new int[matrix.length];
//		int[] zeroCols = new int[matrix[0].length];
		
		// process first row
		boolean setFirstRowZero = false;
		for(int i=0; i<matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				setFirstRowZero = true;
				break;
			}
		}
		// process first column
		boolean setFirstColZero = false;
		for(int i=0; i<matrix.length; i++) {
			if(matrix[i][0] == 0) {
				setFirstColZero = true;
				break;
			}
		}
		
		for(int i=1; i< matrix.length; i++) {
			for(int j=1; j<matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] =0;		
				}
			}
		}
		// set zeros
		for(int i=1; i< matrix.length; i++) {
			for(int j=1; j<matrix[0].length; j++) {
				if(matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		

		// if first row contains ZERO, fill row with 0s
		for(int i=0; i<matrix[0].length; i++) {
			if(setFirstRowZero == true || matrix[0][i] == 0) {
				matrix[0][i] = 0;
			}
		}
		

		// if first column contains ZERO, fill row with 0s
		for(int i=0; i<matrix.length; i++) {
			if(setFirstColZero == true || matrix[i][0] == 0) {
				matrix[i][0] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		int nrows = 10;
		int ncols = 15;
		int[][] matrix = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);		

		AssortedMethods.printMatrix(matrix);
		
		setZeros(matrix);
		
		System.out.println();
		
		AssortedMethods.printMatrix(matrix);
	}
}
