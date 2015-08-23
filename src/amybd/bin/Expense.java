package amybd.bin;

public class Expense {
	private int num;
	private String date;
	private int receiver;
	private double value;

	public Expense() {
	}

	public Expense(int num, String date, int receiver, double value) {
		this.num = num;
		this.date = date;
		this.receiver = receiver;
		this.value = value;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Expenses [num=" + num + ", date=" + date + ", receiver="
				+ receiver + ", value=" + value + "]";
	}

}
