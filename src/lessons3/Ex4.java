package lessons3;

public class Ex4 {

	public static void main(String[] args) {
		int a = 15;
		int b = 6;
		int R = 8;

		int x = 0;
		if (x >= ((a * a) + (b * b)) / (4 * (R * R))) {
			System.out
					.println("Окружностью можно покрыть прямоугольное отверстие");
		} else
			System.out
					.println("Окружностью нельзя покрыть прямоугольное отверстие");
	}

}
