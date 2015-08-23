package lessons11;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;

public class Ex5loc {
	public static void main(String[] args) {

		String loc_count = "";
		String loc_lan = "";
		ArrayList<String> listString = new ArrayList<String>();
		for (int i = 0; i < args.length; i++) {
			listString.add(args[i]);
		}
		if (listString.size() < 1 || listString.size() > 2) {
			loc_lan = "";
			loc_count = "";
		} else {
			for (int i = 0; i < 2; i++) {
				loc_lan = listString.get(0);
				loc_count = listString.get(1);
			}
		}
		
		
		Locale loc = new Locale(loc_lan, loc_count);
		ResourceBundle rb = ResourceBundle.getBundle("loc", loc);
		System.out.println(rb.getString("string"));

	}
}
