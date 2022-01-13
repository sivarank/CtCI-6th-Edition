package Q2_02_Return_Kth_To_Last;

import CtCILibrary.*;
/*
class ListNode{
	public ListNode next;
	public int data;
}
*/

public class MyAnsQuestionA {

	public static int printKthToLast(LinkedListNode head, int k) {
		LinkedListNode p1 = head, p2=head;
		//Move p1 k times
		for(int i=0; p1 != null && i < k; p1=p1.next,i++);
		if(p1 == null) {
			return Integer.MIN_VALUE;
		}
		while(p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2.data;
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
		for (int i = 0; i <= array.length + 1; i++) {
			System.out.println(printKthToLast(head, i));
		}
	}

}
