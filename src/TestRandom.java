import java.util.ArrayList;

/**
 * Add comments
 * @author David Roy
 *
 */
public class TestRandom {
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
		double nextWord = 0;
		double nextChar = 0;
		
		
		/*
		 * Test all new NewRandom methods
		 */
		nextInt = testNextInt(5, 20);
		nextIntSplitRange = testNextIntSplitRange(5, 21, 50, 100);
		nextEven = testNextEven(5, 20);
		nextOdd = testNextOdd(5, 20);
		nextCharCap = testNextCharCap();
		nextCharLow = testNextCharLow();
		
		//hand check for "slide effect"
		//['Y', 'B'] will produce Y, Z, A, B
		nextCharCapBounds = testNextCharCap('B', 'G');
		nextCharLowBounds = testNextCharLow('B', 'G');
		
		nextWord = testNextWord();
		nextChar = testNextChar();
		System.out.println("");
		
		
		
		System.out.println("Test Results:");
		System.out.println("nextInt: " + nextInt * 100 + "%");
		System.out.println("nextIntSplitRange: " + nextIntSplitRange * 100 + "%");
		System.out.println("nextEven: " + nextEven * 100 + "%");
		System.out.println("nextOdd: " + nextOdd * 100 + "%");
		System.out.println("nextCharCap: " + nextCharCap * 100 + "%");
		System.out.println("nextCharLow: " + nextCharLow * 100 + "%");
		System.out.println("nextCharCapBounds: " + nextCharCapBounds * 100 + "%");
		System.out.println("nextCharLowBounds: " + nextCharLowBounds * 100 + "%");
		System.out.println("nextWord: " + nextWord * 100 + "%");
		System.out.println("nextChar: " + nextChar * 100 + "%");
	}
	
	/*
	 * Test methods return percentage of tests passed 
	 */
	
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
