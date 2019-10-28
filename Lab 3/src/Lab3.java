import java.lang.reflect.Array;


public class Lab3 {
	

	public static void dumpArray(Object array) {
		if(array.getClass().isArray()) {
			for(int i = 0; i < Array.getLength(array); i++) {
				System.out.println(Array.get(array, i).toString());
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
		integerTest[0] = 3;
		integerTest[1] = 4;
		integerTest[2] = 5;
		dumpArray(integerTest);
		int[] intTest = new int[3];
		intTest[0] = 6;
		intTest[1] = 7;
		intTest[2] = 8;
		dumpArray(intTest);
	}
}

