package lessons2;

public class HelloWord2 {

	public static void main(String[] args) {
		
		double radian = 6.4;
		
		int gradusNewCircle = 0;
		System.out.println("Вы ввели " + radian + " радиан.");
		int secGradusMain = (int) (radian * 206265);

		double gradusOst = (double) secGradusMain / 3600;
		int gradus = secGradusMain / 3600;

		if (gradus > 360) {
			int colCircle = gradus / 360;
			gradusNewCircle = gradus - 360 * colCircle;

		}
		else gradusNewCircle = gradus;
		double minGradusOst = (gradusOst - gradus) * 60;
		int minGradusInt = (int) minGradusOst;

		double secGradusOst = (minGradusOst - minGradusInt) * 60;
		int secGradusInt = (int) secGradusOst;

		System.out.println("Градусы: " + gradusNewCircle + "\nМинуты: "
				+ minGradusInt + "\nСекунды: " + secGradusInt);

	}
}
