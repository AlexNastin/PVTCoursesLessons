package lessons8.Ex19.noabstract_classes;

import lessons8.Ex19.abstract_classes.Phones;

public class Mobile extends Phones {
	private String OS;

	public Mobile(double diagonal, double power, double massa, boolean isOn,
			String OS) {
		super(diagonal, power, massa, isOn);
		this.OS = OS;

	}

	@Override
	public String toString() {
		return "Mobile [OS=" + OS + ", getDiagonal()=" + getDiagonal()
				+ ", getPower()=" + getPower() + ", getMassa()=" + getMassa()
				+ "]";
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String oS) {
		OS = oS;
	}

	public String SMS(String SMS) {
		return "Сообщение отпарвленно";
	}

}
