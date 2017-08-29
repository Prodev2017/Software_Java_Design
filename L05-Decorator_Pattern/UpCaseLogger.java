
public class UpCaseLogger extends LoggerDecorators {
	Logger logger;
	
	public UpCaseLogger(Logger logger){
		this.logger = logger;
	}
	
	@Override
	public void log(String msg) {
		String upCaseMsg = msg.toUpperCase();
		logger.log(upCaseMsg);
	}
}
