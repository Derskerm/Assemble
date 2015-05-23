package Panel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class InfoPanel extends JPanel implements ActionListener{
	
	
	private Window myWindow;
	private JButton button;
	/**
	 * 
	 * @param w Window JFrame for changing panels
	 */
	public InfoPanel(Window w){
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
	    //Font f = new Font();
	    g.drawImage(new ImageIcon("lib//TitleScreenSketch.jpg").getImage(), 0, 0, null);
	    //Up key
	    g.drawImage(new ImageIcon("lib//computer_key_Arrow_Up.png").getImage(), 20, 20, 50, 50, null);
	    g.drawString("Character jumps", 90, 20);
	    //Down Key
	    g.drawImage(new ImageIcon("lib//computer_key_Arrow_Down.png").getImage(), 20, 90, 50, 50, null);
	    
	    //Left Key
	    g.drawImage(new ImageIcon("lib//computer_key_Arrow_Left.png").getImage(), 20, 160, 50, 50, null);
	    
	    //Right Key
	    g.drawImage(new ImageIcon("lib//computer_key_Arrow_Up.png").getImage(), 20, 230, 50, 50, null);
	    
	    //Shift Key
	    g.drawImage(new ImageIcon("lib//computer_key_Shift.png").getImage(), 20, 300, 130, 50, null);
	    
	    //Enter Key
	    g.drawImage(new ImageIcon("lib//computer_key_Enter.jpg").getImage(), 20, 370, 100, 50, null);
	    
	}
	
	

}
