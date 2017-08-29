package prototype;

public class SendvicFactory {
	private Sendvic sendvic;
	
	public SendvicFactory(){
		sendvic = new Sendvic();
	}
	public Sendvic makeSendvic(int i){
		Sendvic cloneSendvic = (Sendvic) sendvic.clone();
		if(i == 198) cloneSendvic.setMeso("stek");
		if(i == 199) cloneSendvic.setDodatok("salata");
		return cloneSendvic;
	}
}
