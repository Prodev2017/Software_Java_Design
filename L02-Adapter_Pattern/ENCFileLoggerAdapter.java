import java.io.IOException;

public class ENCFileLoggerAdapter extends LoggerIntr {

	@Override
	public boolean logMessage(String msg) {
		EncFileLogger fileLogger = new EncFileLogger();
		
		try {
			fileLogger.log(msg);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
