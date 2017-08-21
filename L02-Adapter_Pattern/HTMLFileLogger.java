import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLFileLogger extends FileLogger {

	@Override
	public void log(String msg) throws IOException {
		File logFile = new File("html_log.html");
		BufferedWriter writer = null;
			writer = new BufferedWriter(new FileWriter(logFile, true));
			writer.write("<p>"+msg+"</p>");
			writer.close();
	}
}
