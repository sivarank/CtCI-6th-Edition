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
public class MyAnsQuestionA {	
	//Assume input text is ASCCII text. 
	// mine is case sensitive code
	private static boolean isPermutationOfPalindrome(String input){
		if(input.length() < 2){
			return true;
		}
		
		int[] count = new int[128]; // int array initialized to 0 
		for(int i=0; i< input.length(); i++){
			char ch = input.charAt(i);
			//ignore spaces
			if(ch != ' '){
				int index = (int)ch;
				count[index] += 1;
			}
		}

		int oddCountCharacters = 0;
		for(int i=0; i<128; i++){
			if(count[i] % 2 == 1){
				oddCountCharacters++;
				if(oddCountCharacters > 1){
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String pali = "Rats live on no evil star";
		System.out.println(pali+":"+isPermutationOfPalindrome(pali));
		System.out.println("SI A I S :"+isPermutationOfPalindrome("SI A I S "));
	}


}
