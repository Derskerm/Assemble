package Panel;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame{
	/**
	 * Contains all the panels and switches between them when needed
	 */
	JPanel cardPanel;
	private TitlePanel title;
	private InfoPanel info;
	private GamePanel game;
	//private GamePanel game;
	
	public Window(){
		super("the game");
		title = new TitlePanel(this);
		info = new InfoPanel(this);
		game = new GamePanel();
		setResizable(false);
		//game = new GamePanel(this);
		
		setBounds(100, 100, 800, 500);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    //addKeyListener(panel2.new KeyHandler());
	
	    cardPanel.add(title,"1");
	    cardPanel.add(info,"2");
	    cardPanel.add(game, "3");
	    
	    add(cardPanel);
	
	    setVisible(true);
	    
	}
	
	/**
	 * Switches panels to the next in the list of panels
	 * might change it so it changes t5o the panel specified in the parameters
	 */
	public void changePanel(int panelNum){
		
		if(panelNum == 1){
			((CardLayout)cardPanel.getLayout()).show(cardPanel,"1");
		requestFocus();

		}
		else if(panelNum == 2){
			((CardLayout)cardPanel.getLayout()).show(cardPanel,"2");
			requestFocus();

		}
		else if(panelNum == 3){
			((CardLayout)cardPanel.getLayout()).show(cardPanel,"3");
			requestFocus();
			new Thread(game).start();
			
		}
			
			
		
		
		
	}

}
