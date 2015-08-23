package lessons8.Ex19.abstract_classes;

public abstract class Audio extends Electronics {
	private boolean music;

	public Audio(double power, double massa, boolean isOn, boolean music) {
		super(power, massa, isOn);
		this.music = music;
	}

	public boolean isMusic() {
		return music;
	}

	public void setMusic(boolean music) {
		this.music = music;
	}
	
	public void isOnMusic() {
		if (music == false) {
			System.out.println("������ ���������");
		} else {
			System.out.println("������ ��� ���������");
		}
	}

	public void isOffMusic() {
		if (music == true) {
			System.out.println("������ ����������");
		} else {
			System.out.println("������ ��� ����������");
		}
		
	}
	abstract public String toString();
}
