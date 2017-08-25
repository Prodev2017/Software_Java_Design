package factory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class HTMLFileLogger implements Logger {

	@Override
	public void log(String msg) {
		String htmlMsg = "<p>"+msg+"</p>";
		
		BufferedWriter writer = null;
		File file = new File("htmlLog.html");
		
		
		try{
			FileWriter fileWriter = new FileWriter(file, true);
			writer = new BufferedWriter(fileWriter);
			writer.write(htmlMsg+"\n");
			writer.close();
		}
		catch (Exception e){
			System.out.println("Error while writing HTML data to file.");
		}
		
	}

}
