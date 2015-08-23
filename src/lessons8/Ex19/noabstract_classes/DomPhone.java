package lessons8.Ex19.noabstract_classes;

import lessons8.Ex19.abstract_classes.Phones;

public class DomPhone extends Phones {
	private int colNomera;

	public DomPhone(double diagonal, double power, double massa, boolean isOn,
			int colNomera) {
		super(diagonal, power, massa, isOn);
		this.colNomera = colNomera;

	}

	public int getColNomera() {
		return colNomera;
	}

	public void setColNomera(int colNomera) {
		this.colNomera = colNomera;
	}

	@Override
	public String toString() {
		return "DomPhone [colNomera=" + colNomera + ", getDiagonal()="
				+ getDiagonal() + ", getPower()=" + getPower()
				+ ", getMassa()=" + getMassa() + ", isOn()=" + isOn() + "]";
	}
	public void colNomeraPrint(){
		System.out.println("Количество возможных номеров: "+ getColNomera());
	}
	

}
