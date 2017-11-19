package strategy;

public class SSDData implements Data{

	@Override
	public void writeData(int location, int z) {
	 System.out.println("Data pushed to chip "+z+" at location "+location);
		
	}

}
