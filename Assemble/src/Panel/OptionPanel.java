package Panel;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import Panel.Window;


public class OptionPanel extends JPanel implements ActionListener {
	
	Window w;
	
	public OptionPanel(Window w) {
		this.w = w;
		JButton button = new JButton("Press me!");
		button.addActionListener(this);
		add(button);
	}

	public void actionPerformed(ActionEvent e) {
		//w.changePanel();
	}
	
}