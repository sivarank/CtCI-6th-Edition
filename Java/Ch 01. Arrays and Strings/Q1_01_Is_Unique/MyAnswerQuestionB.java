package Q1_01_Is_Unique;

import java.util.Arrays;

/**
 * Question:
 *  Is Unique: 
 *  QA) Implement an algorithm to determine if a string has all unique characters. 
 *  
 *  QB) What if you cannot use additional data structures?
 * @author SIVAR1
 *
 */
//Time complexity is O(n), space complexity O(1)

// Assume input text is ASCI text , not Unique code text or extended ASCCII text
public class MyAnswerQuestionB {
	private boolean isUnique(String inputString) {
		//Handle corner cases
		if(inputString.isEmpty()) {
			return true;
		}
		if(inputString.length() > 128) {
			return false;
		}
		int[] checker = new int[4]; 
		for(int i = 0; i<inputString.length(); i++) {
			int index = (int)inputString.charAt(i) / 32;
			int bitPosition = (int)inputString.charAt(i) % 32;
			if((checker[index] & (1 << bitPosition)) > 0){
				return false;
			}
			checker[index] |= 1<<bitPosition;
		}
		return true;
	}
	
	public static void main(String[] args) {
		MyAnswerQuestionB object = new MyAnswerQuestionB();
		System.out.println("abc, "+ object.isUnique("abc"));
		System.out.println("abca, "+ object.isUnique("abca"));
		System.out.println("Empty string, ans: "+ object.isUnique(""));
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + object.isUnique(word));
		}
		
	}
}



