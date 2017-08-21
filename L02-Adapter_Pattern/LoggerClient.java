public class LoggerClient{

   public static void main(String [] args)
   {
	   LoggerIntr obj1 = new FileLoggerAdapter();
	   obj1.logMessage("Sample message 1");
	   
	   LoggerIntr obj2 = new HTMLFileLoggerAdapter();
	   obj2.logMessage("Sample message 2");
	   
	   LoggerIntr obj3 = new ENCFileLoggerAdapter();
	   obj3.logMessage("Sample message 3");
   }
}
