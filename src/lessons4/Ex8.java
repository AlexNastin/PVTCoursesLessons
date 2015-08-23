package lessons4;

public class Ex8 {

	public static void main(String[] args) {

		int n = 0;
		int x = (int) (Math.random() * 100);
		int i = 1;
		while (i <= 10) {
			if (x > n) {
				n = x;
			}
			x = (int) (Math.random() * 100);
			i++;
		}
		System.out.println("Max= " + n);
	}

}
