package game;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

abstract class Action_Listener extends Action_Object {

	public Action_Listener(Rectangle2D shape, Image image, int id) {
		super(shape, image, id);
	}

	@Override
	public abstract void action();
}
