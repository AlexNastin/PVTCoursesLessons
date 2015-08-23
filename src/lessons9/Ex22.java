package lessons9;

import java.io.File;
import java.util.ArrayList;

public class Ex22 {

	public static void main(String[] args) {

		File[] path = new File("C:/Java/ZDirectory").listFiles();
		ArrayList<File> list = new ArrayList<File>();

		for (int i = 0; i < path.length; i++) {
			list.add(path[i]);

		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isDirectory()) {
				path = list.get(i).listFiles();
				for (int j = 0; j < path.length; j++) {
					list.add(path[j]);
				}
			}

		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getParent());
			System.out.println(list.get(i).getName());
		}

	}

}
