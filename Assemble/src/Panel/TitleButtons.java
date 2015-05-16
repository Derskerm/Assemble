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
	private JButton start, info;
	
	/**
	 * 
	 * @param w Window JFrame for changing panels
	 */
	public TitleButtons(Window w){
		BoxLayout b = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(b);
		setOpaque(false);
		start = new JButton(new ImageIcon("StartButton.jpg"));
		info = new JButton("info");
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		info.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.addActionListener(this);
		info.addActionListener(this);
		add(start);
		add(info);
		
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
			myWindow.changePanel(3);
		else if (source == info)
			myWindow.changePanel(2);
	}

}
