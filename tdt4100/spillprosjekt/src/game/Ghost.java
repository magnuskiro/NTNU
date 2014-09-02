package game;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Ghost extends Player {

	private int cycleNr = 0;
	@SuppressWarnings("unchecked")
	public Ghost(Rectangle2D shape, ArrayList<Boolean> memLeft, ArrayList<Boolean> memRight, ArrayList<Boolean> memJump, ArrayList<Boolean> memAction) {
		super(shape);
		this.img = getImage("Ghost.png");
		this.memLeft = (ArrayList<Boolean>) memLeft.clone();
		this.memRight = (ArrayList<Boolean>) memRight.clone();
		this.memJump = (ArrayList<Boolean>) memJump.clone();
		this.memAction = (ArrayList<Boolean>) memAction.clone();
	}
	
	@Override
	public void reset() {
		super.reset();
		cycleNr = 0;
	}
	
	@Override
	public void Memory() {
		if(cycleNr < memLeft.size()){
			if(left != memLeft.get(cycleNr)) setLeft(memLeft.get(cycleNr));
			if(right != memRight.get(cycleNr)) setRight(memRight.get(cycleNr));
			if(jump != memJump.get(cycleNr)) setJump(memJump.get(cycleNr));
			setAction(memAction.get(cycleNr));
			cycleNr++;
		}else{
			setLeft(false);
			setRight(false);
			setJump(false);
			setAction(false);
		}
	}

}
