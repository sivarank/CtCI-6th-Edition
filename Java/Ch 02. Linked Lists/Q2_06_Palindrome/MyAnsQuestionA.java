package Q2_06_Palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import CtCILibrary.LinkedListNode;

public class MyAnsQuestionA {
	private static Boolean isPalindrome(LinkedListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		Stack<Integer> stk = new Stack<Integer>();
		Queue<Integer> qu = new LinkedList<Integer>();
		//LinkedListNode p = head;
		while(head != null) {
			stk.push(head.data);
			qu.add(head.data);
			head = head.next;
		}
		// comapre stack and queues
		while(!stk.isEmpty()) {
			int val1 = stk.pop();
			int val2 = qu.poll();
			if(val1 != val2) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int length = 9;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		// nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindrome(head));
	}
}
