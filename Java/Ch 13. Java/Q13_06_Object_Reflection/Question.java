package Q13_06_Object_Reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Question {
	public static void main(String args[]) {
		try {
			/* Parameters */
			Object[] doubleArgs = new Object[] { 4.2, 3.9 };
			
			/* Get class */
			Class rectangleDefinition = Class.forName("Q13_06_Object_Reflection.Rectangle");
			
			/* Equivalent: Rectangle rectangle = new Rectangle(4.2, 3.9); */
			Class[] doubleArgsClass = new Class[] {double.class, double.class};
			Constructor doubleArgsConstructor = rectangleDefinition.getConstructor(doubleArgsClass);
			Rectangle rectangle = (Rectangle) doubleArgsConstructor.newInstance(doubleArgs);
			System.out.println(rectangle.area());
			
			/* Equivalent: Double area = rectangle.area(); */
			Method m = rectangleDefinition.getDeclaredMethod("area");
			Double area = (Double) m.invoke(rectangle);
			System.out.println(area);
			
			/* Equivalent: Double area = rectangle.area(); */
			Method m1 = rectangleDefinition.getDeclaredMethod("area", new Class[] {double.class});
			Double area1 = (Double) m1.invoke(rectangle, 1.1);
			System.out.println(area1);

			
			System.out.println(Arrays.toString(rectangleDefinition.getFields()));
			System.out.println(Arrays.toString(rectangleDefinition.getMethods()));
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (NoSuchMethodException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		} catch (IllegalAccessException e) {
			System.out.println(e);
		} catch (InvocationTargetException e) {
			System.out.println(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
