package strategy;

public class HDD extends ElectronicParts {

		public String type;
		public Data dataType;
		public Cach cacheType;
		public int speed;
		public int location;
		
		public HDD(String type, int speed, int location, Data dataType, Cach cacheType){
			this.type = type;
			this.dataType = dataType;
			this.cacheType = cacheType;
			this.speed = speed;
			this.location = location;
		}
		
		@Override
		public void makeBox() {
			System.out.println("Make "+type+" HDD box.");	
		}
		
		@Override
		public void makeProduct() {
			System.out.println("Making "+type+" HDD");
		}

		@Override
		public boolean productNeedTesting() {
			return true;
		}

		@Override
		public void testProduct() {
			System.out.println("Testing HDD.");
			writeData(location);
			byte[] data = {2,3,2,3};
			cacheData(location, data);
			
		}
		
		public void writeData(int location){
			dataType.writeData(location, speed);
		}
		
		public void cacheData(int location, byte[] data){
			cacheType.cacheData(location, data);
		}

		@Override
		public void tag() {
			System.out.println("Tag: "+type+" HDD, Varanty: 3 years.");
			
		}
}
