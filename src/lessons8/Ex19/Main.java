package lessons8.Ex19;

import java.util.ArrayList;
import java.util.Iterator;

import lessons8.Ex19.abstract_classes.Electronics;
import lessons8.Ex19.noabstract_classes.DomPhone;
import lessons8.Ex19.noabstract_classes.Mobile;
import lessons8.Ex19.noabstract_classes.MusicCenter;
import lessons8.Ex19.noabstract_classes.Pleer;
import lessons8.Ex19.noabstract_classes.Proektor;
import lessons8.Ex19.noabstract_classes.TV;

public class Main {

	public static void main(String[] args) {

		double summaPower = 0;

		Electronics tv = new TV(1, 100, true, true, true);// 1//true
		Electronics proector = new Proektor(2, 200, false, true, "Home");// 2//false
		Electronics mobile = new Mobile(5.6, 3, 300, true, "Android");// 3//true
		Electronics homephone = new DomPhone(4.1, 4, 400, true, 200);// 4//true
		Electronics museiccentre = new MusicCenter(5, 500, true, true, true);// 5//true
		Electronics pleer = new Pleer(6, 600, true, false, 32);// 6//true
		Electronics pleer1 = new Pleer(10, 600, true, false, 32);// 7//true

		pleer1.off();

		ArrayList<Electronics> mass = new ArrayList<Electronics>();

		Iterator<Electronics> i = mass.iterator();

		mass.add(tv);
		mass.add(proector);
		mass.add(mobile);
		mass.add(homephone);
		mass.add(museiccentre);
		mass.add(pleer);
		mass.add(pleer1);

		for (int j = 0; j < mass.size(); j++) {

			if (mass.get(j).isOn()) {
				double temp = (double) mass.get(j).getPower();
				summaPower += temp;
			}

		}

//		while (i.hasNext()) {
//			boolean per = i.next().isOn();
//			if (per == true) {
//				summaPower = summaPower + i.next().getPower();
//			}
//		}

		System.out.println("Îבשאÿ ןמענובכÿילאÿ למשםמסעü: " + summaPower);
	}
}
