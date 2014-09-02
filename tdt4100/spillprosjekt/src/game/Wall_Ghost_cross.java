package game;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Wall_Ghost_cross extends Wall {
	public Wall_Ghost_cross(Rectangle2D shape, Color color) {
		super(shape, color); 
	}
	@Override
	public boolean hitbox(Rectangle2D r, Item i) {
		if(i instanceof Ghost) return false;
		return super.hitbox(r, i);
	}
}
