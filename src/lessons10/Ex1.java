package lessons10;

public class Ex1 {

	public static void main(String[] args) {

		String string = "";
		StringBuffer stringBuffer = new StringBuffer();
		StringBuilder stringBuilder = new StringBuilder();
		
		long time1 = System.currentTimeMillis();
		
		for (int i = 0; i < 30000; i++) {
			int str1 = (int) (Math.random() * 10 + 1);
			string += str1;

		}
		
		long time2 = System.currentTimeMillis();
		long timeString = time2 - time1;
		System.out.println(timeString);
		
		long time3 = System.currentTimeMillis();
		for (int i = 0; i < 300000; i++) {
			int str1 = (int) (Math.random() * 10 + 1);
			stringBuffer.append(str1);

		}
		
		long time4 = System.currentTimeMillis();
		long timeStringBuffer = time4 - time3;
		System.out.println(timeStringBuffer);

		long time5 = System.currentTimeMillis();
		for (int i = 0; i < 300000; i++) {
			int str1 = (int) (Math.random() * 10 + 1);
			stringBuilder.append(str1);

		}
		
		long time6 = System.currentTimeMillis();
		long timeStringBulder = time6 - time5;
		System.out.println(timeStringBulder);
	
	
	}

}
