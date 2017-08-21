import java.io.IOException;

public class HTMLFileLoggerAdapter extends LoggerIntr {

	@Override
	public boolean logMessage(String msg) {
		HTMLFileLogger fileLogger = new HTMLFileLogger();
		
		try {
			fileLogger.log(msg);
			return true;
		} catch (IOException e) {
			return false;
		}
		
	}	

}
