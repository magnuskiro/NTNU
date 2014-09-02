package game;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Door extends Action_Listener {

	private boolean open = false;
	
	public Door(Rectangle2D shape, int id) {
		super(shape, getImage("Door.png"), id); // hardcode image link
	}

	@Override
	public void action() {
		System.out.println("opening");
		open = !open;
	}
	
	@Override
	public boolean hitbox(Rectangle2D r, Item i) {
		if(super.hitbox(r, i)){
			return !open;
		}
		return false;
	}
	
	@Override
	public void reset() {
		open = false;
	}
	
	@Override
	public void draw(Graphics g) {
		if(!open) super.draw(g);
	}

}
