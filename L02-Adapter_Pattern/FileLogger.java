import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger  implements Logger{
	public void log(String msg) throws IOException
	{
		File logFile = new File("log.txt");
		BufferedWriter writer = null;
			writer = new BufferedWriter(new FileWriter(logFile, true));
			writer.write(msg+"\n");
			writer.close();
	}
}
