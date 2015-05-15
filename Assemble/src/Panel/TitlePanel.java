package Panel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class TitlePanel extends JPanel{

	private TitleButtons buttons;
	
	
	/**
	 * JPanel that is the title screen of the game doesn't have anything other than the start and info buttons
	 * @param w is object class Window that changes the panels
	 */
	public TitlePanel(Window w){

		buttons = new TitleButtons(w);
		BorderLayout b = new BorderLayout();
		setLayout(b);
		add(buttons, BorderLayout.SOUTH);

		
	}
	
	/**
	 * Paints like a regular JPanel but with the image background
	 */
	protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(new ImageIcon("TitleScreenSketch.jpg").getImage(), 0, 0, null);
	}




	
	
	
}
