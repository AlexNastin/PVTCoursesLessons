package lessons3;

public class Dop2 {

	public static void main(String[] args) {

		int a = 9, b = 8, c = 10;
		int d = 8, e = 8, f = 7;

		if (d <= a && e <= b && f <= c) {
			System.out.println("Можно положить коробку плашмя!");
		}
		if (f <= a && e <= b && d <= c) {
			System.out.println("Можно положить коробку лицевой стороной вниз!");
		}
		if (e <= a && f <= b && d <= c) {
			System.out.println("Можно положить коробку боковой стороной!");
		}

	}

}
