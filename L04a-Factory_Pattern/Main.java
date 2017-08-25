package factory;

public class Main {
	public static void main(String args[]){
		Klient k1 = new Klient(new LoggerFactory());
		k1.setLogginType("log");
		k1.sendDataToLog("Client 1 message");
		
		Klient k2 = new Klient(new LoggerFactory());
		k2.setLogginType("html");
		k2.sendDataToLog("Client 2 message");
		
		Klient k3 = new Klient(new LoggerFactory());
		k3.setLogginType("enc");
		k3.sendDataToLog("Client 3 message");	
	}
}
