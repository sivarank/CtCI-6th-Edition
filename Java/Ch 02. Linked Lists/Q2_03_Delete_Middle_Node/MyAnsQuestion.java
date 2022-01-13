package Q2_03_Delete_Middle_Node;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class MyAnsQuestion {

	public static boolean deleteNode(LinkedListNode head) {
		// take two points p1 & p2 , forward p1 one step , but p2 two steps. When p2 reaches end , p1 will be at middle
		
		// handle corner cases like only one node. 
		
		LinkedListNode p1 = head, p2 = head;
		while(!isNextStepLastNodeOrNull(p2)) {
			p1 = p1.next;
			p2 = p2.next.next;
		}
		p1.next = p1.next.next;
		return true;
	}
	
	private static boolean isNextStepLastNodeOrNull(LinkedListNode p2) {
		return p2.next != null && p2.next.next != null && p2.next.next.next != null ? false: true;
	}

	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(2, 0, 2);
		System.out.println(head.printForward());
		deleteNode(head); // delete node 4
		System.out.println(head.printForward());
	}

}
