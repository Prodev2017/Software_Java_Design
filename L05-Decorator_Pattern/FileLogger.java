import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class FileLogger implements Logger{

	@Override
	public void log(String msg) {
		try{
			File file = new File("info.log");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(msg+"\n");
			writer.close();
		}
		catch(Exception e){
			System.out.println("There were problems while writting into info.log");
		}
		
	}

}
