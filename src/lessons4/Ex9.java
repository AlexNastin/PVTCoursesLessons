package lessons4;

public class Ex9 {

	public static void main(String[] args) {
		int x = 37;

		int c = 0;

		for (int i = 2; i <= x / 2; i++) {

			if (x % i == 0) {
				c = 1;

			}

		}
		if (c == 1) {
			System.out.println("Число не простое!");
		} else {
			System.out.println("Число простое!");
		}
	}
}
