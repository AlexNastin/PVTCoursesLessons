package lessons3;

public class Ex6 {

	public static void main(String[] args) {
		int day = 29;
		int month = 4;
		int year = 2014;

		double yearDel4 = year / 4;
		double yearDel400 = year / 400;
		double yearNeDel100 = year;

		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12) {
			day++;
			if (day >= 31) {
				day = 1;
				month++;
				if (month > 12) {
					year++;
					month = 1;
				}
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			day++;
			if (day >= 30) {
				day = 1;
				month++;

			}
		}
		if (yearDel4 == 0 && yearNeDel100 != 0 && yearDel400 == 0) {
			System.out.println("H");
			if (month == 2) {
				System.out.println("G");
				day++;
				if (day >= 29) {
					day = 1;
					month++;

				}

			}
		} else if (month == 2) {
			day++;
			if (day >= 28) {
				day = 1;
				month++;

			}
		}

		System.out.println(day + "." + month + "." + year);
	}

}
