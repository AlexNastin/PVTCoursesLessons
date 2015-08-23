package lessons8.Ex19.noabstract_classes;

import lessons8.Ex19.abstract_classes.Audio;

public class Pleer extends Audio{
	private int ROM;

	public Pleer(double power, double massa, boolean isOn, boolean music,
			int rOM) {
		super(power, massa, isOn, music);
		ROM = rOM;
	}

	public int getROM() {
		return ROM;
	}

	@Override
	public String toString() {
		return "Pleer [ROM=" + ROM + ", isMusic()=" + isMusic()
				+ ", getPower()=" + getPower() + ", getMassa()=" + getMassa()
				+ ", isOn()=" + isOn() + "]";
	}

	

}
