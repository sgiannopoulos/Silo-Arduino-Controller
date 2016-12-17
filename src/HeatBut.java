import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class HeatBut extends JButton implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HeatBut(int width, int height, int x, int y) {
		this.setText("Heat Silo");
		this.setSize(width, height);
		this.setLocation(x, y);
		this.setBackground(new Color(174,50,50));
		this.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		Operations.heat();
//		JOptionPane.showMessageDialog(SiloEngine.silogui,"The silo is being heated","Silo Status",JOptionPane.INFORMATION_MESSAGE);

	}
}
