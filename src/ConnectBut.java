import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.fazecast.jSerialComm.SerialPort;

public class ConnectBut extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	public DataSend dataOut;
	public ConnectBut(int width, int height, int x, int y) {
		this.setText("Connect");
		this.setSize(width, height);
		this.setLocation(x, y);
		this.setBackground(Color.LIGHT_GRAY);
		this.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DataListener dataIn = new DataListener();
		DataSend dataOut = new DataSend();
		if (this.getText().equals("Connect")) {

			SiloGui.chosenPort = SerialPort.getCommPort((SiloGui.portList.getSelectedItem().toString()));		// Makes the chosenPort the port we chose from the drop down menu
			SiloGui.chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);							// and sets up the port timeout

			if (SiloGui.chosenPort.openPort()) {	// If we can open the port disable the portList and make the buttons text Disconnect
				this.setText("Disconnect");
				SiloGui.portList.setEnabled(false);
				SiloGui.txtarea.append("Silo Contoller Initiated...\n");	//Message to the GUI that the Port has been successfully opened
			}
//			dataIn.start();		// 	Starting to listen for data
//			dataOut.start();	//	Standing by to send data
			
			SiloGui.txtarea.append(DataListener.dataInput);	//	Logs data input to the JTextArea object of the GUI
		
		} else {		// Returns functionality for the Connect button and the portList object
			SiloGui.chosenPort.closePort();
			SiloGui.portList.setEnabled(true);
			this.setText("Connect");

		}

	}

}
