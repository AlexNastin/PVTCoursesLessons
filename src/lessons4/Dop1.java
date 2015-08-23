package lessons4;

public class Dop1 {
	public static void main(String[] args) {
		int number = 5668676;
		System.out.println(number);
		int n = number;
		int num = number;
		int max = 0, temp = 0;
		int b = 0, h = 0, k = 1, g = 10, m = 0;
		int f = 0, l = 0, o = 1, t = 1;

		while (0 != number)

		{
			number = number / 10;
			b++;
		}
		// 1 часть программы
		while (n > 0) {
			if (n % 10 > max) {
				max = n % 10;
			}

			n = n / 10;

		}
		System.out.println("Max= " + max);
		// 2 часть программы
		for (int i = 1; i <= b; i++) {
			int x = (num / k) % 10;
			// System.out.print(x);
			k = k * 10;
			h = 0;
			// System.out.println(k);

			for (int j = 1; j <= b; j++) {

				if (x == (num / g) % 10) {
					h++;

				}
				g = g * 10;
			}
			g = 10;

			if (h >= m) {
				temp = x;
				m = h;
				System.out.print(" " + temp + " ");
			}

		}
		// 3 часть программы

		// for (int i = 1; i <= b; i++) {
		// int x = (num / o) % 10;
		//
		// o = o * 10;
		// l = 0;
		//
		// for (int j = 1; j <= b; j++) {
		//
		// if (x == (num / t) % 10) {
		// l++;
		// }
		// t = t * 10;
		// }
		// t = 1;
		// }

	}
}
