package lessons8.Ex19.abstract_classes;

public abstract class Video extends Electronics {

	private boolean d3;

	public Video(double power, double massa, boolean isOn, boolean d3) {
		super(power, massa, isOn);
		this.d3 = d3;
	}

	public boolean isD3() {
		return d3;
	}

	public void setD3(boolean d3) {
		this.d3 = d3;
	}

	abstract public String toString();

	public void isOn3d() {
		if (d3) {
			System.out.println("3d включенно");
		} else {
			System.out.println("В данном устройстве нет 3d");
		}
	}

	public void isOff3d() {
		if (d3) {
			System.out.println("3d выключенно");
		} else {
			System.out.println("В данном устройстве нет 3d");
		}

	}
}
