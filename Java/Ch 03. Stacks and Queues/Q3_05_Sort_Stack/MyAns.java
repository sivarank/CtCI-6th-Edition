package Q3_05_Sort_Stack;

import java.util.Stack;

import CtCILibrary.AssortedMethods;

public class MyAns {

	
	public static void sort(Stack<Integer> s) {
		int n = s.size();
		
		for(int i=0; i< n; i++) {
			reversePush(s, n-i, s.pop());
		}
	}
		
	private static void reversePush(Stack<Integer> s, int depth, Integer min) {
		if(depth == 1) {
			s.push(min);
			return;
		}
		
		int elm = s.pop();
		
		if(min > elm) {
			reversePush(s, depth-1, elm);
			s.push(min);
		}else {
			reversePush(s, depth-1, min);
			s.push(elm);			
		}
		
	}

	public static void main(String [] args) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			int r = AssortedMethods.randomIntInRange(0,  1000);
			s.push(r);
		}
		
		sort(s);
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
}
