package prototype;

import java.util.ArrayList;

public class Naracka {
	private String destinaciska_adresa;
	private ArrayList<Sendvic> Sendvici;
	
	public Naracka(String destinaciska_adresa){
		this.destinaciska_adresa = destinaciska_adresa;
		this.Sendvici = new ArrayList<Sendvic>();
	}
	public void addSendvic(Sendvic o){
		this.Sendvici.add(o);
	}

	public String getDestinaciska_adresa() {
		return destinaciska_adresa;
	}

	public void setDestinaciska_adresa(String destinaciska_adresa) {
		this.destinaciska_adresa = destinaciska_adresa;
	}

	public ArrayList<Sendvic> getSendvici() {
		return Sendvici;
	}

	public void setSendvici(ArrayList<Sendvic> sendvici) {
		Sendvici = sendvici;
	}
	@Override
	public String toString() {
		String s="";
		for (int i =0; i < Sendvici.size();i++) {
			s+="No."+(i+1)+" "+Sendvici.get(i).toString()+"\n";
		}
		return "Order:\n"
				+"Destination address: "+ destinaciska_adresa+"\n"+s;
				
	}
	
}
