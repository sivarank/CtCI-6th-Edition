package Q2_01_Remove_Dups;

import CtCILibrary.LinkedListNode;

public class MyAnsQuestionB2021 {
	public static void deleteDups(LinkedListNode head) {
		LinkedListNode p = head;
		while(p!= null && p.next != null) {
			LinkedListNode q = head;
			while(p.next != q) {
				if(p.next.data == q.data) {
					// remove duplicate 
					p.next = p.next.next;
					break;
				}
				q = q.next;
			}
			if(p.next == q) {
				p = p.next;			
			}
		}

	}
	
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i%4, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		
		System.out.println(head.printForward());
		deleteDups(head);
		System.out.println(head.printForward());
	}
}
