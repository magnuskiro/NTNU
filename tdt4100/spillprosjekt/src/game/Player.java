package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Player extends Movable_Object {

	/*
	 * The boolean values left, right, jump and action will be:
	 * set to true when their respective keys are pressed
	 * and false when they are released.
	 * 
	 * For every cycle in the game, left, right, jump and action will be added to
	 * the Boolean ArrayLists memLeft, memRight, memJump and memAction.
	 * The Ghosts will be doing what the player did, by getting input from these lists instead of the KeyListener.
	 */
	private int speed = 4, jumpPower = 12, spriteNr = 0, changeSpriteInterval = 4;
	protected boolean left, right, jump, action, drawRight = true, drawLeft;
	protected ArrayList<Boolean> 
	memLeft = new ArrayList<Boolean>(), 
	memRight = new ArrayList<Boolean>(), 
	memJump = new ArrayList<Boolean>(),
	memAction = new ArrayList<Boolean>();


	public Player(Rectangle2D shape) {
		super(shape, getImage("Player.png"));
	}

	@Override
	public boolean hitbox(Rectangle2D r, Item i) {
		if(i instanceof Player){
			if(((Movable_Object)i).getUnder().equals(r) && ((Movable_Object)i).getDy() >= 0){
				if(this.getOver().intersects(r)){
					return true;
				}
			}
			return false;
		}
		return super.hitbox(r, i);
	}

	int spriteChanges = 0;
	@Override
	public void draw(Graphics g) {
		if(this.shape.getY() <= 720 && this.shape.getY() >= -this.shape.getHeight() && this.shape.getX() < 1280 && this.shape.getX() >= -this.shape.getWidth()){
			Graphics2D g2d = (Graphics2D) g;
			if(spriteChanges == changeSpriteInterval){
				spriteNr++;
				spriteChanges = 0;
			}else spriteChanges++;
			if(inAir){
				if(dy < 0){
					if(spriteNr < 7 || spriteNr > 8) spriteNr = 7;
				}
				else if(spriteNr < 9 || spriteNr > 10) spriteNr = 9;
			}else if(dx != 0){
				if(spriteNr > 5 || spriteNr < 2) spriteNr = 2;
			}else if(spriteNr > 1) spriteNr = 0;
			if(drawRight){
				g2d.drawImage(img, (int)shape.getX() - 10, (int)shape.getY()-10, (int)shape.getX()+(int)shape.getWidth()+10, (int)shape.getY()+(int)shape.getHeight()+10, (spriteNr+1)*45, 0, spriteNr*45, 45, null);

			}else if(drawLeft){
				g2d.drawImage(img, (int)shape.getX() - 10, (int)shape.getY()-10, (int)shape.getX()+(int)shape.getWidth()+10, (int)shape.getY()+(int)shape.getHeight()+10, spriteNr*45, 0, (spriteNr+1)*45, 45, null);
			}
			g2d.dispose();
		}
	}

	/**
	 * This method is used to add entries to the mem-lists.
	 * The ghost next made will use these lists instead of GameKeys as input.
	 */
	public void Memory(){
		memLeft.add(left && drawLeft);
		memRight.add(right && drawRight);
		memJump.add(jump);
		memAction.add(action);
	}
	/**
	 * Calls Memory and jumps, as well as calling its super.
	 */
	@Override
	public void updatePosition(ArrayList<Item> items) {
		Memory();
		if(jump){
			if(this.isOver(items)) dy = -jumpPower;
		}
		if(action){
			for(int i = 0;i < items.size();i++){
				if(items.get(i) instanceof Action_Perform){
					if(((Action_Perform)items.get(i)).intersects(this.shape)){
						((Action_Perform)items.get(i)).action();
					}
				}
			}
			action = false;
		}
		super.updatePosition(items);
	}

	public void fullReset(){
		super.reset();
		memLeft.clear();
		memRight.clear();
		memJump.clear();
		memAction.clear();
	}

	/**
	 * setLeft, setRight, setJump and setAction will be called by the KeyListener.
	 */
	public void setLeft(boolean left) {
		if(!left){
			dx = 0;
			if(right){
				dx = speed;
				drawRight = true;
				drawLeft = true;
			}
			else{
				drawLeft = true;
				drawRight = false;
			}
		}
		else{
			this.dx = -speed;
			drawRight = false;
			drawLeft = true;
		}
		this.left = left;
	}

	public void setRight(boolean right) {
		if(!right){
			dx = 0;
			if(left){
				dx = -speed;
				drawLeft = true;
				drawRight = false;
			}
			else{
				drawRight = true;
				drawLeft = false;
			}
		}
		else{
			this.dx = speed;
			drawRight = true;
			drawLeft = false;
		}
		this.right = right;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setJump(boolean jump) {
		this.jump = jump;
	}

	public void setAction(boolean action) {
		this.action = action;
	}

	public ArrayList<Boolean> getMemAction() {
		return memAction;
	}

	public ArrayList<Boolean> getMemJump() {
		return memJump;
	}

	public ArrayList<Boolean> getMemLeft() {
		return memLeft;
	}

	public ArrayList<Boolean> getMemRight() {
		return memRight;
	}

}
