package Panel;

import java.awt.*;

import javax.swing.*;

import Testers.TestGenerator;

import java.awt.event.*;


public class OptionPanel extends JPanel implements ActionListener {
	
	Main w;
	
	public OptionPanel(Main w) {
		this.w = w;
		JButton button = new JButton("Press me!");
		button.addActionListener(this);
		add(button);
	}
	
	public OptionPanel(TestGenerator testGenerator) {
		this.w = w;
		JButton button = new JButton("Press me!");
		button.addActionListener(this);
		add(button);
	}

	public void actionPerformed(ActionEvent e) {
		w.changePanel();
	}
	
}