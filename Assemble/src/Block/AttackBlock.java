package Block;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Plane.Plane;

public class AttackBlock extends Block implements ActionListener {

	private Timer t = new Timer(100,this);
	
	public AttackBlock(String filename, int x, int y) {
		super(false, filename, x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void insertIntoPlane(Plane p) {
		super.insertIntoPlane(p);
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		t.stop();
		removeFromGrid();
	}

}
