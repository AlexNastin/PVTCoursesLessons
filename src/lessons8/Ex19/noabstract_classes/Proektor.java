package lessons8.Ex19.noabstract_classes;

import lessons8.Ex19.abstract_classes.Video;

public class Proektor extends Video{
	
	private String naznachenie;

	public Proektor(double power, double massa, boolean isOn, boolean d3,
			String naznachenie) {
		super(power, massa, isOn, d3);
		this.naznachenie = naznachenie;
	}

	public String getNaznachenie() {
		return naznachenie;
	}

	@Override
	public String toString() {
		return "Proektor [naznachenie=" + naznachenie + ", isD3()=" + isD3()
				+ ", getPower()=" + getPower() + ", getMassa()=" + getMassa()
				+ ", isOn()=" + isOn() + "]";
	}

	

}
