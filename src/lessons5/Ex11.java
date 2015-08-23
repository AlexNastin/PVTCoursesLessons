package lessons5;

public class Ex11 {

	public static void main(String[] args) {
		int[] marks = new int[20];
		int i;
		int max = marks[0];
		int nomer = 0;
		for (i = 0; i < marks.length; i++) {

			marks[i] = (int) (Math.random() * 10 + 1);

		}

		for (i = 0; i < marks.length; i++) {
			if (max < marks[i]) {
				max = marks[i];
				nomer = i;
			}
		}
System.out.println("Маx= "+ max+ " Ее номер равен= " + nomer);
	}

}
