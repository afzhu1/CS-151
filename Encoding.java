import java.util.Set;
import java.util.TreeSet;

public class Encoding {

	public static Set<String> morseCodes(int m, int n) {
		Set<String> result = new TreeSet<>();
		result.addAll(morseRecurse(result, ".", m - 1, n));
		result.addAll(morseRecurse(result, "-", m, n - 1));
		return result;
	}

	public static Set<String> morseRecurse(Set<String> toReturn, String prev, int m, int n) {
		if (m == 0 && n == 0) {
			toReturn.add(prev);
			return toReturn;
		} else {
			if (m > 0) {
				toReturn.addAll(morseRecurse(toReturn, prev + ".", m - 1, n));
			}
			if (n > 0) {
				toReturn.addAll(morseRecurse(toReturn, prev + "-", m, n - 1));
			}
			return toReturn;
		}
	}
}
