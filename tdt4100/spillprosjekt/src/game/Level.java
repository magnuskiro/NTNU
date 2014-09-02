package game;

import java.util.ArrayList;

public class Level {
	private ArrayList<Movable_Object> movableObjects = new ArrayList<Movable_Object>();
	private ArrayList<Static_Object> staticObjects = new ArrayList<Static_Object>(); 
	private int playerX, playerY, levelnumber; 
	private String levelcode; 
	private boolean active;
	private Goal goal; 
	
	public void setGoal(Goal goal) {
		this.goal = goal;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}
	public String getLevelcode() {
		return levelcode;
	}
	public int getLevelnumber() {
		return levelnumber;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Static_Object> getStatic_Objects() {
		return (ArrayList<Static_Object>)staticObjects.clone();
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Movable_Object> getMoveable_Objects() {
		return (ArrayList<Movable_Object>)movableObjects.clone();
	}
	public int getPlayerX() {
		return playerX;
	}
	public int getPlayerY() {
		return playerY;
	}
	public void addMovable_Object(Movable_Object object) {
		movableObjects.add(object); 
	}
	public void addStatic_Object(Static_Object object) {
		staticObjects.add(object);
	}
	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}
	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}
	public void setLevelcode(String levelcode) {
		this.levelcode = levelcode;
	}
	public void setLevelnumber(int levelnumber) {
		this.levelnumber = levelnumber;
	}
	public Goal getGoal() {
		return goal;
	}
	
}
