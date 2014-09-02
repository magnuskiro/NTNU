package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeys implements KeyListener{

	private int 
	left1 = KeyEvent.VK_LEFT,
	jump1 = KeyEvent.VK_UP,
	right1 = KeyEvent.VK_RIGHT,
	ghost1 = KeyEvent.VK_SPACE,
	action1 = KeyEvent.VK_E,
	restart = KeyEvent.VK_R,
	mute = KeyEvent.VK_M;

	private Control control;

	GameKeys(Control control){
		this.control = control;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Player player = control.getPlayer();
		if(control.isIngame()){
			if(e.getKeyCode() == right1) player.setRight(true);
			else if(e.getKeyCode() == left1) player.setLeft(true);
			else if(e.getKeyCode() == jump1) player.setJump(true);
			else if(e.getKeyCode() == action1) player.setAction(true);
			else if(e.getKeyCode() == ghost1) control.ghost();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Player player = control.getPlayer();
		if(control.isIngame()){
			if(e.getKeyCode() == right1) player.setRight(false);
			else if(e.getKeyCode() == left1) player.setLeft(false);
			else if(e.getKeyCode() == jump1) player.setJump(false);
			else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) control.pauseGame();
			else if(e.getKeyCode() == restart) control.restartCurrentLvl();
		}else if(!control.isPaused()){
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
				control.stopCredits();
				control.getAudio().setMusic(false, false);
			}
		}
		if(e.getKeyCode() == mute) control.getAudio().mute();
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * The getters and setters for the Keys will be used by the Menu that configures the GameKeys.
	 */
	public void setLeft1(int left1) {
		this.left1 = left1;
	}

	public void setRight1(int right1) {
		this.right1 = right1;
	}

	public void setJump1(int jump1) {
		this.jump1 = jump1;
	}

	public void setGhost1(int ghost1) {
		this.ghost1 = ghost1;
	}

	public void setAction1(int action1) {
		this.action1 = action1;
	}

	public int getRight1() {
		return right1;
	}

	public int getLeft1() {
		return left1;
	}

	public int getAction1() {
		return action1;
	}

	public int getGhost1() {
		return ghost1;
	}

	public int getJump1() {
		return jump1;
	}
	
	public int getRestart() {
		return restart;
	}
	
	public void setRestart(int restart) {
		this.restart = restart;
	}
	
	public int getMute() {
		return mute;
	}
	
	public void setMute(int mute) {
		this.mute = mute;
	}

}
