// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(times(3, 4)); // 3 * 4
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		System.out.println(pow(5, 3)); // 5^3
		System.out.println(pow(3, 5)); // 3^5
		System.out.println(div(12, 3)); // 12 / 3
		System.out.println(div(5, 5)); // 5 / 5
		System.out.println(div(25, 7)); // 25 / 7
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		while (x2 < 0) {
			x1--;
			x2++;
		}
		while (x2 > 0) {
			x2--;
			x1++;
		}

		return x1;

	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 > 0) {
			for (int i = 1; i <= x2; i++) {
				x1--;
			}
		} else {
			int add = x2;
			int steps = 0;

			while (add < 0) {
				add++;
				steps++;
			}

			for (int j = 1; j <= steps; j++) {
				x1++;
			}
		}
		return x1;

	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {

		boolean negative = false;
		if (x1 == 0 || x2 == 0) {
			return 0;
		}

		if (x1 < 0) {
			x1 = minus(0, x1);
			negative = !negative;
		}
		if (x2 < 0) {
			x2 = minus(0, x2);
			negative = !negative;
		}
		int num = x1;
		for (int i = 2; i <= x2; i++) {
			num = plus(num, x1);
		}

		if (negative == true) {
			num = minus(0, num);
		}
		return num;

	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int power = x;
		for (int i = 1; i < n; i++) {
			power = times(power, x);
		}
		return power;

	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int num = x2;
		int steps = 1;
		if (x1 == x2) {
			return 1;
		}
		while (num <= x1) {
			num = plus(num, num);
			steps++;
		}
		return steps;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) { // x1=6 x2= 4. %=2
		while (minus(x1, x2) >= 0) {
			x1 = minus(x1, x2);
		}
		return x1;
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		int i = 1;
		while (times(i, i) < x) {
			i++;
		}
		return i;
	}
}