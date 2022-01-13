package Q2_01_Remove_Dups;

import java.util.HashSet;
import CtCILibrary.LinkedListNode;

public class MyAnsQuestionA {
	public static void deleteDups(LinkedListNode head) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode current = head;//.next;
		while(current != null) {
			if(set.contains(current.data)) {
				current.prev.next = current.next;
				if(current.next != null) {
					current.next.prev = current.prev;					
				}
				current.prev = null;
			}else {
				set.add(current.data);
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
