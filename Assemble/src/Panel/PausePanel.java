package Panel;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;


public class PausePanel extends JPanel implements ActionListener {
	
	Window w;
	
	public PausePanel(Window w) {
		this.w = w;
		JButton button = new JButton("Press me!");
		button.addActionListener(this);
		add(button);
	}

	public void actionPerformed(ActionEvent e) {
		w.changePanel(4);
	}
	
}