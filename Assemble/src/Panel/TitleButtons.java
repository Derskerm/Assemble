package Panel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TitleButtons extends JPanel implements ActionListener{
	
	private Window myWindow;
	private JButton start, controls;
	
	/**
	 * 
	 * @param w Window JFrame for changing panels
	 */
	public TitleButtons(Window w){
		BoxLayout b = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(b);
		setOpaque(false);
		start = new JButton(new ImageIcon("lib//StartButton.jpg"));
		controls = new JButton(new ImageIcon("lib//ControlsButton.png"));
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		controls.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.addActionListener(this);
		controls.addActionListener(this);
		add(start);
		add(controls);
		
		myWindow = w;
	}

	@Override
	/**
	 * Changes panels when buttons are presses
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source == start)
			myWindow.changePanel(5);
		else if (source == controls)
			myWindow.changePanel(2);
	}

}
