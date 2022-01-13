package Q1_04_Palindrome_Permutation;
/**
 * 1.4 Palindrome Permutation: Given a string, write a function to check if it is a permutation of
a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
permutation is a rearrangement of letters. The palindrome does not need to be limited to just
dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations:"taco cat'; "atco cta'; etc.)
 * @author SIVAR1
 *
 */

// USing bit vector
public class MyAnsQuestionC {	
	//Assume input text is ASCCII text. 
	// mine is case sensitive code
	private static boolean isPermutationOfPalindrome(String input){
		if(input.length() < 2){
			return true;
		}
		
		int[] bitVector = new int[4]; // int array initialized to 0 
		int oddCountCharacters = 0;
		for(int i=0; i< input.length(); i++){
			char ch = input.charAt(i);
			
			//ignore spaces
			if(ch != ' '){
				int index = (int)ch/32;
				int bitPosition = (int)ch % 32;
				bitVector[index] ^= (1<<bitPosition);
				if((bitVector[index] & (1<<bitPosition)) > 0 ) {
					oddCountCharacters++;
				}else {
					oddCountCharacters--;
				}
			}
		}

		if(oddCountCharacters > 1){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String pali = "Rats live on no evil star";
		System.out.println(pali+":"+isPermutationOfPalindrome(pali));
		System.out.println("SI A I S :"+isPermutationOfPalindrome("SI A I S "));
		
		String[] strings = {"Rats live on no evil star",
				"A man, a plan, a canal, panama",
				"Lleve",
				"Tacotac",
				"asda"};
		for (String s : strings) {
			System.out.println(s+" : "+isPermutationOfPalindrome(s));

		}
	}
}
