import java.util.ArrayList;


public class Strings {

	public static String uniqueLetters(String str) {
		String finalString = "";
		String currentChar;
		int count; 
		
		ArrayList<String> usedCharacters = new ArrayList<>();
		for(int i = 0; i < str.length(); i++) { //first loop through the string to find the unique letters
			currentChar = String.valueOf(str.charAt(i));
			if(!usedCharacters.contains(currentChar)) {
				usedCharacters.add(currentChar);
			}
		}
		for(String charToFind: usedCharacters) {
			count = 0;
			for(int j = 0; j < str.length(); j++) {
				currentChar = String.valueOf(str.charAt(j));
				if(charToFind.equals(currentChar)) {
					count++;
				}
			}
			if(count == 1) {
				finalString += charToFind;
			}
		}
		return finalString;
	}
}
