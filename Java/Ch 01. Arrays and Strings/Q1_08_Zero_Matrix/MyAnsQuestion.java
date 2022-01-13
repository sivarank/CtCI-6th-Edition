package Q1_08_Zero_Matrix;

import CtCILibrary.AssortedMethods;
/**
 * 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.
 * @author SIVAR1
 *
 */
public class MyAnsQuestion {

	private static void setZeros(int[][] matrix) {
		if(matrix.length == 0 || matrix[0].length ==0) {
			return;
		}
		int[] zeroRows = new int[matrix.length];
		int[] zeroCols = new int[matrix[0].length];
		
		for(int i=0; i< matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					zeroRows[i] = 1;
					zeroCols[j] = 1;
				}
			}
		}
		// set zeros
		for(int i=0; i< matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(zeroRows[i] == 1 || zeroCols[j] == 1) {
					matrix[i][j] = 0;
				}
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
