package Panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ControlPanel extends JPanel implements ActionListener{
	
	
	private Window myWindow;
	private JButton button;
	/**
	 * 
	 * @param w Window JFrame for changing panels
	 */
	public ControlPanel(Window w){
		myWindow = w;
		BorderLayout b = new BorderLayout();
		setLayout(b);
		button = new JButton("Back to Title");
		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);
	}

	@Override
	/**
	 * Changes panels when button is pressed
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source == button)
			myWindow.changePanel(1);
	}

	/**
	 * Paints like a regular JPanel but with the image background
	 */
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    int buttonD = (int)(getHeight() * .12);
	    int imageX = (int)(getWidth() * .05);
	    int imageYU = (int)(getHeight() * .05);
	    int imageSpacing = buttonD + (int)(getHeight() * .05);
	    int sX = (int)(getWidth() * .15);
	    int sY = (int)(getHeight() * .11);
	    //int sSpacing = buttonD + (int)
	    Font f = new Font(Font.SANS_SERIF, Font.BOLD, (int)(getHeight() * .05));
	    g.setFont(f);
	    g.setColor(Color.WHITE);
	    g.drawImage(new ImageIcon("lib//Background.png").getImage(), 0, 0, null);
	    //Up key
	    g.drawImage(new ImageIcon("lib//computer_key_Arrow_Up.png").getImage(), imageX, imageYU, buttonD, buttonD, null);
	    g.drawString("Character jumps", sX, sY);
	    //Left Key
	    g.drawImage(new ImageIcon("lib//computer_key_Arrow_Left.png").getImage(), imageX, imageYU + imageSpacing, buttonD, buttonD, null);
	    g.drawString("Character moves left", sX, sY + imageSpacing);
	    //Right Key
	    g.drawImage(new ImageIcon("lib//computer_key_Arrow_Up.png").getImage(), imageX, imageYU + imageSpacing * 2, buttonD, buttonD, null);
	    g.drawString("Character moves right", sX, sY + imageSpacing * 2);
	    //Shift Key
	    g.drawImage(new ImageIcon("lib//computer_key_Shift.png").getImage(), imageX, imageYU + imageSpacing * 3, (int)(getWidth() * .18), buttonD, null);
	    g.drawString("Character's ability activates", (int)(getWidth() * .25), sY + imageSpacing * 3);
	    //Enter Key
	    g.drawImage(new ImageIcon("lib//computer_key_Enter.jpg").getImage(), imageX, imageYU + imageSpacing * 4, (int)(getWidth() * .15), buttonD, null);
	    g.drawString("Character attacks", (int)(getWidth() * .21), sY + imageSpacing * 4);
	}
	
	

}
