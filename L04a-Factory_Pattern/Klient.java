package factory;

public class Klient {
	private LoggerFactory factory;
	private Logger logger;
	
	public Klient(LoggerFactory factory){
		this.factory = factory;
	}
	
	public void setLogginType(String type){
		logger = factory.loginType(type);
	}
	
	
	public void sendDataToLog(String msg){
		logger.log(msg);
	}
}
