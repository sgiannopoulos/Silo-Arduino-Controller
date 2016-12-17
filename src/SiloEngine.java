import javax.swing.SwingUtilities;

public class SiloEngine {
	public static SiloGui silogui;

	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				silogui = new SiloGui(); // Construction of the GUI
				System.out.println("running");

			}

		});

	}
}
