package Q5_02_Binary_to_String;

public class MyAnsQuestion {
	public static String printBinary(double num) {
		if(num >= 1 || num <=0) {
			return "ERROR";
		}
		StringBuilder strb = new StringBuilder();
		strb.append("0.");
		while(num > 0) {
			num *= 2; 
			if(num >= 1) {
				strb.append('1');
				num -= 1;
			}else {
				strb.append('0');
			}
		}
		return strb.toString();
	}
	
	public static String printBinary2(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
	
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() >= 32) {
				return "ERROR";
			}
			if (num >= frac) {
				binary.append(1);
				num -= frac;
			} else {
				binary.append(0);
			}
			frac /= 2;
		}
		return binary.toString();
	}	
	
	public static void main(String[] args) {
		String bs = printBinary(.125);
		System.out.println(bs);
		
		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = printBinary(num);
			String binary2 = printBinary2(num);
			if (!binary.equals("ERROR") || !binary2.equals("ERROR")) {
				System.out.println(num + " : " + binary + " " + binary2);
			}
		}
	}
}
