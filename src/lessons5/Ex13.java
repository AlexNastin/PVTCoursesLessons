package lessons5;

public class Ex13 {

	public static void main(String[] args) {

		int[][] marks = new int[8][8];

		for (int i = 0; i < marks.length; i++) {
			for (int j = 0; j < marks[i].length; j++)
				marks[i][j] = 0;
		}

		for (int i = 0; i < marks.length; i++) {
			for (int j = i; j < marks[i].length - i; j++) {
				marks[i][j] = 1;
				marks[marks.length - i - 1][marks[i].length - j - 1] = 1;
			}

		}


		// for (int i = 0; i < marks.length; i++) {
		// if (i < marks[i].length - i) {
		// for (int j = i; j < marks[i].length - i; j++) {
		// marks[i][j] = 1;
		// }
		// } else
		// for (int j = marks[i].length - 1 - i; j <= i; j++) {
		// marks[i][j] = 1;
		// }
		//
		// }
		for (int i = 0; i < marks.length; i++) {
			for (int j = 0; j < marks[i].length; j++) {

				System.out.print(marks[i][j] + " ");

			}
			System.out.println(" ");

		}

	}
}
