package Introduction;

import java.util.NoSuchElementException;

public class MyAnsQueue<T> {
	private static class QueueNode<T>{
		private T data;
		private QueueNode<T> next;
		public QueueNode(T input){
			data = input;
			next = null;
		}
	}
	
	QueueNode<T> front = null, rear = null;

	public boolean isEmpty(){
		return front == null;
	}

	public void add(T input){
		QueueNode<T> temp = new QueueNode<T>(input);
		// if it is first node
		if(rear == null){
			front = rear = temp;
		}else{
			rear.next = temp;
			rear = temp;
		}
	}

	public T remove(){
		if(front == null){
			throw new NoSuchElementException();
		}
		QueueNode<T> temp = front;
		front = front.next;
		if(front == null){
			rear = null;
		}
		return temp.data;
	}

	public T peek(){
		if(front == null){
			throw new NoSuchElementException();
		}
		return front.data;
	}
}
