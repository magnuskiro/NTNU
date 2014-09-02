package game;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

abstract class Action_Object extends Movable_Object {
	protected int id; 
	
	public Action_Object(Rectangle2D shape, Image image, int id) {
		super(shape, image);
		this.id = id; 
	}
	
	@Override
	public void move(int ddx, int ddy){return;}
	
	public abstract void action();

	public int getId() {
		return id;
	}
}
