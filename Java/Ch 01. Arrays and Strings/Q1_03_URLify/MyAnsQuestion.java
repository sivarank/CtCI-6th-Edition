package Q1_03_URLify;

public class MyAnsQuestion {
	private static String replaceSpaces(String inputURL, int len){
		char[] text = inputURL.toCharArray();
		int srcEnd = len-1;
		int spacesCount = 0;
	    while(text[srcEnd] == ' '){
	    	srcEnd--;
	    }
	    for(int i=0; i<= srcEnd; i++) {
	    	if(text[i] ==' ') {
	    		spacesCount++;
	    	}
	    }

	    int destEnd = srcEnd + spacesCount*2;
	    
	    for(;srcEnd>=0;srcEnd--){
	    	if(text[srcEnd] != ' '){
	    		text[destEnd--] = text[srcEnd];
	    	}else{
	    		text[destEnd--] ='0';
	    		text[destEnd--] ='2';
	    		text[destEnd--] ='%';
	    	}
	    }
	    return new String(text);
	}
	public static void main(String args[]){
		System.out.println("input is \"SIVA VENKAT\" :"+replaceSpaces("SIVA VENKAT  ", 13));
		System.out.println("input is \"SIVA VENKAT\" :"+replaceSpaces("SIVA VENKAT       ", 17));
	}
}
