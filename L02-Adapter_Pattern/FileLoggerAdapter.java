import java.io.IOException;

public class FileLoggerAdapter extends LoggerIntr {

	public boolean logMessage(String msg) {
		FileLogger fileLogger = new FileLogger();
		
		try {
			fileLogger.log(msg);
			return true;
		} catch (IOException e) {
			return false;
		}
		
	}

}
