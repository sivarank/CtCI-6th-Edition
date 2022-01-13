package Introduction;

import java.util.EmptyStackException;

public class MyAnsStack<T> {
	private class MyStackNode<T>{
		private T data;
		private MyStackNode<T> next;
		private MyStackNode(T input){
			data = input;
			next = null;
		}
	}

	private MyStackNode<T> top;

	public void push(T input){
		MyStackNode<T> newNode = new MyStackNode<T>(input);
		newNode.next = top;
		top = newNode;
	}

	public T pop(){
		if(top == null){
			throw new EmptyStackException();
		}
		MyStackNode<T> temp = top;
		top = top.next;
		return temp.data;
	}
	
	public T peek(){
		if(top == null){
			throw new EmptyStackException();
		}
		return top.data;
	}
	public boolean isEmpty() {
		return top == null;
	}
}