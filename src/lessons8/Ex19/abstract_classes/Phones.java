package lessons8.Ex19.abstract_classes;

public abstract class Phones extends Electronics {
	private double diagonal;

	public double getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
	}

	public Phones(double diagonal, double power, double massa, boolean isOn) {
		super(power, massa, isOn);
		this.diagonal = diagonal;
	}

	public String call() {
		return "Вы позвонили";
	}

	abstract public String toString();
}
