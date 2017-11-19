package strategy;

public class RotationCach implements Cach {

	@Override
	public void cacheData(int location, byte[] data) {
		StringBuilder s = new StringBuilder();
		for (byte b : data) {
			s.append(b);
		}
		System.out.println("Data "+s.toString()+" pushed to cache at location "+location);
	}

}
