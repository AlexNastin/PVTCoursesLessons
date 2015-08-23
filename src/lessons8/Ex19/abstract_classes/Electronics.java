package lessons8.Ex19.abstract_classes;

public abstract class Electronics {
	private double power;
	private double massa;
	private boolean isOn;


	abstract public String toString();

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public double getMassa() {
		return massa;
	}

	public void setMassa(double massa) {
		this.massa = massa;
	}

	public Electronics(double power, double massa, boolean isOn) {

		this.power = power;
		this.massa = massa;
		this.isOn = isOn;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public void on() {
		isOn = true;

	}

	public void off() {
		isOn = false;

	}

}
