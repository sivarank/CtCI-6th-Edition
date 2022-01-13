package Q5_04_Next_Number;

public class MyAnsQuestionC {
	public static int getNextArith(int n) {
		if(n == 0 || n < 0) {
			return Integer.MIN_VALUE;
		}
		
		int c = n;
		int c0 = 0, c1= 0;

		while(((c & 1) == 0) && (c != 0)){
			c0++;
			c >>=1;
		}

		while((c & 1) == 1){
			c1++;
			c >>>=1;
		}
		// handle , all 1s, all os ,  1111111111110000000000
		if(c1+c0 >= 31){
			return Integer.MIN_VALUE;
		}

		int p = c0+c1; // zero bit position to be toggled

		return ((n | (1<< p)) & (~((1<<p) -1))) | (((1<<(c1+1)) - 1) << c0);
	}
	
	public static int getPrevArith(int n) {
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while (((temp & 1) == 1) && (temp != 0)) {
			c1++;
			temp >>= 1;
		}
		
		/* If temp is 0, then the number is a sequence of 0s followed by a sequence of 1s. This is already
		 * the smallest number with c1 ones. Return -1 for an error.
		 */
		if (temp == 0) { 
			return -1;
		}
		
		while ((temp & 1) == 0 && (temp != 0)) {
			c0++;
			temp >>= 1;
		}

		/* Arithmetic:
		 * 2^c1 = 1 << c1
		 * 2^(c0 - 1) = 1 << (c0 - 1)
		 */
		return n - (1 << c1) - (1 << (c0 - 1)) + 1;		
	}	
	
	public static void binPrint(int i) {
		System.out.println(i + ": " + Integer.toBinaryString(i));		
	}
	
	public static void main(String[] args) {
		int i = 13948;
		int p1 = getPrevArith(i);
		int n1 = getNextArith(i);
		Tester.binPrint(p1);
		Tester.binPrint(n1);
	}

}
