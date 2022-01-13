package Q10_07_Missing_Int;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MyQuestionB {
	//public static long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
	public static int memorySize = 10000000;
	public static int[] array = new int [memorySize / 4];
	
	public static void findOpenNumber() throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("C:\\Learn\\CareerCupJavaCode\\CtCI-6th-Edition\\Java\\Ch 10. Sorting and Searching\\Q10_07_Missing_Int\\input.txt"));
		while(in.hasNext()) {
			int val = in.nextInt();
			// find index, get byte
			int index = val /1000;
			array[index] += 1;
		}
		
		int rangeStart = -1;
		for(int i =0;i<array.length;i++) {
			if(array[i] != 1000) {
				rangeStart = i*1000;
				break;
			}
		}
		if(rangeStart == -1) {
			System.out.println("input is wrong");
			return;
		}
	
		
		for(int i =0; i<1000; i++) {
			array[i] = 0;
		}
		//int  i= 0;
		in = new Scanner(new FileReader("C:\\Learn\\CareerCupJavaCode\\CtCI-6th-Edition\\Java\\Ch 10. Sorting and Searching\\Q10_07_Missing_Int\\input.txt"));
		while(in.hasNext()) {
			int val = in.nextInt();
			if(val >= rangeStart && val < (rangeStart+1000)) {
				array[val%1000] = 1;
			}
		}
		for(int i =0; i<1000; i++) {
			if(array[i] ==0) {
				System.out.println("found result :"+(rangeStart+i));
			}
		}
		return ;
	}

	public static void main(String[] args)  throws IOException {
		findOpenNumber();
	}

}
