package Q10_01_Sorted_Merge;

import java.util.Arrays;

import CtCILibrary.AssortedMethods;

public class MyAnsQuestion2 {


	/** Merges array
	 * @param a first array
	 * @param b second array
	 */


	
	private static void merge(int[] arr1, int[] arr2) {
		int j = arr2.length-1;
		int i = arr1.length - arr2.length -1;
		int k = arr1.length -1;
		
		while(j>=0) {
			if(i<0 || arr1[i] < arr2[j]) {
				arr1[k--] = arr2[j--];
			}else {
				arr1[k--] = arr1[i--];
			}
		}
	}
	public static void main(String[] args) {
		int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
		int[] b = {1, 4, 6, 6, 7, 7};
		merge(a, b);
		System.out.println(Arrays.toString(a));
		//System.out.println(AssortedMethods.arrayToString(a));
	}
}
