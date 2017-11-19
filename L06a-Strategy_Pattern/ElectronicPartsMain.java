package strategy;

public class ElectronicPartsMain {
	public static void main(String[] args){
		System.out.println("----------Rottation HDD----------");
		HDD hdd = new HDD("Rotation", 5400, 2345399, new RotationData(), new RotationCach());
		hdd.production();
		System.out.println("---------------------------------");
		
		System.out.println("-------------SSD HDD-------------");
		HDD ssd = new HDD("SSD", 3, 2343443, new SSDData(), new SSDCach());
		ssd.production();
		System.out.println("---------------------------------");
	}
}
