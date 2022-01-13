package Q10_07_Missing_Int;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MyQuestionA {
	public static long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
	public static byte[] bitfield = new byte [(int) (numberOfInts / 8)];
	
	public static void findOpenNumber() throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("C:\\Learn\\CareerCupJavaCode\\CtCI-6th-Edition\\Java\\Ch 10. Sorting and Searching\\Q10_07_Missing_Int\\input.txt"));
		while(in.hasNext()) {
			int val = in.nextInt();
			// find index, get byte
			int index = val /8;
			// set bit
			byte value = (byte)(1<<(val%8));
			bitfield[index] = (byte)(bitfield[index] | value);
		}
		int answer = -1;
		// second pass
		for(int i=0; i<bitfield.length; i++) {
			for(int j =0 ; j<8 ;j++) {
				if((int)(bitfield[i] & (1<<j)) == 0) {
					answer = 8*i+j;
					System.out.println(answer);
					return;
				}
			}
		}

	}

	public static void main(String[] args)  throws IOException {
		findOpenNumber();
	}

}
