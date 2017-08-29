
public class DecoratorMain {

	public static void main(String[] args) {
		
		Logger consoleClient = new ConsoleLogger();
		consoleClient = new HTMLLogger(consoleClient);
		consoleClient = new UpCaseLogger(consoleClient);
		consoleClient = new EncLogger(consoleClient);
		consoleClient.log("Message");
		
		Logger fileClient = new FileLogger();
		fileClient = new HTMLLogger(fileClient);
		fileClient = new UpCaseLogger(fileClient);
		fileClient = new EncLogger(fileClient);
		fileClient.log("File Client 1");
		
	}

}
