package Panel;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PauseButtons extends JPanel implements ActionListener{

	private Window myWindow;
	private JButton resume, quit;
	
	/**
	 * All the buttons on the pause screen, resume button returns to the game, quit button returns to the title screen
	 * @param w Window for changing panels
	 */
	public PauseButtons(Window w){
		
		myWindow = w;
		resume = new JButton("Resume");
		quit = new JButton("Quit");
		BoxLayout b = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(b);
		resume.setAlignmentX(Component.CENTER_ALIGNMENT);
		quit.setAlignmentX(Component.CENTER_ALIGNMENT);
		resume.addActionListener(this);
		quit.addActionListener(this);

		add(resume);
		add(quit);
	}
	

	@Override
	/**
	 * Switches panels when the buttons are pressed
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source == resume)
			myWindow.changePanel(3);
		
		else if (source == quit)
			myWindow.changePanel(1);
	}
	
	
}
