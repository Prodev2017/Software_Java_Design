package factory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TextFileLogger implements Logger {

	@Override
	public void log(String msg) {
		BufferedWriter writer = null;
		File file = new File("log.txt");
		
		try{
			FileWriter fileWriter = new FileWriter(file, true);
			writer = new BufferedWriter(fileWriter);
			writer.write(msg+"\n");
			writer.close();
		}
		catch (Exception e){
			System.out.println("Error while writing text data to file.");
		}
		
	}

}
