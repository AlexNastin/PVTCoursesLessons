package lessons11;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex4 {

	public static void main(String[] args) {

		Locale loc = new Locale("uk", "UA");

		NumberFormat ukrFormat = NumberFormat.getCurrencyInstance(loc);

		System.out.println(ukrFormat.format(153.5));
	}

}
