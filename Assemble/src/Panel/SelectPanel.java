package Panel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class SelectPanel extends JPanel implements ActionListener{
	
	
	private Window myWindow;
	private JButton button, button2;
	private int charNum;
	/**
	 * 
	 * @param w Window JFrame for changing panels
	 */
	public SelectPanel(Window w){
		myWindow = w;
		BorderLayout b = new BorderLayout();
		setLayout(b);
		JPanel panel = new JPanel();
		button = new JButton("CatLady");
		button2 = new JButton("SuperShelbz");
		button.addActionListener(this);
		button2.addActionListener(this);
		panel.add(button);
		panel.add(button2);
		add(panel, BorderLayout.SOUTH);
	}

	@Override
	/**
	 * Changes panels when button is pressed
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source == button) {
			charNum = 0;
			myWindow.changePanel(3);
		} else if(source == button2) {
			charNum = 1;
			myWindow.changePanel(3);
		}
	}
	
	public int getCharacterNum() {
		return charNum;
	}

	/**
	 * Paints like a regular JPanel but with the image background
	 */
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	    g.setFont(f);
	    g.drawString("Choose a character!", 300, 300);
	}
	
	

}
