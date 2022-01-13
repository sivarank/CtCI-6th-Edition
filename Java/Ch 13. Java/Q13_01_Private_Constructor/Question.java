package Q13_01_Private_Constructor;

public class Question {
	private Question() {
		System.out.println("Q");
	}
	
     class A {
        private A() { // NOTE: Private constructor
    		System.out.println("A");
        }
    }

     class B extends A {
    	public B() {
    		System.out.println("B");
    	}
    }
     
     class C {
         C() {
     		System.out.println("C");
     		A a = new A();
         }
     }
    
	public static void main(String[] args) {
		Question q = new Question();
		B b = q.new B();// Learning "classObject.new" is new 
		A a = q.new A();// outer class can create 
	}

}
