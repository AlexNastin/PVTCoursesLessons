package lessons6;

public class Ex15 {

	public static void main(String[] args) {
		String sMain = "Мыла ,  такая вот! Я иду гулять. подоконник Ага! Вот, подокАнник так  пАдоконник ВОТ?";
		String sDop = "";
		String sDopMax = "";
		String sDopMax2 = "";
		String dop = "";
		int n = 0, m = 0, maxn = 0,p=0;
		char c;
		for (int i = 0; i < sMain.length(); i++) {

			c = sMain.charAt(i);
			if (c != ',' && c != '!' && c != '?' && c != '.' && c != ' ') {
				sDop += String.valueOf(c);
				n++;
				;
			} else if (c == ',' || c == '!' || c == '?' || c == '.' || c == ' ') {

				sDop = "";
				n = 0;
			}
			if (n == 1) {
				m++;
			}
			if (n >= maxn) {

				sDopMax2 = sDopMax;
				maxn = n;
				sDopMax = sDop;

			}

		}

		System.out.println("Количество слов: " + m);
		System.out.println("Самое большое слово: " + sDopMax + " " + sDopMax2);
		System.out.println("Количестов знаков препинания: = "+p);
	}
}
