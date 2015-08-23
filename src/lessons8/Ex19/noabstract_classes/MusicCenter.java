package lessons8.Ex19.noabstract_classes;

import lessons8.Ex19.abstract_classes.Audio;

public class MusicCenter extends Audio {
	private boolean cdWrite;

	public MusicCenter(double power, double massa, boolean isOn, boolean music,
			boolean cdWrite) {
		super(power, massa, isOn, music);
		this.cdWrite = cdWrite;
	}

	public boolean isCdWrite() {
		return cdWrite;
	}

	@Override
	public String toString() {
		return "MusicCenter [cdWrite=" + cdWrite + ", isMusic()=" + isMusic()
				+ ", getPower()=" + getPower() + ", getMassa()=" + getMassa()
				+ ", isOn()=" + isOn() + "]";
	}

	public void listenToMusicForCd() {
		if (cdWrite) {
			System.out.println("Вы слушаете музыку с CD");
		}
		else{
			System.out.println("Вы не можете слушать музыку с СD");
		}
	}

}
