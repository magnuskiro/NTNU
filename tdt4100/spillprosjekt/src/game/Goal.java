package game;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Goal extends Movable_Object{
	
	private boolean won = false;
	public Goal(Rectangle2D shape) {
		super(shape, getImage("Goal.png"));
	}
	@Override
	public boolean hitbox(Rectangle2D r, Item i) {
		if(i instanceof Player){
			if(r.intersects(this.shape)){
				won = true;
			}
		}
		return false;
	}
	public boolean hasWon(){
		return won;
	}
	public void reset() {
		won = false;
	}
	@Override
	public void gravity(ArrayList<Item> items) {
		dy = 0;
		dx = 0;
	}
}
