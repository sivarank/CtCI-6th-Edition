package Q2_05_Sum_Lists;
import java.util.LinkedList;

import CtCILibrary.LinkedListNode;

public class MyAnsQuestionB {
	
	

	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(3, null, null);
		LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
		
		LinkedListNode lB1 = new LinkedListNode(5, null, null);
		LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(1, null, lB2);	
	
		LinkedListNode list3 = addLists(lA1, lB1);
		
		System.out.println("  " + lA1.printForward());		
		System.out.println("+ " + lB1.printForward());	
		System.out.println("= " + list3.printForward());	
		
//		int l1 = linkedListToInt(lA1);
//		int l2 = linkedListToInt(lB1);
//		int l3 = linkedListToInt(list3);
//		
//		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
//		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));		
	}

	private static LinkedListNode addLists(LinkedListNode lA1, LinkedListNode lB1) {
		lA1 = reverseList(lA1);
		lB1 =  reverseList(lB1);
		LinkedListNode p1 = lA1, p2 = lB1, newListHead = null, newListTail = null;
		int remainder =0;
		while(p1 != null || p2 != null || remainder != 0) {
			int sum = 0;
			if(p1 != null ) 
				sum = p1.data;
			if(p2 != null)
				sum += p2.data;				
			if(remainder > 0)
				sum += remainder;
			LinkedListNode newNode = new LinkedListNode(sum %10);
			remainder = sum/10;
			if(newListHead == null) {
				newListHead = newNode;
				newListTail = newNode;
			}else{
				newListTail.next = newNode;
				newListTail = newNode;
			}
			if(p1 != null) {
				p1 = p1.next;
			}
			if(p2 != null) {
				p2 = p2.next;
			}
		}
		reverseList(lA1);
		reverseList(lB1);
		return reverseList(newListHead);
	}
	
	public static LinkedListNode reverseList(LinkedListNode head) {
		if(head == null) {
			return head;
		}
		LinkedListNode newHead = head, p = head, q= head.next, r=null;
		//set tail next null;
		p.next = null;
		while(q!=null) {
			r = q.next;
			if(r == null) {
				newHead = q;
			}
			q.next = p;
			
			p = q;
			q = r;
		}
		return newHead;
	}
}
