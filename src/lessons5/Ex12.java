package lessons5;

public class Ex12 {

	public static void main(String[] args) {
		int[] marks = new int[10];
		int i, j, t = 0;
		for (i = 0; i < marks.length; i++) {

			marks[i] = (int) (Math.random() * 10 + 1);

		}
		for (i = 0; i < marks.length; i++) {

			System.out.print(" mas[" + i + "]=" + " " + marks[i]);

		}
		System.out.print("\n");
		for (j = 0; j < marks.length / 2; j++) {

			t = marks[j];
			marks[j] = marks[marks.length - j - 1];
			marks[marks.length - j-1] = t;

		}

		for (i = 0; i < marks.length; i++) {

			System.out.print(" mas[" + i + "]=" + " " + marks[i]);

		}

	}

}
