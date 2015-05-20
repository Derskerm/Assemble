package Panel;
import java.awt.BorderLayout;
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
		button = new JButton("it works");
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
	        g.drawImage(new ImageIcon("lib//TitleScreenSketch.jpg").getImage(), 0, 0, null);
	}
	
	

}
