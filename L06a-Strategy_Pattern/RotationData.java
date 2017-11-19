package strategy;

public class RotationData implements Data {

	@Override
	public void writeData(int location, int z) {
		System.out.println("Discs spin at "+z+"RPM, data written to location "+location);
	}

}
