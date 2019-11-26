import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DumpClass {
	
	
	public static void dumpClass(Class input) {
		Class[] classInterfaces = input.getInterfaces();
		Package classPackage = input.getPackage();	
		Field[] fields = input.getDeclaredFields();
		Constructor[] constructors = input.getDeclaredConstructors();
		Method[] methods =  input.getDeclaredMethods();	
		
		System.out.println("Class Name: " + "\n	" + input);
		if(classPackage == null) {
			System.out.println("Package Name: " );
		}else {
			System.out.println("Package Name: " + "\n	" + classPackage.toString());
		}
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
		Field[] fields = classType.getDeclaredFields();
		Constructor[] constructors = classType.getDeclaredConstructors();
		Method[] methods =  classType.getDeclaredMethods();
		
		System.out.println("Class Name: " + "\n	" + classType);
		if(classPackage == null) {
			System.out.println("Package Name: " );
		}else {
			System.out.println("Package Name: " + "\n	" + classPackage.toString());
		}
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
