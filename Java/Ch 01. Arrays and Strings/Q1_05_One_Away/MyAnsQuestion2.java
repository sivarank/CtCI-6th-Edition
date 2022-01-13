package Q1_05_One_Away;
/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, ple -) true
pales, pale -) true
pale, bale -) true
pale, bae -) false
 * @author SIVAR1
 *
 */
public class MyAnsQuestion2 {

	/**
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static boolean isOneWay(String str1, String str2){
		if(str1.length() == 0){
			return str2.length() <= 1;
		}else if(str2.length() == 0){
			return str1.length() <= 1;
		}else if(str1.length() - str2.length() > 1 || str2.length() - str1.length() > 1){
			return false;
		}

		// Make sure str1 is bigger
		if(str1.length() < str2.length()){
			String temp = str1;
			str1 = str2;
			str2 = temp;
		}
		
		int differenceCount = 0;
		int i=0,j=0;
		for(; i< str1.length() && j < str2.length(); i++){
			if(str1.charAt(i) != str2.charAt(j)) {
				differenceCount++;
				//check replace
				if(str1.length() == str2.length()) {
					j++;
				}
			}else {
				j++;
			}
			if(differenceCount > 1) {
				return false;
			}
		}
		if(i != str1.length()) {
			differenceCount++;
		}
		return differenceCount == 1;
	}

	public static void main(String[] args) {
		String[][] tests = { { "a", "b", "true" }, { "", "d", "true" }, { "d", "de", "true" },
				{ "pale", "pse", "false" }, { "acdsfdsfadsf", "acdsgdsfadsf", "true" },
				{ "acdsfdsfadsf", "acdsfdfadsf", "true" }, { "acdsfdsfadsf", "acdsfdsfads", "true" },
				{ "acdsfdsfadsf", "cdsfdsfadsf", "true" }, { "adfdsfadsf", "acdfdsfdsf", "false" },
				{ "adfdsfadsf", "bdfdsfadsg", "false" }, { "adfdsfadsf", "affdsfads", "false" },
				{ "pale", "pkle", "true" }, { "pkle", "pable", "false" } };
		for (int i = 0; i < tests.length; i++) {
			String[] test = tests[i];
			String a = test[0];
			String b = test[1];
			boolean expected = test[2].equals("true");

			if (expected != isOneWay(a, b)) {
				System.out.println("Failed :" + a + "," + b + " :" + expected);
			}
			if (expected != isOneWay(b, a)) {
				System.out.println("Failed :" + a + "," + b + " :" + expected);
			}
		}
	}
}
