package strategy;

public class SSDCach implements Cach {

	@Override
	public void cacheData(int location, byte[] data) {
		System.out.println("Caching not avaliable");	
	}

}
