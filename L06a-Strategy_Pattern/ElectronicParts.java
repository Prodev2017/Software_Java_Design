package strategy;

public abstract class ElectronicParts {
	
	public final void production()  {
		makeBox();
		makeProduct();
		if(productNeedTesting()) testProduct();
		boxing();
		tag();
	}
	
	public abstract void makeBox();
	
	public abstract void makeProduct();
	
	public abstract boolean productNeedTesting();
	
	public abstract void testProduct();
	
	public void boxing(){
		System.out.println("Boxing.");
	}
	
	public abstract void tag();
}
