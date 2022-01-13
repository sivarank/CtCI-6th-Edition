package Q2_05_Sum_Lists;
import java.util.LinkedList;

import CtCILibrary.LinkedListNode;

public class MyAnsQuestionB2021 {
	
	

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
		LinkedListNode p1 = lA1;
		LinkedListNode p2 = lB1;
		int carry = 0; 
		LinkedListNode head = null, prev = null;
		while(p1 != null || p2 != null) {
			int sum = carry;
			if(p1 != null) {
				sum += p1.data;
				p1 = p1.next;
			}
			if(p2 != null) {
				sum += p2.data;
				p2 = p2.next;
			}

			if(head == null) {
				head = new LinkedListNode(sum %10, null, null);
				prev = head;
			}else {
				prev.next = new LinkedListNode(sum %10, null, null);
				prev = prev.next;
			}
			carry = sum/10;
		}
		
		lA1 = reverseList(lA1);
		lB1 =  reverseList(lB1);
		return head;
	}

	private static LinkedListNode reverseList(LinkedListNode lA1) {
		
		/*
		 * 1. single node
		 * 2. two nodes
		 * 3. even number of nodes  1->2->3->4->5
		 * 4. odd number of nodes
		 */
		
		if(lA1 == null || lA1.next == null) {
			return lA1;
		}
		
		LinkedListNode p = null;
		LinkedListNode q = lA1;  //1
		LinkedListNode r = q.next; //2
		while(q != null && r!= null) {
			LinkedListNode temp = r.next; // 3
			r.next = q;// 1<-2
			q.next = p; // 2<-3
			
			p = r; // p = 2
			q = temp;// 3
			if(q != null) {
				r= q.next; // 4
			}
		}
		if(q!= null && r == null) {
			q.next = p;
			p =q;
		}
		return p;
	}
	

}
