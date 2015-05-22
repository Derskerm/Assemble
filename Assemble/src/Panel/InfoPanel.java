package Panel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class InfoPanel extends JPanel implements ActionListener{
	
	
	private Window myWindow;
	private JButton button;
	/**
	 * Screen with the controls
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

	/**
	 * Changes panels when button is pressed
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source == button)
			myWindow.changePanel(1);
	}


	
	

}
