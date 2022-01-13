package Q8_05_Recursive_Multiply;

public class MyAnsQuestion {
	public static int counter = 0;
	
	/* This is an algorithm called the peasant algorithm. 
	 * https://en.wikipedia.org/wiki/Multiplication_algorithm#Peasant_or_binary_multiplication 
	 */
	public static int minProduct(int a, int b) {
		if(b <= 0) {
			return 0;
		}
		
		int result = minProduct(a, b>>1);
		result += result;
		return ((b&1) == 1) ? result + a : result;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				int prod1 = minProduct(i, j);
				int prod2 = i * j;
				if (prod1 != prod2) {
					System.out.println("ERROR: " + i + " * " + j + " = " + prod2 + ", not " + prod1);
				}
			}
		}
	}

}
