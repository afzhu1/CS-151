import java.lang.reflect.*;


public class Question1 {

		public static void main(String []args) {
			Integer test = new Integer(3);
			DumpClass.dumpClass(test.getClass());
			DumpClass.dumpClass(test);
		}
	
		
}
