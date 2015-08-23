package lessons4;

public class Ex7 {

	public static void main(String[] args) {

		int p = 1;
		int i = 1;

		while (i <= 20) {
			p = p * i;
			i++;
		}
		System.out.println("Факториал равен= " + p);
	}

}
