package Q1_06_String_Compression;

public class MyAnsQuestionA {	
	public static String compressBad(String str) {
		if(str.length() < 3) {
			return str;
		}
		
		StringBuilder sb = new StringBuilder();
		char previousChar = str.charAt(0);
		int charCount = 1;
		for(int i=1; i< str.length(); i++) {
			if(previousChar == str.charAt(i)) {
				charCount++;
			}else {
				sb.append(previousChar);
				sb.append(charCount);
				previousChar = str.charAt(i);
				charCount = 1;
			}
		}
		sb.append(previousChar);
		sb.append(charCount);
		return sb.toString().length() < str.length() ? sb.toString() : str;
	}
	
	public static void main(String[] args) {
		String str = "aa";
		System.out.println(str + ": "+compressBad(str));
		 str = "aabbbccd";
		System.out.println(str + ": "+compressBad(str));
		str = "aabbbccdd";
		System.out.println(str + ": "+compressBad(str));
	}
}
