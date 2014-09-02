package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Switch extends Action_Perform {
	public Switch(Rectangle2D shape, int id) {
		super(shape, getImage("Switch.png"), id);
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int pos = 0;
		if(getActionPerformed()) pos = 1;
		g2d.drawImage(img, (int)shape.getX()-1, (int)shape.getY()-1, (int)(shape.getX() + shape.getWidth()+1), (int)(shape.getY() + shape.getHeight()+1),20*pos, 0, 20*(pos+1), 20, null);
		g2d.dispose();
	}
}
