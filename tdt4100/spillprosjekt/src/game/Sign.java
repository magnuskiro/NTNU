package game;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Sign extends Static_Object {

	private String[] text;
	private boolean reading;
	
	public Sign(Rectangle2D shape, String text) {
		super(shape, Movable_Object.getImage("Sign.png"));
		this.text = text.split("/n");
	}
	
	@Override
	public boolean hitbox(Rectangle2D r, Item i) {
		if(i instanceof Player && !(i instanceof Ghost)){
			if(i.getShape().intersects(this.shape)) reading = true;
			else reading = false;
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		if(reading){
			for(int i =text.length; i>0; i--){
				g.drawString(text[text.length-i], (int)(shape.getX()-(text[text.length-i].length()*2)), (int)(shape.getY()-15*i));				
			}
		}
		super.draw(g);
	}
	
}
