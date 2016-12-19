import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import com.fazecast.jSerialComm.SerialPort;

public class SiloGui extends JFrame {

	private static final long serialVersionUID = 1L;

	public JScrollPane scrollPane;
	public static JTextArea txtarea;
	public static JComboBox<String> portList;
	public static SerialPort chosenPort;

	public SiloGui() {

		// JFrame setup
		super("Silo Controller");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 150);
		setResizable(true);

		// Control Buttons Setup
		HeatBut heat = new HeatBut(125, 40, 350, 50);
		WaterBut water = new WaterBut(125, 40, 350, 100);
		MixerBut mixer = new MixerBut(125, 40, 350, 150);
		add(mixer);
		add(heat);
		add(water);

		// JTextArea Setup
		txtarea = new JTextArea();
		txtarea.setEditable(false);
		txtarea.setName("mytxtarea");

		DefaultCaret caret = (DefaultCaret)txtarea.getCaret();	// This code is needed in order to automatically scroll down
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);		// our log when new information is added
		
		// JScrollPane Setup
		JScrollPane scrollPane = new JScrollPane(txtarea);
		scrollPane.setName("spn");
		scrollPane.setSize(300, 150);
		scrollPane.setLocation(20, 50);	
		add(scrollPane);
		
		// Connect Button and ComboBox
		ConnectBut connectButton = new ConnectBut(120, 20, 110, 5);	
		add(connectButton);		
		
		portList = new JComboBox<String>();		
		SerialPort[] portNames = SerialPort.getCommPorts();	// This Array is used to list the ports in our system
		for(int i = 0; i< portNames.length; i++){
			portList.addItem(portNames[i].getSystemPortName());	// The System ports are added to the portList object so that we can choose
		}
		portList.setBounds(20, 5, 70, 20);
		add(portList);
		
		Thread t = new Thread(){		//	Disables buttons before connecting to the port
			@Override
			public void run(){
				while(true){
					if(connectButton.getText().equals("Connect")){
						try{Thread.sleep(1);} catch(Exception e){};	
						heat.setEnabled(false);
						water.setEnabled(false);
						mixer.setEnabled(false);
					}else {
						try{Thread.sleep(1);} catch(Exception e){};	
						heat.setEnabled(true);
						water.setEnabled(true);
						mixer.setEnabled(true);
					}
				}
			}
		};
		t.start();
		
	}

}
