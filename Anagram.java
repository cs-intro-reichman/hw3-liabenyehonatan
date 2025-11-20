/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String newStr1 = preProcess(str1);
		String newStr2 = preProcess(str2);

		if (newStr1.length() != newStr2.length()) {
			return false;
		}

		while (newStr1.length() > 0) {
			boolean match = true;
			for (int i = 0; i < newStr2.length(); i++) {
				if (newStr2.charAt(i) == newStr1.charAt(0)) {
					newStr1 = newStr1.substring(1);
					newStr2 = newStr2.substring(0, i) + newStr2.substring(i + 1);
					match = true;
					break;
				}

			}
			if (!match) {
				return false;
			}
		}
		return true;
	}

	public static String preProcess(String str) {

		String newStr = "";
		int i = 0;

		while (i < str.length()) {
			char c = str.charAt(i);

			if (Character.isLetter(c)) {
				newStr = newStr + Character.toLowerCase(c);
			} else if (Character.isDigit(c)) {
				newStr = newStr + c;
			} else if (c == ' ') {
				newStr = newStr + ' ';
			}

			i++;
		}

		return newStr;
	}

	public static String randomAnagram(String str) {

		String newWord = "";

		while (str.length() > 0) {
			int randIndex = (int) (Math.random() * str.length());

			char c = str.charAt(randIndex);

			newWord = newWord + c;

			str = str.substring(0, randIndex) + str.substring(randIndex + 1, str.length());

		}

		return newWord;
	}
}
