package Q2_01_Remove_Dups;

import CtCILibrary.LinkedListNode;

public class MyAnsQuestionB {
	public static void deleteDups(LinkedListNode head) {

		LinkedListNode current = head.next;//.next;
		while(current != null) {
			//if the value not already present in the list, add
			LinkedListNode start = head;
			while(start != current) {
				if(start.data == current.data) {
					break;
				}
				start = start.next;
			}
			// there is duplicate, skip element
			if(start != current) {
				current.prev.next = current.next;
				if(current.next != null) {
					current.next.prev = current.prev;
				}
			}
			current = current.next;
		}
	}
	
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(1, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		
		System.out.println(head.printForward());
		deleteDups(head);
		System.out.println(head.printForward());
	}
}
