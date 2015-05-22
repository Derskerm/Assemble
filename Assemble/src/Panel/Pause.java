package Panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Pause extends JPanel{

	/**
	 * Pause screen
	 * @param w Window for changing panels
	 */
	public Pause(Window w){
		BorderLayout b = new BorderLayout();
		setLayout(b);
		add(new PauseButtons(w), BorderLayout.CENTER);
		
	}
	
	

}
