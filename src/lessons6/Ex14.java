package lessons6;

public class Ex14 {

	public static void main(String[] args) {
		String sMain = "Еда, вот так вот! Я иду гуялть. Ага! Вот, так ВОТ?";
		int n = 0;
		char c;
		for (int i = 0; i < sMain.length(); i++) {
			c = sMain.charAt(i);
			if (c == ',' || c == '!' || c == '?' || c == '.') {
				n++;
			}

		}
		System.out.println("Количество знакоков препинания: " + n);
	}

}
