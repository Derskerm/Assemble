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
	    Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	    g.setFont(f);
	    g.setColor(Color.WHITE);
	    g.drawImage(new ImageIcon("lib//Background.png").getImage(), 0, 0, null);
	    //Up key
	    g.drawImage(new ImageIcon("lib//computer_key_Arrow_Up.png").getImage(), 20, 20, 50, 50, null);
	    g.drawString("Character jumps", (int)(getWidth() * .1), (int)(getHeight() * .1));
	    //Left Key
	    g.drawImage(new ImageIcon("lib//computer_key_Arrow_Left.png").getImage(), 20, 160, 50, 50, null);
	    g.drawString("Character moves left", 90, 190);
	    //Right Key
	    g.drawImage(new ImageIcon("lib//computer_key_Arrow_Up.png").getImage(), 20, 230, 50, 50, null);
	    g.drawString("Character moves right", 90, 260);
	    //Shift Key
	    g.drawImage(new ImageIcon("lib//computer_key_Shift.png").getImage(), 20, 300, 130, 50, null);
	    g.drawString("Character's ability activates", 170, 330);
	    //Enter Key
	    g.drawImage(new ImageIcon("lib//computer_key_Enter.jpg").getImage(), 20, 370, 100, 50, null);
	    g.drawString("Character attacks", 140, 400);
	}
	
	

}
