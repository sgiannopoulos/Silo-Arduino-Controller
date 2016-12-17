import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class WaterBut extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;

	public WaterBut(int width, int height, int x, int y) {
		this.setText("Water Pump");
		this.setSize(width, height);
		this.setLocation(x, y);
		this.setBackground(Color.CYAN);
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Operations.water();
//		JOptionPane.showMessageDialog(SiloEngine.silogui,"The water pump is online.","Silo Status",JOptionPane.INFORMATION_MESSAGE);
		
	}
}
