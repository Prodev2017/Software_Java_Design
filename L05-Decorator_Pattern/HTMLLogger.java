
public class HTMLLogger extends LoggerDecorators {
		Logger logger;
		
		public HTMLLogger(Logger logger){
			this.logger = logger;
		}
		
		@Override
		public void log(String msg) {
				String htmlMsg = "<p>"+msg+"</p>";
				logger.log(htmlMsg);
		}
}
