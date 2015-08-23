package lessons3;

public class Ex3 {

	public static void main(String[] args) {
		int number = 47;

		int n = number / 10;
		

		if (number == ((10 * n) + 7)) {
			System.out.println("Последняя цифра 7");
		} else
			System.out.println("Последняя цифра не 7");
	}

}
