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
public class MyAnswerQuestionA {
	private boolean isUnique(String inputString) {
		//Handle corner cases
		if(inputString.isEmpty()) {
			return true;
		}
		if(inputString.length() > 128) {
			return false;
		}
		boolean flags[] = new boolean[128];// by default , all entries set to false
		//to set true , we can use below line
		//Arrays.fill(flags, true); // this line set all values to true

		//int inputLength = inputString.length();// this is not required since String length operation is O(1) it internally uses backed array length
		
		for(int i = 0; i<inputString.length(); i++) {
			int index = (int)inputString.charAt(i);
			if(flags[index]){
				return false;
			}
			flags[index] = true;
		}
		return true;
	}
	public static void main(String[] args) {
		MyAnswerQuestionA object = new MyAnswerQuestionA();
		System.out.println("no duplicate string, ans: "+ object.isUnique("abc"));
		System.out.println("duplicate string, ans: "+ object.isUnique("abca"));
		System.out.println("Empty string, ans: "+ object.isUnique(""));
		System.out.println("huge string > 128 length, ans: "+object.isUnique("ASSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
	}
}



