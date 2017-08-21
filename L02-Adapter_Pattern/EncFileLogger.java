import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EncFileLogger extends FileLogger {

	@Override
	public void log(String msg) throws IOException {
		String newMsg = CessarSypher(msg);
		File logFile = new File("enc_log.txt");
		BufferedWriter writer = null;
			writer = new BufferedWriter(new FileWriter(logFile, true));
			writer.write(newMsg+"\n");
			writer.close();
	}
	
	public String CessarSypher(String msg)
	{
		int ofset = 3;
		String oldMessage = msg.toLowerCase();
		String codeMessage = "";
		for(int index = 0; index < oldMessage.length(); index++)
		{
			int z = (oldMessage.charAt(index) + ofset) % 26;
			codeMessage += z;
		}
		
		return codeMessage;
	}
}
