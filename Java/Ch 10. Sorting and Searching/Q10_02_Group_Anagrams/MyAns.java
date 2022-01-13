package Q10_02_Group_Anagrams;

import java.util.Arrays;
import java.util.Comparator;

import CtCILibrary.AssortedMethods;

public class MyAns {
	public static void main(String[] args) {
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		int size = array.length; // array length
		for(int i=0; i< size; i++) {
			array[i] = getSortedString(array[i]);
		}
		Arrays.sort(array);
		System.out.println(AssortedMethods.stringArrayToString(array));
	}

	private static String getSortedString(String string) {
		char[] chArray = string.toCharArray();
		Arrays.sort(chArray);
		return new String(chArray);
	}
}
