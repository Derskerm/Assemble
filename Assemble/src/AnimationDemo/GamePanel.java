package AnimationDemo;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import Block.Block;
import Block.GrassBlock;

import java.util.*;


public class GamePanel extends JPanel implements Runnable
{
  public static final int DRAWING_WIDTH = 800;
  public static final int DRAWING_HEIGHT = 600;
  
  private Rectangle screenRect;
	
  private Mario mario;
  private ArrayList<Block> obstacles;


  public GamePanel () {
	  super();
	  setBackground(Color.CYAN);
	  screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
	  obstacles = new ArrayList<Block>();
//	  obstacles.add(new Rectangle(200,400,400,50));
//	  obstacles.add(new Rectangle(0,250,100,50));
//	  obstacles.add(new Rectangle(700,250,100,50));
	  boolean yay = true;
	  for (int r = 400; r < 600; r+=Block.BLOCK_SIDE_LENGTH) {
		  for (int c = 0; c < 800; c+=Block.BLOCK_SIDE_LENGTH) {
			  GrassBlock g = new GrassBlock(c,r);
			  if (c % 3 != 0) {
				  g.setSolid(false);
			  }
			  obstacles.add(g);
			  yay = !yay;
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
   
    for (Block b : obstacles) {
    	if (b.isSolid())
    		b.draw(g2, this);
    }
    
    mario.draw(g2,this);
    
    g2.setTransform(at);

	// TODO Add any custom drawings here
  }

  
  public void spawnNewMario() {
	  mario = new Mario(DRAWING_WIDTH/2-Mario.MARIO_WIDTH/2,50);
  }


  public void run() {
	while (true) { // Modify this to allow quitting
	  	mario.act(obstacles);
	  	
	  	if (!screenRect.intersects(mario))
	  		spawnNewMario();
	  	
	  	repaint();
	  	
	  	try {
			Thread.sleep(20);
	  	} catch (InterruptedException e) {}
	}
  }
  
  

public class KeyHandler implements KeyListener {
  private boolean rightKey, leftKey, upKey;
	
  public void keyPressed(KeyEvent e) {
  	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
  		leftKey = true;
  		mario.walk(-1);
  	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		rightKey = true;
		mario.walk(1);
  	} else if (e.getKeyCode() == KeyEvent.VK_UP) {
		upKey = true;
		mario.jump();
  	}
  }

  public void keyReleased(KeyEvent e) {
  	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
  		leftKey = false;
  		if(rightKey)
  			mario.walk(1);
  		else
  			mario.walk(0);
  	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		rightKey = false;
		if (leftKey)
			mario.walk(-1);
		else
			mario.walk(0);
  	} else if (e.getKeyCode() == KeyEvent.VK_UP) {
		upKey = false;
  	}
  }

  public void keyTyped(KeyEvent e) {

  }
}


}
