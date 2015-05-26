package Panel;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import AnimationDemo.MovingImage;
import Block.Block;
import Block.GrassBlock;
import Character.player.CatLady;
import Character.player.Player;
import Character.player.SuperShelbz;
import Level.*;
import Plane.Plane;

import java.util.*;


public class GamePanel extends JPanel implements Runnable
{
  public static final int DRAWING_WIDTH = 800;
  public static final int DRAWING_HEIGHT = 600;
  
  private int playerStartX, playerStartY;
  
  private Rectangle screenRect;

  private LevelLibrary lib;
  private Plane plane;
  private Player player;
  private Level level;


  public GamePanel () {
	  super();
	  setBackground(Color.CYAN);
	  screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
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
	  lib = new LevelLibrary(2);
	  level = lib.getCurrentLevel();
	  plane = new Plane(level);
	  player = level.getPlayer();
	  playerStartX = (int)player.getX();
	  playerStartY = (int)player.getY();
	  new Thread(this).start();
  }
  
  public void resetLevel() {
	  level = lib.getCurrentLevel();
	  plane = new Plane(level);
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
    
    if (player.getMaxX() >= screenRect.getMaxX() - 100) {
    	int diff = (int)(player.getMaxX() - (screenRect.getMaxX() - 100));
    	if (plane.getX() + plane.getWidth() - diff >= screenRect.getMaxX()) {
        	plane.translate(-diff, 0);
    	} else {
        	int diff2 = plane.getX();
    		plane.translate(-diff2, 0);
    	}
    } else if (player.getMinX() < screenRect.getMinX() + 100) {
    	int diff = (int)(screenRect.getMinX() + 100 - player.getMinX());
    	if (plane.getX() + diff <= screenRect.getMinX()) {
        	plane.translate(diff, 0);
    	} else {
        	int diff2 = -plane.getX();
    		plane.translate(diff2, 0);
    	}
    }

    plane.draw(g2, this);
    
    g2.setColor(new Color(110,110,110));
    g2.fillRect((int)player.x, (int)player.y+(int)player.height, (int)player.width, 5);
    
    g2.setColor(Color.GREEN);
    g2.fillRect((int)player.x + 1, (int)player.y+(int)player.height+1, (int)((player.width-2)*(player.getHealth()/player.totalHealth())), 3);
    
    g2.setTransform(at);

	// TODO Add any custom drawings here
  }

  
  public void spawnNewMario() {
	  player = level.getPlayer();
	  player.moveToLocation(playerStartX, playerStartY);
	  player.insertIntoPlane(plane);
  }

  

  public void run() {
	while (true) { // Modify this to allow quitting
	  	plane.act();
	  	
	  	if (player.getPlane() == null || !screenRect.intersects(player)) {
	  		lib = new LevelLibrary(2);
	  		level = lib.getCurrentLevel();
			plane = new Plane(level);
			player = level.getPlayer();
	  	}
	  	
	  	if (level.hasWon()) {
	  		if (lib.getCurrentLevel() != null) {
		  		//JOptionPane.showMessageDialog(null, "Victory!");
	  		} else {
		  		//JOptionPane.showMessageDialog(null, "You have won the game!!!!!!");
		  		lib = new LevelLibrary(0);
	  		}
	  		double h = player.getHealth();
			level = lib.getCurrentLevel();
			plane = new Plane(level);
			player = level.getPlayer();
			player.setHealth(h);
			playerStartX = (int)player.getX();
			playerStartY = (int)player.getY();
	  	}
	  	
	  	repaint();
	  	
	  	try {
			Thread.sleep(20);
	  	} catch (InterruptedException e) {}
	}
  }

public class KeyHandler implements KeyListener {
  private boolean upKey, rightKey, leftKey, space, shift;//, upKey;
	
  public void reset() {
	  upKey = false;
	  rightKey = false;
	  leftKey = false;
	  space = false;
	  shift = false;
  }
  
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
  	else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
  		space = true;
  		player.attack();
  	}
  }

  public void keyReleased(KeyEvent e) {
  	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
  		leftKey = false;
  		if(rightKey) {
	  		player.walk(1);
  		}
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
