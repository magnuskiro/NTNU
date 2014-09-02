package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
/**
 * 
 *<p>
 *This is the base class for which all movable objects in the game will inherit from, it has
 *some basic methods, which include the collision detection, painting it self and moving.
 *<p>
 *The class it self inherits from Item to insure that all objects in the game can do collision detection
 *and paint them self
 *
 *@see Static_Object
 *@see Item
 */
public class Movable_Object implements Item{
	/*
	 * The current (x,y) position, the previous position (prevX, prevY)
	 * Current speed in x direction (dx) and speed in y (dy)
	 * 
	 * Shape is the shape of this object, which will be used to check collision detection
	 * 
	 * Color is used if this object just has one fill colour
	 * 
	 * Img is used if this object presents it self using an image to paint
	 */
	protected boolean inAir = false;
	protected final int gravity = 1;
	protected int prevX, prevY, dx, dy, startX, startY;
	protected Rectangle2D shape;
	protected Color color;
	protected Image img;
	/**
	 * Creates the movable object with it's position and it's shape. This method also sets the various different other
	 * parameters of this object to a default value
	 * 
	 * @param x Sets the position of this object to x
	 * @param y Sets the position of this object to y
	 * @param shape Sets this objects shape to shape
	 * @param color Sets this objects colour, this means that this object does not have an image but rather
	 * filled with one colour
	 */
	public Movable_Object(Rectangle2D shape, Color color) {
		this.prevX = 0;
		this.prevY = 0;
		this.startX = (int)shape.getX();
		this.startY = (int)shape.getY();
		this.shape = shape;
		this.color = color;
		this.dx = 0;
		this.dy = 0;
	}
	/**
	 * Creates the movable object with it's position and it's shape. This method also sets the various different other
	 * parameters of this object to a default value
	 * 
	 * @param x Sets the start position of this object to x
	 * @param y Sets the start position of this object to y
	 * @param shape Sets this objects shape to shape
	 * @param image Sets this objects image which is used to represent it self on screen, this is only used in the paint method and
	 * a shape must still be specified
	 */
	public Movable_Object(Rectangle2D shape, Image image){
		this.prevX = 0;
		this.prevY = 0;
		this.startX = (int)shape.getX();
		this.startY = (int)shape.getY();
		this.shape = shape;
		this.img = image;
		this.dx = 0;
		this.dy = 0;
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
		g2d.dispose();
		
	}
	
