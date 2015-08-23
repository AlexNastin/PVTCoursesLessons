package lessons9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex20 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int n = 0, m = 0, p = 0;
		char c;
		BufferedReader file;

		try {
			file = new BufferedReader(new FileReader("C:/Java/1.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		String tempString = null;
		try {
			tempString = file.readLine();
		} catch (IOException e) {

			e.printStackTrace();
		}
		String[] text;

		while (tempString != null) {
			System.out.println(tempString);

			for (int i = 0; i < tempString.length(); i++) {

				c = tempString.charAt(i);
				if (c != ',' && c != '!' && c != '?' && c != '.' && c != ' ') {
					n++;
					;
				} else if (c == ',' || c == '!' || c == '?' || c == '.') {
					p++;
					n = 0;
				} else if (c == ' ') {
					n = 0;
				}

				if (n == 1) {
					m++;
				}

			}

			try {
				tempString = file.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("");
		System.out.println("Количество слов: " + m);
		System.out.println("Количестов знаков препинания: = " + p);
	}

}
