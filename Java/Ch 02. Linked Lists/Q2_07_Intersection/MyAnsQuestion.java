package Q2_07_Intersection;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class MyAnsQuestion {
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);
		
		int[] vals2 = {12, 14, 15};
		LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);
		
		list2.next.next = list1.next.next.next.next;
		
		System.out.println(list1.printForward());
		System.out.println(list2.printForward());
		
		
		LinkedListNode intersection = findIntersection(list1, list2);
		
		System.out.println(intersection.printForward());
	}

	private static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
		int len1 = 0, len2 =0;
		LinkedListNode p1 = list1, p2 = list2;
		// count number of nodes
		while(p1 != null){
			len1++;
			p1 = p1.next;
		}
		while(p2 != null){
			len2++;
			p2 = p2.next;
		}

		p1 =list1;
		p2 = list2;
		int diff = Math.abs(len1 - len2);
		// Swap p1 and p2 pointers if list2 is lengthy
		if(len1 < len2){
			p1 = list2;
			p2 = list1;
		}
		
		// Move p1 pointer 
		for(int i=0; i< diff; i++){
			p1 = p1.next;
		}
		// Find intersection
		while(p1 != null){
			if(p1 == p2){
				return p1;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return null;
	}

}