	/**
	 * The reset function resets the object to its original positions, this will be used when for instance the Player
	 * 'ghosts'
	 */
	public void reset(){
		this.shape.setRect((double)this.startX, (double)this.startY, this.shape.getWidth(), this.shape.getHeight());
		this.dx = 0;
		this.dy = 0;
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
	/**
	 * This method updates the speed in both directions. Contrary to it's name this method
	 * does not move the object it self, but rather it updates it's speed, to move the object
	 * use updateX() or updateY()
	 * 
	 * @param ddx the acceleration to the speed in the x direction
	 * @param ddy the acceleration to the speed in the y direction
	 */
	public void move(int ddx, int ddy){
		this.dx += ddx;
		this.dy += ddy;
	}	
	/**
	 * This method moves the object, by just adding the current speed to the position
	 */
	public void updatePosition(ArrayList<Item> items){
		this.gravity(items);
		for(int i = 0;i < dx;i++){
			if(this.isToTheLeftOf(items)) break;
			else this.shape.setRect(shape.getX()+1, shape.getY(), shape.getWidth(), shape.getHeight());
		}
		for(int i = 0;i > dx;i--){
			if(this.isToTheRightOf(items)) break;
			else this.shape.setRect(shape.getX()-1, shape.getY(), shape.getWidth(), shape.getHeight());
		}
		for(int i = 0;i < dy;i++){
			if(this.isOver(items)) break;
			else this.shape.setRect(shape.getX(), shape.getY()+1, shape.getWidth(), shape.getHeight());
		}
		for(int i = 0;i > dy;i--){
			if(this.isUnder(items)) dy = 0;
			else this.shape.setRect(shape.getX(), shape.getY()-1, shape.getWidth(), shape.getHeight());
		}
	}
	/**
	 * This method accelerates the Movable_Object downwards if there is nothing under it.
	 * Otherwise it sets dy to 0;
	 * @param items
	 */
	public void gravity(ArrayList<Item> items){
		if(this.shape.getY() <= 720 && this.shape.getY() >= -this.shape.getHeight() && this.shape.getX() < 1280 && this.shape.getX() >= -this.shape.getWidth()){
			inAir = !isOver(items);
			if(inAir) this.move(0, gravity);
			else if(this.dy > 0) this.dy = 0;
		}else dy = 0;
	}
	/**
	 * This method checks whether the object is over another object, used for finding out  whether the object can move downwards.
	 * @param items an ArrayList<Item>, a list of items the object might be over.
	 * @return a boolean, true if object is right over an Item, false otherwise.
	 */
	public boolean isOver(ArrayList<Item> items){
		Rectangle under = getUnder();
		for(Item i:items){
			if(i.hitbox(under, this)){
				if(i instanceof Movable_Object && !(this instanceof Switch || this instanceof Door)){
					int newDx = 0;
					if(this instanceof Player){
						if(((Player)this).left && !((Player)this).right) newDx -= ((Player)this).getSpeed();
						else if(((Player)this).right) newDx += ((Player)this).getSpeed();
					}else{
						newDx += dx;
					}
					if(this.dy >= 0) newDx += ((Movable_Object)i).dx;
					this.dx = newDx;
				}
				return true;
			}
		}
		return false;
	}
	/**
	 * This method checks whether the object is under another object, used for finding out  whether the object can move upwards.
	 * @param items an ArrayList<Item>, a list of items the object might be under.
	 * @return a boolean, true if object is right under an Item, false otherwise.
	 */
	public boolean isUnder(ArrayList<Item> items){
		Rectangle over = getOver();
		for(Item i:items){
			if(i.hitbox(over, this)){
				return true;
			}
		}
		return false;
	}
	/**
	 * This method checks whether the object is to the left of another object, used for finding out  whether the object can move to the right.
	 * @param items an ArrayList<Item>, a list of items the object might be to the left of.
	 * @return a boolean, true if object is to the left of an Item, false otherwise.
	 */
	public boolean isToTheLeftOf(ArrayList<Item> items){
		Rectangle right = getRightOf();
		for(Item i:items){
			if(i.hitbox(right, this)) return true;
		}
		return false;
	}
	/**
	 * This method checks whether the object is to the right of another object, used for finding out  whether the object can move to the left.
	 * @param items an ArrayList<Item>, a list of items the object might be to the right of.
	 * @return a boolean, true if object is to the right of an Item, false otherwise.
	 */
	public boolean isToTheRightOf(ArrayList<Item> items){
		Rectangle left = getLeftOf();
		for(Item i:items){
			if(i.hitbox(left, this)) return true;
		}
		return false;
	}
	public Rectangle getUnder(){
		return new Rectangle((int)shape.getX(), (int)(shape.getY()+shape.getHeight()+1), (int)shape.getWidth(), 1);
	}
	public Rectangle getOver(){
		return new Rectangle((int)shape.getX(), (int)(shape.getY()-1), (int)shape.getWidth(), 1);
	}
	public Rectangle getRightOf(){
		return new Rectangle((int)(shape.getX()+shape.getWidth()+1), (int)(shape.getY()), 1, (int)shape.getHeight());
	}
	public Rectangle getLeftOf(){
		return new Rectangle((int)(shape.getX()-1), (int)(shape.getY()), 1, (int)shape.getHeight());
	}
	@Override
	public Rectangle2D getShape() {
		return this.shape;
	}
	
	public int getStartX() {
		return startX;
	}
	
	public int getStartY() {
		return startY;
	}
	
	public int getDy() {
		return dy;
	}
	
	public int getDx() {
		return dx;
	}
	
	public static Image getImage(String imgName){
		//return Toolkit.getDefaultToolkit().getImage(resources+imgName);
		return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(resources+imgName));
	}
	
	
}
