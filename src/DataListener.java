import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DataListener extends Thread {
	public static String dataInput;
	@Override
	public void run() {
		Scanner scanner = new Scanner(SiloGui.chosenPort.getInputStream());
		while (scanner.hasNextLine()) {
			try {
				dataInput = scanner.nextLine();
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		scanner.close();
		SiloGui.txtarea.append("Silo Contoller stopped.\n");

	}

}
