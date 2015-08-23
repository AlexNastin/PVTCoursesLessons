package lessons8.Ex19.noabstract_classes;

import lessons8.Ex19.abstract_classes.Video;

public class TV extends Video {
	private boolean usb;

	public TV(double power, double massa, boolean isOn, boolean d3, boolean usb) {
		super(power, massa, isOn, d3);
		this.usb = usb;
	}

	public boolean isUsb() {
		return usb;
	}

	@Override
	public String toString() {
		return "TV [usb=" + usb + ", isD3()=" + isD3() + ", getPower()="
				+ getPower() + ", getMassa()=" + getMassa() + ", isOn()="
				+ isOn() + "]";
	}

	public void provUsb() {
		if (usb) {
			System.out.println("USB есть");
		} else {
			System.out.println("USB отсутствует.");
		}
	}

}
