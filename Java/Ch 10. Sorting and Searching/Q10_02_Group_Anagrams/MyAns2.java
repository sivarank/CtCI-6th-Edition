package Q10_02_Group_Anagrams;

import java.util.Arrays;
import java.util.Comparator;

import CtCILibrary.AssortedMethods;

public class MyAns2 {
	public static void main(String[] args) {
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		Arrays.sort(array, new AnagramComparator());
		for(String s : array) {
			System.out.println(s);
		}
	}


}
