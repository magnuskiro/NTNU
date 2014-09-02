package game;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Action_Perform extends Action_Object{
	
	protected boolean actionPerformed = false;
	protected ArrayList<Action_Listener> listeners = new ArrayList<Action_Listener>();
	
	public Action_Perform(Rectangle2D shape, Image image, int id) {
		super(shape, image, id);
	}
	
	public void addListener(Action_Listener listener){
		listeners.add(listener);
	}

	public boolean intersects(Rectangle2D shape) {
		return this.shape.intersects(shape);
	}
	
	@Override
	public boolean hitbox(Rectangle2D r, Item i) {
		return false;
	}
	
	@Override
	public void action() {
		actionPerformed = !actionPerformed;
		for(Action_Listener al:listeners){
			al.action();
		}
	}
	
	protected boolean getActionPerformed() {
		return actionPerformed;
	}
	
	@Override
	public void reset() {
		actionPerformed = false;
	}
	

}
