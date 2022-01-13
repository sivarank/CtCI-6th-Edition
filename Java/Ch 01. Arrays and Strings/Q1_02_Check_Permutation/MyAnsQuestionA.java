package Q1_02_Check_Permutation;

import java.util.Arrays;

public class MyAnsQuestionA {	
	private static String sortString(String input){
		char[] text = input.toCharArray();
		Arrays.sort(text);
		return new String(text);
	}

	private static boolean isTwoStringsAnagrams(String input1, String input2){
		return sortString(input1).equals(sortString(input2));
	}
	public static void main(String args[]){
		System.out.println("is  \"siva\" and \"vias\" :"+isTwoStringsAnagrams("siva","ivas"));
	}
}
