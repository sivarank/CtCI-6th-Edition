package IntroductionA;

public class MyThread {

	static class Test1 extends Thread{
		@Override
		public void run() {
			System.out.println("Thread subclass");
		}
	}
	
	static class Test implements Runnable{
		public void run() {
			System.out.println("thread Runnable");
		}
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		Thread th = new Thread(test);
		th.start();
		
		Test1 tes1 = new Test1();
		tes1.start();
	}

}
