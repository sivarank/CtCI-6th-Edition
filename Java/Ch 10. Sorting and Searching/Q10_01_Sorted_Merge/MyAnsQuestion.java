package Q10_01_Sorted_Merge;

import CtCILibrary.AssortedMethods;

public class MyAnsQuestion {


	/** Merges array
	 * @param a first array
	 * @param b second array
	 * @param countA number of "real" elements in a
	 * @param countB number of "real" elements in b
	 */

//	private static void merge(int[] a, int[] b, int i, int j) {
//		int k = i+j-1;
//		i--;
//		j--;
//		while(i >=0 && j>= 0) {
//			if(a[i] >= b[j]) {
//				a[k--] = a[i--];
//			}else {
//				a[k--] = b[j--];
//			}
//		}
//		while(i>=0 && i != k) {
//			a[k--] = a[i--];
//		}
//		while(j>=0) {
//			a[k--] = b[j--];
//		}
//	}
	
	private static void merge(int[] a, int[] b, int i, int j) {
		int k = i+j-1;
		i--;
		j--;
		while(j>= 0) {
			if(i>=0 && a[i] > b[j]) {
				a[k--] = a[i--];
			}else {
				a[k--] = b[j--];
			}
		}
	}
	public static void main(String[] args) {
		int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
		int[] b = {1, 4, 7, 6, 7, 7};
		merge(a, b, 8, 6);
		System.out.println(AssortedMethods.arrayToString(a));
	}
}
