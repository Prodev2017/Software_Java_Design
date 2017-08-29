package prototype;

public class Manager {
	public static void main (String []args){
		SendvicFactory sendvicFactory = new SendvicFactory();
		Naracka naracka = new Naracka("Ulica bb");
		
		for(int i=1; i <= 200; i++){
			naracka.addSendvic(sendvicFactory.makeSendvic(i));
		}
		
		System.out.println(naracka);
	}
}
