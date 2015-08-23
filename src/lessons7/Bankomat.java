package lessons7;

public class Bankomat {

	private int TotalAmount;
	private int k100;
	private int k50;
	private int k20;

	public Bankomat(int TotalAmount) {

		int k100_1 = TotalAmount / 100;// сколько всего может быть 100
		int k100_2 = TotalAmount % 100;// остаток от деления на 100
		int k100_3 = k100_1 - (k100_1 / 3);// реальное количество 100
		this.k100 = k100_3;

		int dop = k100_1 - k100_3;// сколкьо осталось 100 для перобразования
		int k50_1 = k100_2 / 50; // сколько всего 50
		int k50_2 = k100_2 % 50;// осаток от делелня на 50
		int k50_3 = ((dop / 2) * 2) + k50_1; // реальное количество 50
		this.k50 = k50_3;

		int dop2 = dop - (dop / 2); // сколкьо осталось 100 для перобразования
									// после распределения 50
		int k20_1 = k50_2 / 20;// сколько всего 20
		int k20_2 = k50_2 % 20;// остаток от деления на 20
		int k20_3 = (dop2 * 5) + k20_1; // реальное количество 20
		this.k20 = k20_3;
		if (k20_2 != 0) {
			System.out
					.println("Данный остаток от суммы не может быть введен в аппарат: "
							+ k20_2 + " руб.");
		}
		int resTotalAmount = TotalAmount - k20_2;
		this.TotalAmount = resTotalAmount;// итоговая общая сумма

	}

	public Bankomat(int k20, int k50, int k100) {
		this.k20 = k20;
		this.k50 = k50;
		this.k100 = k100;
		int TotalAmount = (k20 * 20) + (k50 * 50) + (k100 * 100);
		this.TotalAmount = TotalAmount;

	}

	public String getKupurs() {
		return "k100=" + k100 + ", k50=" + k50 + ", k20=" + k20;
	}

	public void getMoney(int money) {

		if (money > getTotalAmount()) {
			System.out
					.println("Данная сумма превышает общую сумму банкомата! Введите другую сумму!");
			return;
		}

		int ost = money % 100;

		int k20_0 = 0, k50_0 = 0;

		if (ost == 20) {
			k20_0++;
		} else if (ost == 40) {
			k20_0 = +2;
		} else if (ost == 50) {
			k50_0++;
		} else if (ost == 60) {
			k20_0 = +3;
		} else if (ost == 70) {
			k20_0++;
			k50_0++;
		} else if (ost == 90) {
			k50_0++;
			k20_0 = +2;
		} else if (ost == 0) {
		} else if (ost == 80) {
			k20_0 = +4;
		}
		else{
			System.out.println("Данная сумма не может быть выданна " + ost
					+ " руб. ВВедите другую сумму");
			return;
		}
		if (k20_0 > getK20() && k50_0 > getK50()) {
			System.out.println("Не хватает купюр! ");
		}

		int mon = money - ost;// деньги полсе вычета последних цифр(мелочи)
		// логика под сомнением
		int k100_1 = mon / 100;// сколько всего может быть 100
		int k100_3 = k100_1 - (k100_1 / 3);// реальное количество 100

		if (k100_3 > getK100()) {
			while (k100_3 > getK100()) {
				k100_3--;
				k50_0 = +2;
			}

		}

		int dop = k100_1 - k100_3;// сколкьо осталось 100 для перобразования
		double dop_1 = k100_1 - k100_3;
		int k50_1 = (((dop / 2) * 2) + k50_0); // реальное количество 50

		if (k50_1 > getK50()) {
			while (k50_1 > getK50()) {
				k20_0 = +5;
				k50_1 = -2;
			}
		}
		double dop2_1 = (dop_1 / 2);
		int dop2 = (int) (dop - dop2_1); // сколкьо осталось 100 для
											// преобразования после 50

		int k20_1 = (dop2 * 5) + k20_0; // реальное количество 20

		if (k20_1 > getK20()) {

			while (k20_1 > getK20()) {
				k20_1 = -5;
			}
		}

		// вот до сюда
//		System.out.println(k100_3 + " " + k50_1 + " " + k20_1);
		int k100 = getK100() - k100_3;
		int k50 = getK50() - k50_1;
		int k20 = getK20() - k20_1;

		int temp = (k100_3 * 100) + (k50_1 * 50) + (k20_1 * 20);
		int resultBankomatMoney = getTotalAmount() - temp;
		this.TotalAmount = resultBankomatMoney;

		this.k100 = k100;
		this.k50 = k50;
		this.k20 = k20;

	}

	public int getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		TotalAmount = totalAmount;
	}

	public int getK100() {
		return k100;
	}

	public void setK100(int k100) {
		this.k100 = k100;
	}

	public int getK50() {
		return k50;
	}

	public void setK50(int k50) {
		this.k50 = k50;
	}

	public int getK20() {
		return k20;
	}

	public void setK20(int k20) {
		this.k20 = k20;
	}

	public String toString() {
		return "Bankomat [TotalAmount=" + TotalAmount + ", k100=" + k100
				+ ", k50=" + k50 + ", k20=" + k20 + "]";
	}

}
