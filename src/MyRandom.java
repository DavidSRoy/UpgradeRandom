import java.util.ArrayList;

/**
 * This program tests the new methods of the NewRandom 
 * class. A test method has been created for each
 * method. The test method will run the NewRandom
 * method 30 times and return a percentage of 
 * passed tests. The test data will be printed
 *  Finally, the program will present the test results. 
 *  
 * @author David Roy
 * Email: david.roy@bellevuecollege.edu
 * Student ID: 950694703
 * 4/19/19
 */
public class MyRandom {
	private static NewRandom rand;
	
	public static void main(String[] args) {
		rand = new NewRandom();
		
		//testing doubles represent percent 
		double nextInt = 0.0;
		double nextIntSplitRange = 0;
		double nextEven = 0;
		double nextOdd = 0;
		double nextCharCap = 0;
		double nextCharLow = 0;
		double nextCharCapBounds = 0;
		double nextCharLowBounds = 0;
		double nextCharCapBoundsInverse = 0;
		double nextCharLowBoundsInverse = 0;
		double nextWord = 0;
		double nextChar = 0;
		
		
		/*
		 * Test all new NewRandom methods
		 * Each method is run 30 times. The
		 * results are compared to conditions
		 * to make sure they are correct. A
		 * percentage of passed tests is returned.
		 */
		nextInt = testNextInt(5, 20);
		nextIntSplitRange = testNextIntSplitRange(5, 21, 50, 100);
		nextEven = testNextEven(5, 20);
		nextOdd = testNextOdd(5, 20);
		nextCharCap = testNextCharCap();
		nextCharLow = testNextCharLow();
		

		nextCharCapBounds = testNextCharCap('B', 'G');
		nextCharLowBounds = testNextCharLow('B', 'G');
		
		nextCharCapBoundsInverse = testNextCharCapInverseRange('Q', 'E');
		nextCharLowBoundsInverse = testNextCharLowInverseRange('q', 'e');
		
		nextWord = testNextWord();
		nextChar = testNextChar();
		System.out.println("");
		
		//print test results
		System.out.println("Test Results:");
		System.out.println("nextInt: " + nextInt * 100 + "%");
		System.out.println("nextIntSplitRange: " + nextIntSplitRange * 100 + "%");
		System.out.println("nextEven: " + nextEven * 100 + "%");
		System.out.println("nextOdd: " + nextOdd * 100 + "%");
		System.out.println("nextCharCap: " + nextCharCap * 100 + "%");
		System.out.println("nextCharLow: " + nextCharLow * 100 + "%");
		System.out.println("nextCharCapBounds: " + nextCharCapBounds * 100 + "%");
		System.out.println("nextCharLowBounds: " + nextCharLowBounds * 100 + "%");
		System.out.println("nextCharCapBoundsInverse: " + nextCharCapBoundsInverse * 100 + "%");
		System.out.println("nextCharLowBoundsInverse: " + nextCharLowBoundsInverse * 100 + "%");
		System.out.println("nextWord: " + nextWord * 100 + "%");
		System.out.println("nextChar: " + nextChar * 100 + "%");
		System.out.println();
		
		double total = nextInt + nextIntSplitRange + nextEven + nextOdd + nextCharCap + nextCharLow
				+ nextCharCapBounds + nextCharLowBounds + nextCharCapBoundsInverse + 
				nextCharLowBoundsInverse + nextWord + nextChar;
		System.out.println("TOTAL: " + total / 12.0 * 100 + "% of all tests passed" );
	}

	
	public static double testNextInt(int low, int high) {
		int passed = 0;
		int total = 0;
		System.out.println("Testing nextInt(" + low + ", " + high + ")");
		for (int i = 0; i < 30; i++) {
			int num = rand.nextInt(low, high);
			System.out.println(num);
			//check that num is in between low and high
			if (num >= low && num <= high) {
				passed++;
			}
			total++;
		}
		System.out.println("");
		return (double) passed / total;
	}
	
	public static double testNextIntSplitRange(int low, int a, int b, int high) {
		int passed = 0;
		int total = 0;
		System.out.println("Testing nextIntSplitRange(" + low + ", " + a + ", " + b + ", " + high + ")");
		for (int i = 0; i < 30; i++) {
			int num = rand.nextInt(low, a, b, high);
			System.out.println(num);
			//check that num is in between low and high
			if ((num >= low && num <= a) || (num >= b && num <= high)) {
				passed++;
			}
			total++;
		}
		System.out.println("");
		return (double) passed / total;
	}

	public static double testNextEven(int low, int high) {
		int passed = 0;
		int total = 0;
		System.out.println("Testing nextEven(" + low + ", " + high + ")");
		for (int i = 0; i < 30; i++) {
			int num = rand.nextEven(low, high);
			System.out.println(num);
			if (num % 2 == 0) {
				passed++;
			}
			total++;
		}
		System.out.println("");
		return (double) passed / total;
	}
	
