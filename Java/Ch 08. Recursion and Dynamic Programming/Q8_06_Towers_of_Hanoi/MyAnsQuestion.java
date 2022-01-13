package Q8_06_Towers_of_Hanoi;

import java.util.Stack;

public class MyAnsQuestion {
	public static void main(String[] args) {
		Tower1 source = new Tower1("s");
		Tower1 destination = new Tower1("d");
		Tower1 buffer = new Tower1("b");
		
		/* Load up tower */
		int numberOfDisks = 5;
		for (int disk = numberOfDisks - 1; disk >= 0; disk--) {
			source.add(disk);
		}
		
		source.print();
		source.moveDiscs(destination, buffer, numberOfDisks);
		destination.print();
	}
}
class Tower1{
	private Stack<Integer> stk = new Stack<Integer>();
	
	String name;
	
	public Tower1(String inputName){
		name = inputName;
	}
	String getName(){
		return name;
	}
	void add(int num){
		if(!stk.isEmpty() && stk.peek() <= num)
		{
			System.out.println("can add input number : "+num);
		}else{
			stk.push(num);
		}
	}
	
	public void print() {
		System.out.println("Contents of Tower " + name + ": " + stk.toString());
	}
	
	void moveDiscs(Tower1 dest, Tower1 buffer, int numberOfDiscs){
		if(numberOfDiscs == 0){
			return;
		}
		
		moveDiscs(buffer, dest, numberOfDiscs-1);
		int val = stk.pop();
		System.out.println("moving disc "+val+" to "+dest.name+" from "+name);
		dest.add(val);
		
		buffer.moveDiscs(dest, this, numberOfDiscs-1);
	}
}
