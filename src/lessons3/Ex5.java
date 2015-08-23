package lessons3;

public class Ex5 {
	public static void main(String[] args) {
		int money = 11101;

		int n = money / 10;
		int m = money / 100;

		if (money >= (100 * m) + 5 && money <= (100 * m) + 14) {
			System.out.println("У вас " + money + " рублей");
		}

		else if (money == (10 * n) + 1) {
			System.out.println("У вас " + money + " рубль");
		} else if (money == (10 * n) + 2 || money == (10 * n) + 3
				|| money == (10 * n) + 4) {
			System.out.println("У вас " + money + " рубля");
		} else {
			System.out.println("У вас " + money + " рублей");
		}
	}
}
