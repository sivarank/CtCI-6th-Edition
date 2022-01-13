package Q8_03_Magic_Index;

import java.util.Arrays;

import CtCILibrary.AssortedMethods;

public class MyAnsQuestionB {

	public static int magicSlow(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}
	
	public static int magicFast(int[] array, int start, int end) {
		if(start > end) {
			return -1;
		}
		
		int midIndex = (start + end)/2;
		if(midIndex == array[midIndex]) {
			return midIndex;
		}
		
		// Left array scanning
		int result = magicFast(array, start, Math.min(midIndex-1, array[midIndex]));
		if(result >= 0) {
			return result;
		}
		
		//Right array scanning
		return magicFast(array, Math.max(midIndex+1, array[midIndex]), end) ; 
	}
	
	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}
	
	/* Creates an array that is sorted */
	public static int[] getSortedArray(int size) {
		int[] array = AssortedMethods.randomArray(size, -1 * size, size);
		Arrays.sort(array);
		return array;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			int size = AssortedMethods.randomIntInRange(5, 20);
			int[] array = getSortedArray(size);
			int v2 = magicFast(array);
			if (v2 == -1 && magicSlow(array) != -1) {
				int v1 = magicSlow(array);
				System.out.println("Incorrect value: index = -1, actual = " + v1 + " " + i);
				System.out.println(AssortedMethods.arrayToString(array));
				break;
			} else if (v2 > -1 && array[v2] != v2) {
				System.out.println("Incorrect values: index= " + v2 + ", value " + array[v2]);
				System.out.println(AssortedMethods.arrayToString(array));
				break;
			}
		}
	}

}
