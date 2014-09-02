package game;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Wall_Player_cross extends Wall {
	public Wall_Player_cross (Rectangle2D shape, Color color) {
		super(shape, color); 
	}
	@Override
	public boolean hitbox(Rectangle2D r, Item i) {
		if(i instanceof Player && !(i instanceof Ghost)) return false;
		return super.hitbox(r, i);
	}
}
