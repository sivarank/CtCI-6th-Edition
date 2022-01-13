package Q13_06_Object_Reflection;

public class Rectangle {
	private double width;
	private double height;
	public Rectangle(double w, double h) {
		width = w;
		height = h;
	}
	
	protected double area() {
		return width * height;
	}
	
	protected double area(double d) {
		return width * height*d;
	}
}
