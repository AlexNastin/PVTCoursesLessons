package lessons8;

import java.util.ArrayList;

public class Students {
	// Ex17
	public static void main(String[] args) {

		ArrayList<Integer> marks = new ArrayList<Integer>();

		int colElem = (int) (Math.random() * 20 + 10);
		for (int i = 0; i < colElem; i++) {
			Integer x = (int) (Math.random() * 10 + 1);
			marks.add(x);
		}
		System.out.println("Marks: " + marks);
		for (int i = 0; i < marks.size(); i++) {
			int temp = (int) marks.get(i);
			if (temp < 4) {
				marks.remove(marks.get(i));
				i--;
			}
		}
		System.out.println("Marks: " + marks);
	}
}
