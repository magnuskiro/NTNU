package game;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Box extends Movable_Object{
	public Box(Rectangle2D shape) {
		super(shape, getImage("Box.png"));
	}
	@Override
	public boolean hitbox(Rectangle2D r, Item i) {
		if(i instanceof Player){
			if(r.equals(((Player)i).getLeftOf()) || r.equals(((Player)i).getRightOf())){
				if(this.getShape().intersects(r)){
					dx = ((Player)i).getDx();
				}
			}
		}
		return super.hitbox(r, i);
	}
	
	@Override
	public void updatePosition(ArrayList<Item> items) {
		super.updatePosition(items);
		dx = 0;
	}
}
