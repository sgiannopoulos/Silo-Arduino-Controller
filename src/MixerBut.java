import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class MixerBut extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;

	public MixerBut(int width, int height, int x, int y) {
		this.setText("Silo Mixer");
		this.setSize(width, height);
		this.setLocation(x, y);
		this.setBackground(Color.YELLOW);
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Operations.mixer();
		JOptionPane.showMessageDialog(SiloEngine.silogui, "The mixer is online.", "Silo Status",
				JOptionPane.INFORMATION_MESSAGE);

	}
}
