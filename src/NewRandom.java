import java.util.Random;

/**
 * 
 * This class is an upgrade of the java.util.Random class.
 * It has user-friendly, intuitive methods to generate 
 * a random number or character between a given range.
 * 
 * @author David Roy
 * Email: 
 * Student ID: 
 * 4/19/19

 * 
 */
public class NewRandom extends Random {
	/**
	 * This method generates a random number between
	 * the following range
	 * [low, b] and [c, high]
	 * @param low The lower bound of the lower range
	 * @param b The upper bound of the lower range
	 * @param c The lower bound of the upper range
	 * @param high The upper bound of the higher range
	 * @return
	 */
	public int nextInt(int low, int b, int c, int high) {
		//Generate a number for each sub range
		int num1 = nextInt(low, b);
		int num2 = nextInt(c, high);
		//based on random boolean, pick num1 or num2
		return nextBoolean() ? num1 : num2;
	}
	
	/**
	 * This method returns a String with
	 * the class name,
	 * random integer from [0,100],
	 * a random character from the alphabet,
	 * and a random 5 letter String
	 */
	@Override
	public String toString() {
		return this.getClass().getName() + " " + nextInt(0, 100) + " " + nextChar() + " " + nextWord(5);
	}
	

	/**
	 * This method generates a random number between
	 * a given range.
	 * @param low The lower bound of the desired range.
	 * @param high The upper bound of the desired range.
	 * @return int A random number between low and high.
	 */
	public int nextInt(int low, int high) {
		if (low > high) {     //to avoid negative bound exception
			int temp = low;
			low = high;
			high = temp;
		}
		
		return nextInt(high - low + 1) + low;
	}
	
	/**
	 * This method generates a random even number between
	 * a given range.
	 * @param low The lower bound of the desired range.
	 * @param high The upper bound of the desired range.
	 * @return int A random even number between low and high.
	 */
	public int nextEven(int low, int high) {
		//check if low is even, else, make it even
		if (low % 2 != 0) {
			low--; //decrement low to make it even and still cover the original range
		}
		return low + nextInt((high - low) / 2) * 2;
	}
	
	/**
	 * This method generates a random odd number between
	 * a given range.
	 * @param low The lower bound of the desired range.
	 * @param high The upper bound of the desired range.
	 * @return int A random odd number between low and high.
	 */
	public int nextOdd(int low, int high) {
		return low + nextInt((high - low - 1) / 2) * 2;
	}
	
	/**
	 * This method chooses a random letter from the
	 * lower case or upper case range. (from 'A' to 'z')
	 * 
	 * @return char A letter of the alphabet, lower or upper case; 
	 */
	public char nextChar() {
		return (char) nextInt('A', 'Z', 'a', 'z'); //cover the range: ['A', 'Z] and ['a', 'z']
		  
	}
	
	/**
	 * This method chooses a random letter from the
	 * upper case range. (from 'A' to 'Z')
	 * 
	 * @return char An upper case letter of the alphabet 
	 */
	public char nextCharCap() {
		return (char) nextInt('A', 'Z');
	}

	
	/**
	 * This method generates a random capital letter between
	 * the desired letter range. If the lower bound is greater
	 * than the upper bound, the range will be between 
	 * [low, 'Z'] and ['A', upper]
	 * 
	 * @param low The lower bound char.
	 * @param high The upper bound char.
	 * @return char Capital letter between low and high.
	 */
	public char nextCharCap(char low, char high) {
		//in case if the bounds are lower case
		int l = (int) Character.toUpperCase(low);
		int h = (int) Character.toUpperCase(high);
		
		/*
		 * If the lower bound is greater than the higher bound
		 * split the range into two:
		 * [lower, 'Z'] and ['A', upper]
		 */
		if (l > h) {
			return (char) nextInt(l, 'Z', 'A', h);
		}
		
		return (char) nextInt(low, high);
	}
	
	/**
	 * This method chooses a random letter from the
	 * upper case range. (from 'a' to 'z')
	 * 
	 * @return char A lower case letter of the alphabet 
	 */
	public char nextCharLow() {
		return Character.toLowerCase(nextCharCap());
	}
	
	/**
	 * This method generates a random lower case letter between
	 * the desired letter range. If the lower bound is greater
	 * than the upper bound, the range will be between 
	 * [low, 'z'] and ['a', upper]
	 * 
	 * @param low The lower bound char.
	 * @param high The upper bound char.
	 * @return char Lower case letter between low and high.
	 */
	public char nextCharLow(char low, char high) {
		return Character.toLowerCase(nextCharCap(low, high));
	}
	
	/**
	 * Generates a random word of desired length
	 * composed of randomly selected letters
	 * @param length The desired length of the word.
	 * @return String The random word of desired length 
	 */
	public String nextWord(int length) {
		String word = "";
		
		for (int i = 0; i < length; i++) {
			word += nextChar();
		}
		
		return word;
	}
	

	
}
