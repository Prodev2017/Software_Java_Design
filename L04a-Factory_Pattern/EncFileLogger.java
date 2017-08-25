package factory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class EncFileLogger implements Logger {

	@Override
	public void log(String msg) {
		String message = cesarSypher(msg);

		BufferedWriter writer = null;
		File file = new File("encLog.txt");
		
		try{
			FileWriter fileWriter = new FileWriter(file, true);
			writer = new BufferedWriter(fileWriter);
			writer.write(message+"\n");
			writer.close();
		}
		catch (Exception e){
			System.out.println("Error while writing encrypted data to file.");
		}
		
	}
	
	public String cesarSypher(String msg){
		String cypherMsg = "";
		int offset = 3;
		for(int i=0; i < msg.length(); i++){
			cypherMsg += (char)(msg.charAt(i) + offset);
		}
		return cypherMsg;
	}

}
