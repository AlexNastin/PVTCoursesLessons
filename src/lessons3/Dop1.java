package lessons3;

public class Dop1 {

	public static void main(String[] args) {

		int E = 18, F = 5;
		int a = 7, b = 5;
		int c = 5, d = 2;

		int ac = a + c;
		int bd = b + d;
		int ad = a + d;
		int cb = c + b;
		int minda = d - a;
		int mincb = c - b;
		int ploshadEF = E * F;
		int summaPloshadABCD = (a * b) + (c * d);

		if (minda <= 0) {
			minda = minda * (-1);
		}
		if (mincb <= 0) {
			mincb = mincb * (-1);
		}

		if (ploshadEF <= summaPloshadABCD) {
			System.out.println("���� �������� ������ �����!");
		}
		if (ac <= F && b <= E && d <= E) {
			System.out.println("����� ��������� ���� �� �������� ����� F");
		}

		if (ac <= E && b <= F && d <= F) {
			System.out.println("����� ��������� ���� �� �������� ����� E");
		}
		if (bd <= F && a <= E && c <= E) {
			System.out.println("����� ��������� ���� � ������ ����� F");
		}
		if (bd <= E && a <= F && c <= F) {
			System.out.println("����� ��������� ���� � ������ ����� E");
		}
		if (ad <= E && b <= F && c <= F) {
			System.out
					.println("����� ��������� ��� ab � �����, � ���� ��� cd ������� F");
		}
		if (cb <= E && d <= F && a <= F) {
			System.out
					.println("����� ��������� ��� cd � �����, � ���� ��� ab ������� F");
		}
		if (ac <= F && mincb <= E) {
			System.out
					.println("����� ��������� ��� ab � �����, � ������ ��� cd ������� F");
		}
		if (cb <= F && mincb <= E) {
			System.out
					.println("����� ��������� ��� cd � �����, � ������ ��� ab ������� F");

		}
	}
}
