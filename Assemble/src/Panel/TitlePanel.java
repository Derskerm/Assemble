package Panel;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class TitlePanel extends JPanel{

	private TitleButtons buttons;
	private Image image;
	
	
	/**
	 * JPanel that is the title screen of the game doesn't have anything other than the start and info buttons
	 * @param w is object class Window that changes the panels
	 */
	public TitlePanel(Window w){

		buttons = new TitleButtons(w);
		BorderLayout b = new BorderLayout();
		setLayout(b);
		add(buttons, BorderLayout.SOUTH);

		image = new ImageIcon("lib//TitleBackground.png").getImage();
	}
	

	protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	    //BufferedImage image2 = createResizedCopy(image, getWidth(), getHeight(), false);
	        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	        
	}
	
	private BufferedImage createResizedCopy(Image originalImage, 
    		int scaledWidth, int scaledHeight, 
    		boolean preserveAlpha)
    {
    	//System.out.println("resizing...");
    	int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
    	BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
    	Graphics2D g = scaledBI.createGraphics();
    	if (preserveAlpha) {
    		g.setComposite(AlphaComposite.Src);
    	}
    	g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
    	g.dispose();
    	return scaledBI;
    }	
	
}

