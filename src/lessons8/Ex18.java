package lessons8;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex18 {

	public static void main(String[] args) {
		int temp = 0;
		ArrayList<Integer> marks = new ArrayList<Integer>();

		int colElem = (int) (Math.random() * 20 + 10);
		for (int i = 0; i < colElem; i++) {
			Integer x = (int) (Math.random() * 10 + 1);
			marks.add(x);
		}
		System.out.println("Marks: " + marks);

		Iterator<Integer> i = marks.iterator();
		while (i.hasNext()) {
			int per = (int) i.next();
			if (per > temp) {
				temp = per;
			}

		}
		System.out.println("Самая большая оценка:" + temp);
	}
}
