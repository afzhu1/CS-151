import java.util.*;

public class Lab3 {
	

	public static <E> void dumpArray(E[] list) {
		for(int i = 0; i < list.length; i++) {
			if(list[i] instanceof Object) {
				System.out.println(list[i].toString());
			}
		}
	}
	
	
	public static void main(String[] args) {
		String[] stringTest = new String[3];
		stringTest[0] = "0";
		stringTest[1] = "1";
		stringTest[2] = "2";
		dumpArray(stringTest);
		Integer[] integerTest = new Integer[3];
		integerTest[0] = 1;
		integerTest[1] = 2;
		integerTest[2] = 3;
		dumpArray(integerTest);
		int[] intTest = new int[3];
		intTest[0] = 1;
		intTest[1] = 2;
		intTest[2] = 3;
	//	dumpArray(intTest);
	}
}
