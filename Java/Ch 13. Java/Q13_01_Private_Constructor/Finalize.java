package Q13_01_Private_Constructor;

public class Finalize {
	private Finalize() {
		System.out.println("Finalize Class");
	}
	
	protected void finalize(){ // LEarn: finalize method. but this is not called
		System.out.println("Called finalize");
	}
    
	public static void main(String[] args) {
		{
			new Test();
		}
		Finalize q = new Finalize();
		System.gc();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Test{
	public void finalize(){ // LEarn: finalize method
		System.out.println("Called Test finalize");
	}
}
