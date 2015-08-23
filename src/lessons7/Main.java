package lessons7;

public class Main {

	public static void main(String[] args) {
//		Time time1 = new Time(39, 21, 4);
//		Time time2 = new Time(32, 42, 7);
//		Time time3 = new Time(21457);
//
//		System.out.println(time1.compareTime(time3));
//
//		System.out.println(time2.getAllSeconds());

		 Bankomat bank = new Bankomat(5690);
		 System.out.println(bank);
		 bank.getMoney(4780);
		 System.out.println(bank);
//		 bank.getMoney(320);
//		 System.out.println(bank);
//		 bank.getMoney(790);
//		 System.out.println(bank);
//		 bank.getMoney(50);
//		 System.out.println(bank);
	}

}
