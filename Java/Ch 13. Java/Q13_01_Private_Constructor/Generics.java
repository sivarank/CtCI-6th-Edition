package Q13_01_Private_Constructor;

public class Generics {
	private Generics() {
		System.out.println("Generics Class");
	}
	
	static class Gen<T, T2>{ // Genrics are useful for Cache implementation
		T type;
		Gen(T type1){
			type = type1;
			System.out.println(type);
			System.out.println(type.getClass().getName());
		}
	}
    
	public static void main(String[] args) {
		Gen<Integer, Integer> in = new Gen<Integer, Integer>(123);
		Gen<Integer, String> in2 = new Gen<Integer, String>(456);
		//Gen<Integer, int> in2 = new Gen<Integer, int>(456); // primitive types are not allowed
	}
}

