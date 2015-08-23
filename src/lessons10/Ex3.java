package lessons10;

public class Ex3 {

	public static void main(String[] args) {
		String stringMain = "<p id=\"cel\" id=\"cel\">  Main Troroorlo!  <p id=\"centre\"> Trololo <p>";
		System.out.println(stringMain.replaceAll("<p[^>]+>", "<p>"));

		
	}

}
