package Q5_01_Insertion;

import CtCILibrary.AssortedMethods;

public class MyAnsQuestion {

	public static int updateBits(int n, int m, int i, int j) {
		// validation 
		if(i> j || j>31 || i<0 ) {
			return Integer.MIN_VALUE;
		}
		//return (((~(0)<<j) | ~(~(0) << i)) & n) | (m<<i);
		return ((~(0)<<j) | ((1<<(i+1)) - 1) & n) | (m<<i);
	}
	
	public static void main(String[] args) {
		int a = ~23423;
		System.out.println(AssortedMethods.toFullBinaryString(a));
		int b = 5;
		System.out.println(AssortedMethods.toFullBinaryString(b));		
		int c = updateBits(a, b, 29, 31);
		System.out.println(AssortedMethods.toFullBinaryString(c));
		
		c= updateBits(a, b, 6, 8);
		System.out.println(AssortedMethods.toFullBinaryString(c));
		
		System.out.println(AssortedMethods.toFullBinaryString(-1 >> 2));
		System.out.println(AssortedMethods.toFullBinaryString(-1 >>> 2));
	}
}
