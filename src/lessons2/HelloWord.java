package lessons2;

public class HelloWord {
	public static void main(String args[]) {
		int s = 37000000;
		int sec = s % 60;
		int m = (s - sec) / 60;
		int min = m % 60;
		int h = (m - min) / 60;
		int hour = h % 24;
		int d = (h - hour) / 24;
		int day = d % 7;
		int week = (d - day) / 7;

		System.out.println("������: " + week + "\n" + "����: " + day + "\n"
				+ "�����: " + hour + "\n" + "�����: " + min + "\n" + "������: "
				+ sec + "\n");
	}
}
