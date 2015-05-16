package Panel;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

	JPanel cardPanel;
	
	public Main(String title) {
		super(title);
		Window w = new Window();
		/*setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    Window w = new Window();
	    //TitleButtons buttons = new TitleButtons(w);
	    //TitlePanel panel1 = new TitlePanel(w);
		//OptionPanel panel1 = new OptionPanel(this);    
	    /GamePanel panel2 = new GamePanel();
	    
	    addKeyListener(panel2.new KeyHandler());
	
	    cardPanel.add(panel1,"1");
	    cardPanel.add(panel2,"2");
	    
	    add(cardPanel);
	
	    setVisible(true);*/
	}

	public static void main(String[] args)
	{
		Main w = new Main("Assemble!");
	}
  
	public void changePanel() {
		((CardLayout)cardPanel.getLayout()).next(cardPanel);
		requestFocus();
	}
  
}