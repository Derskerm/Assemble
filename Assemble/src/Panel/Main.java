package Panel;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

	JPanel cardPanel;
	
	public Main(String title) {
		super(title);
		Window w = new Window();
	}

	/**
	 * Displays the game
	 * @param args
	 */
	public static void main(String[] args) {
		Main w = new Main("Assemble!");
	}
  
	/**
	 * Switches between panels in the game
	 */
	public void changePanel() {
		((CardLayout)cardPanel.getLayout()).next(cardPanel);
		requestFocus();
	}
}