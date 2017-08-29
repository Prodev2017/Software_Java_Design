
public class EncLogger extends LoggerDecorators {
	Logger logger;
	
	public EncLogger(Logger logger){
		this.logger = logger;
	}
	
	@Override
	public void log(String msg) {
		String encString = enc(msg);
		logger.log(encString);
	}
	
	public String enc(String msg){
		String encString = "";
		for (char c : msg.toCharArray()) {
			encString += (char)(c + 3);
		}
		return encString;
	}
}
