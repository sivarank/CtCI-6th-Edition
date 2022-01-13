package Q2_02_Return_Kth_To_Last;

import CtCILibrary.*;


/*
 * Learning: if Node is inner class I must use , object instance to create inner class
 * Node head = obj.new Node(1);
 */
public class MyAnsQuestion2021 {

public static void main(String args[]) {
	// create list 
	MyAnsQuestion2021 obj = new MyAnsQuestion2021();
	// 
	Node head = new Node(1);
	head.setNext(new Node(2));
	head.getNext().setNext(new Node(3));
	head.getNext().getNext().setNext(new Node(4));
	head.getNext().getNext().getNext().setNext(new Node(5));
	
	for(int i=1;i<= 5; i++) {
		int count = i;
		Node p = head;
		while(count != 1) {
			count--;
			p = p.getNext();
		}
		System.out.println(p.getVal());
	}
}


}
class Node{
	private int data;
	private Node next;
	Node(int val){
		data = val;
		next = null;
	}
	void setNext(Node node){
		next = node;
	}
	Node getNext(){
		return next; 
	}
	int getVal() {
		return data; 
	}
}
