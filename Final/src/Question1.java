import java.lang.reflect.*;


public class Question1 {

		public static void main(String []args) {
			Integer test = new Integer(3);
			dumpClass(test.getClass());
			dumpClass(test);
		}
	
		public static void dumpClass(Class input) {
			//Class input = input.getClass();
			Class[] classInterfaces = input.getInterfaces();
			Package classPackage = input.getPackage();
			String packageName = classPackage.getName();
			Field[] fields = input.getDeclaredFields();
			Constructor[] constructors = input.getDeclaredConstructors();
			Method[] methods =  input.getDeclaredMethods();
			
			
			System.out.println("Class Name: " + "\n	" + input);
			System.out.println("Package Name: " + "\n	" + classPackage.toString());
			System.out.println("Superclass: " + "\n	" + input.getSuperclass());
			System.out.println("Constructors: ");
			
			System.out.println("Fields: ");
			for(Field f: fields) {
				System.out.println("	" + f.toString());
			}
			
			for(Constructor c: constructors) {
				System.out.println("	" + c.toString());
			}
			System.out.println("Methods: ");
			for(Method m: methods) {
				System.out.println("	" + m.toString());
			}
			
			
			
		}
		
		// @overload
		public static void dumpClass(Object input) {
			Class classType = input.getClass();
			Class[] classInterfaces = classType.getInterfaces();
			Package classPackage = classType.getPackage();
			String packageName = classPackage.getName();
			Field[] fields = classType.getDeclaredFields();
			Constructor[] constructors = classType.getDeclaredConstructors();
			Method[] methods =  classType.getDeclaredMethods();
			
			
			System.out.println("Class Name: " + "\n	" + classType);
			System.out.println("Package Name: " + "\n	" + classPackage.toString());
			System.out.println("Superclass: " + "\n	" + classType.getSuperclass());
			System.out.println("Fields: ");
			for(Field f: fields) {
				System.out.println("	" + f.toString());
			}
			System.out.println("Constructors: ");
			for(Constructor c: constructors) {
				System.out.println("	" + c.toString());
			}
			System.out.println("Methods: ");
			for(Method m: methods) {
				System.out.println("	" + m.toString());
			}
			
			
			
		}
}
