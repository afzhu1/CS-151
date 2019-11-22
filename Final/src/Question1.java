import java.lang.reflect.*;
import java.util.*;

public class Question1 {

		public static void main(String []args) {
			Integer test = new Integer(3);
			ArrayList<Integer> integerArray = new ArrayList<>();
			String stringTest = new String("yeet");
			DumpClass.dumpClass(test.getClass());
			DumpClass.dumpClass(test);
			DumpClass.dumpClass(stringTest);
			DumpClass.dumpClass(integerArray);
		}
	
		
}
