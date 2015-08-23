package lessons10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2 {

	public static void main(String[] args) {
		String string = "0,04BC Hello Word alala 0x1AF1 alalal  122F O13 lalal 45";
		String temp;

		Pattern p = Pattern.compile("-?0[xX][0-9a-fA-F]+");
		Matcher m = p.matcher(string);
		while (m.find()) {

			temp = string.substring(m.start(), m.end());
			System.out.print(temp + " ");
		}

	}

}
