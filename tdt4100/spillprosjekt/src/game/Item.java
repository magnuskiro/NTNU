package game;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

/*
 * The Item interface is the game's core class which most of the game's different objects will ultimately 
 * inherit from, this to insure that all objects at least will be able to draw it self and also do some
 * simple hit detection. 
 * 
 * Possibly re-think this as the Core, is there any other possible ways of doing this better?
 */

public interface Item {
	public final String resources = "resources/";
	//The 'draw' method is the method which every object will use to draw it self
	//The input 'g' is what the method will use to draw itself on to the screen, it
	//will get 'g' from the 'Control' class which is already tied up to the JFrame.
	//The method should NOT alter 'g' or any other thing outside the method it self
	/**
	 * 
	 * javadoc comments, insert parameters and method description here.
	 */
	void draw(Graphics g);
	//The 'hitbox' method is the method which objects will use to check if they are
	//touching one-another, the input 's' is what the method will check it self up against
	//the method will return true or false depending on whether it intersects the Shape 's'
	boolean hitbox(Rectangle2D r, Item i);
	
	Rectangle2D getShape();
	
}
