package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
/**
 * 
 *@author Jørgen Nordmoen
 *<p>
 *This Class is the base class for all non moving objects, all objects which should not be able to move
 *should inherit from this, this includes objects that has multiple states like a 'switch'
 *<p>
 *@see Item
 *@see Movable_Object
 */
public class Static_Object implements Item {

	protected Rectangle2D shape;
	protected Color color;
	protected Image img;
	/**
	 * Creates the static object with it's position and it's shape. 
	 * 
	 * @param x Sets the position of this object to x
	 * @param y Sets the position of this object to y
	 * @param shape Sets this objects shape to shape
	 * @param color Sets this objects colour, this means that this object does not have an image but rather
	 * filled with one colour
	 */
	public Static_Object(Rectangle2D shape, Color color) {
		this.shape = shape;
		this.color = color;
	}
	/**
	 * Creates the Static object with it's position and it's shape.
	 * 
	 * @param x Sets the position of this object to x
	 * @param y Sets the position of this object to y
	 * @param shape Sets this objects shape to shape
	 * @param image Sets this objects image which is used to represent it self on screen, this is only used in the paint method and
	 * a shape must still be specified
	 */
	public Static_Object(Rectangle2D shape, Image image){
		this.shape = shape;
		this.img = image;
	}
	/**
	 * This method draws this object either using it's colour or using the Image of the object.
	 * It first translates the Graphics so it can start drawing from it's top left corner.
	 * When it is done it discards the Graphics object**Should it discard? Needs testing!**
	 * 
	 * @param g the graphics which the object will use to draw with
	 */
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(img == null){
			g2d.setColor(this.color);
			g2d.draw(this.shape);
			g2d.fill(this.shape);
		}else{
			g2d.drawImage(img, (int)shape.getX(), (int)shape.getY(), null);
		}
		g2d.dispose(); //Might remove this because it might delete the control class graphics component
		//but it might also just delete the local variable g2d, which will help memory consumption and 
		//garbage collection?
		
	}
	/**
	 * Checks if this object intersects with the current parameter and returns the result
	 * 
	 * @param s a shape to see if they hit
	 * @return a boolean, true if they hit, false other wise
	 */
	@Override
	public boolean hitbox(Rectangle2D r, Item i) {
		return this.shape.intersects(r);
	}
	@Override
	public Rectangle2D getShape() {
		return shape;
	}

}
