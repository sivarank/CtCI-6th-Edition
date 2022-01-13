package IntroductionWaitNotify;

public class MyClass extends Thread  {
	private String name;
	private MyObject myObj;
	
	public MyClass(MyObject obj, String n) {
		name = n;
		myObj = obj;
	}
	
	public void run() {
		try {
			System.out.println("thread run() "+name);
			myObj.wait(5000);
			System.out.println("thread run() "+name);
			myObj.foo(name);
			myObj.notify();			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