	public static double testNextOdd(int low, int high) {
		int passed = 0;
		int total = 0;
		System.out.println("Testing nextOdd(" + low + ", " + high + ")");
		for (int i = 0; i < 30; i++) {
			int num = rand.nextOdd(low, high);
			System.out.println(num);
			if (num % 2 != 0) {
				passed++;
			}
			
			total++;
		}
		System.out.println("");
		return (double) passed / total;
	}
	
	public static double testNextCharCap() {
		int passed = 0;
		int total = 0;
		System.out.println("Testing nextCharCap()");
		for (int i = 0; i < 30; i++) {
			char ch = rand.nextCharCap();
			System.out.println(ch);
			if (Character.isAlphabetic(ch) && Character.isUpperCase(ch)) {
				passed++;
			}
			
			total++;
		}
		System.out.println("");
		return (double) passed / total;
	}
	
	public static double testNextCharLow() {
		int passed = 0;
		int total = 0;
		System.out.println("Testing nextCharLow()");
		for (int i = 0; i < 30; i++) {
			char ch = rand.nextCharLow();
			System.out.println(ch);
			if (Character.isAlphabetic(ch) && Character.isLowerCase(ch)) {
				passed++;
			}
			
			total++;
		}
		System.out.println("");
		return (double) passed / total;
	}
	
	public static double testNextCharCap(char low, char high) {
		int passed = 0;
		int total = 0;
		System.out.println("Testing nextCharCap( " + low + ", " + high + ")");
		for (int i = 0; i < 30; i++) {
			char ch = rand.nextCharCap(low, high);
			System.out.println(ch);
			if (Character.isAlphabetic(ch) && Character.isUpperCase(ch)
					&& (ch >= 'A' && ch <= 'Z')) {
				passed++;
			}
			
			total++;
		}
		System.out.println("");
		return (double) passed / total;
	}
	
	public static double testNextCharLow(char low, char high) {
		int passed = 0;
		int total = 0;
		System.out.println("Testing nextCharCap( " + low + ", " + high + ")");
		for (int i = 0; i < 30; i++) {
			char ch = rand.nextCharLow(low, high);
			System.out.println(ch);
			if (Character.isAlphabetic(ch) && Character.isLowerCase(ch)
					&& (ch >= 'a' && ch <= 'z')) {
				passed++;
			}
			
			total++;
		}
		System.out.println("");
		return (double) passed / total;
	}
	
	/**
	 * This method tests the "slide effect"
	 * If the range is ['Y', 'B']
	 * results could be Y, Z, A, or B
	 * 
	 * @param low Lower bound
	 * @param high Upper bound
	 * @return double Percent tests passed
	 */
	public static double testNextCharCapInverseRange(char low, char high) {
		int passed = 0;
		int total = 0;
		System.out.println("Testing nextCharCap( " + low + ", " + high + ") (inverse range)");
		for (int i = 0; i < 30; i++) {
			char ch = rand.nextCharCap(low, high);
			System.out.println(ch);
			if (Character.isAlphabetic(ch) && Character.isUpperCase(ch)
					&& ((ch >= low && ch <= 'Z') || ((ch >= 'A' && ch <= high)))) {
				passed++;
			}
			
			total++;
		}
		System.out.println("");
		return (double) passed / total;
	}
	
	
	public static double testNextCharLowInverseRange(char low, char high) {
		int passed = 0;
		int total = 0;
		System.out.println("Testing nextCharLow( " + low + ", " + high + ") (inverse range)");
		for (int i = 0; i < 30; i++) {
			char ch = rand.nextCharLow(low, high);
			System.out.println(ch);
			if (Character.isAlphabetic(ch) && Character.isLowerCase(ch)
					&& ((ch >= low && ch <= 'z') || ((ch >= 'a' && ch <= high)))) {
				passed++;
			}
			
			total++;
		}
		System.out.println("");
		return (double) passed / total;
	}
	
	public static double testNextWord() {
		int passed = 0;
		int total = 0;
		System.out.println("Testing nextNextWord("+ "random length" + ")");
		for (int i = 0; i < 30; i++) {
			int length = rand.nextInt(10);
			String s = rand.nextWord(length);
			System.out.println(s);
			if (s.length() == length) {
				passed++;
			}
			
			total++;
		}
		System.out.println("");
		return (double) passed / total;
	}
	
	public static double testNextChar() {
		int passed = 0;
		int total = 0;
		System.out.println("Testing nextChar()");
		for (int i = 0; i < 30; i++) {
			char ch = rand.nextChar();
			System.out.println(ch);
			if (Character.isAlphabetic(ch)) {
				passed++;
			}
			
			total++;
		}
		System.out.println("");
		return (double) passed / total;
	}
	
	
}
