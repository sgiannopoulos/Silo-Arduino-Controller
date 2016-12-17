import java.io.PrintWriter;

public class DataSend extends Thread {
	public static PrintWriter output;
	public static String string;

	public void run(){
		try{Thread.sleep(100);} catch(Exception e){}
		output = new PrintWriter(SiloGui.chosenPort.getOutputStream());
		while(true){
			output.print(string);
			output.flush();
		}
	}
	
}
