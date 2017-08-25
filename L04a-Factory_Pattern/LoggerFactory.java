package factory;

public class LoggerFactory {
	public Logger loginType(String type){
		Logger logger = null;
		if(type.equals("log")) logger = new TextFileLogger();
		else if(type.equals("html")) logger = new HTMLFileLogger();
		else if (type.equals("enc")) logger = new EncFileLogger();
		
		return logger;
	}
}
