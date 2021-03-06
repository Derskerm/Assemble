package Panel;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Panel.GamePanel.KeyHandler;


public class Window extends JFrame {
	/**
	 * Contains all the panels and switches between them when needed
	 */
	JPanel cardPanel;
	private TitlePanel title;
	private ControlPanel info;
	private GamePanel game;
	private PausePanel pause;
	private SelectPanel select;
	//private GamePanel game;
	
	public Window(){
		super("Assemble!");
		title = new TitlePanel(this);
		info = new ControlPanel(this);
		game = new GamePanel();
		pause = new PausePanel(this);
		select = new SelectPanel(this);
		
	    addKeyListener(game.new KeyHandler());
		//setResizable(false);
		//game = new GamePanel(this);
		
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    //addKeyListener(panel2.new KeyHandler());
	
	    cardPanel.add(title,"1");
	    cardPanel.add(info,"2");
	    cardPanel.add(game, "3");
	    cardPanel.add(pause, "4");
	    cardPanel.add(select, "5");
	    
	    add(cardPanel);
	
	    setVisible(true);
	    
	}
	
	/**
	 * Switches panels to the next in the list of panels
	 * might change it so it changes to the panel specified in the parameters
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
			game.setCharacter(select.getCharacterNum());
			new Thread(game).start();
			
		}
		else if(panelNum == 4){
			((CardLayout)cardPanel.getLayout()).show(cardPanel,"4");
			requestFocus();
			
		}
		else if(panelNum == 5){
			((CardLayout)cardPanel.getLayout()).show(cardPanel,"5");
			requestFocus();
			
		}
			
			
		
		
		
	}

}
