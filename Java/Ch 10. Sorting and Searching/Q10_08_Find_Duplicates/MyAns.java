package Q10_08_Find_Duplicates;

import java.util.BitSet;

import CtCILibrary.AssortedMethods;

public class MyAns {

	public static void checkDuplicates(int[] array) {
		BitSet bitSet = new BitSet(32000+1);
		for(int i=0 ;i <array.length; i++) {
			int value = array[i];
			if(bitSet.get(value)) {
				System.out.println(value);
			}else {
				bitSet.set(value);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = AssortedMethods.randomArray(30, 1, 30);
		System.out.println(AssortedMethods.arrayToString(array));
		checkDuplicates(array);
	}

}
