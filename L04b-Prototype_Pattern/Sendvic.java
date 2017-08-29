package prototype;

public class Sendvic implements Cloneable {
	
	private String meso;
	private String dodatok;
	private String preliv;
	
	public Sendvic(){
		this.meso = "pleskavica";
		this.dodatok = "pomfrit";
		this.preliv = "bez preliv";
	}

	public String getMeso() {
		return meso;
	}

	public void setMeso(String meso) {
		this.meso = meso;
	}

	public String getDodatok() {
		return dodatok;
	}

	public void setDodatok(String dodatok) {
		this.dodatok = dodatok;
	}

	public String getPreliv() {
		return preliv;
	}

	public void setPreliv(String preliv) {
		this.preliv = preliv;
	}
	
	@Override
	public String toString() {
		
		return "Sendvic: "+meso+","+dodatok+","+preliv+".";
	}
	
	public Object clone(){
		try{
			return super.clone();
		}catch(CloneNotSupportedException e){
			return null;
		}
	}

}
