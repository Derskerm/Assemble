package Panel;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import AnimationDemo.MovingImage;
import Block.Block;
import Block.GrassBlock;
import Character.player.Player;
import Level.*;

import java.util.*;


public class GamePanel extends JPanel implements Runnable
{
  public static final int DRAWING_WIDTH = 800;
  public static final int DRAWING_HEIGHT = 600;
  
  private int playerStartX, playerStartY;
  
  private Rectangle screenRect;
	
  private Player player;
  private ArrayList<Shape> obstacles;
  private Level level;


  public GamePanel () {
	  super();
	  setBackground(Color.CYAN);
	  screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
	  obstacles = new ArrayList<Shape>();
//	  obstacles.add(new Rectangle(200,400,400,50));
//	  obstacles.add(new Rectangle(0,250,100,50));
//	  obstacles.add(new Rectangle(700,250,100,50));
//	  boolean yay = true;
//	  for (int r = 400; r < 600; r+=Block.BLOCK_SIDE_LENGTH) {
//		  for (int c = 0; c < 800; c+=Block.BLOCK_SIDE_LENGTH) {
//			  GrassBlock g = new GrassBlock(c,r);
//			  obstacles.add(g);
//			  yay = !yay;
//		  }
//	  }
	  //level = new LevelOne();
	  level = new LevelTwo();
	  MovingImage[][] mi = level.getLevelItems();
	  for (MovingImage[] i : mi) {
		  for (MovingImage m : i) {
			  if (m instanceof Block) {
				  obstacles.add(m);
			  } else if (m instanceof Player) {
				  player = (Player)m;
				  playerStartX = (int) player.getMinX();
				  playerStartY = (int) player.getMinY();
			  }
		  }
	  }
	  spawnNewMario();
	  new Thread(this).start();
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

	Graphics2D g2 = (Graphics2D)g;

    int width = getWidth();
    int height = getHeight();
    
    double ratioX = (double)width/DRAWING_WIDTH;
    double ratioY = (double)height/DRAWING_HEIGHT;
    
    AffineTransform at = g2.getTransform();
    g2.scale(ratioX, ratioY);

    //g.setColor(new Color(205,102,29));
   
  //Background image
  	BufferedImage img = null;
      try {
          img = ImageIO.read(new File("lib//assemble_background.png"));
      } catch (IOException e) {
      	e.printStackTrace();
      }
      g2.drawImage(img, 0, 0, DRAWING_WIDTH, DRAWING_HEIGHT, this);
      
    for (Shape b : obstacles) {
    	if (b instanceof Block)
    		((Block)b).draw(g2, this);
    }
    
    player.draw(g2,this);
    
    g2.setTransform(at);

	// TODO Add any custom drawings here
  }

  
  public void spawnNewMario() {
	  player = new Player(playerStartX,playerStartY);
  }


  public void run() {
	while (true) { // Modify this to allow quitting
	  	player.act(obstacles);
	  	
	  	if (!screenRect.intersects(player))
	  		spawnNewMario();
	  	
	  	if (level.hasWon()) {
	  		JOptionPane.showMessageDialog(null, "Victory!");
	  		spawnNewMario();
	  	}
	  	
	  	repaint();
	  	
	  	try {
			Thread.sleep(20);
	  	} catch (InterruptedException e) {}
	}
  }
  
  

public class KeyHandler implements KeyListener {
  private boolean rightKey, leftKey, upKey, space, shift;
	
  public void keyPressed(KeyEvent e) {
  	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
  		leftKey = true;
  		player.walk(-1);
  	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		rightKey = true;
		player.walk(1);
  	} else if (e.getKeyCode() == KeyEvent.VK_UP) {
		upKey = true;
		player.jump();
  	} else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
  		shift = true;
  		player.special();
  	}
  	/*else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
  		space = true;
  		player.attack(other);
  	}*/
  }

  public void keyReleased(KeyEvent e) {
  	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
  		leftKey = false;
  		if(rightKey)
  			player.walk(1);
  		else
  			player.walk(0);
  	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		rightKey = false;
		if (leftKey)
			player.walk(-1);
		else
			player.walk(0);
  	} else if (e.getKeyCode() == KeyEvent.VK_UP) {
		upKey = false;
  	} else if (e.getKeyCode() == KeyEvent.VK_SHIFT) { 
  		shift = false;
  	} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
  		space = false;
  	}
  }

  public void keyTyped(KeyEvent e) {

  }
}


}
