package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GetKeyPanel extends JPanel implements KeyListener{

	protected JLabel label;
	private int value;
	
	public GetKeyPanel(int value){
		label = new JLabel("Press a key");
		this.add(label);
		this.value = value;
		this.addKeyListener(this);
		label.addKeyListener(this);
		this.setFocusable(true);
	}
	
	public int getValue(){
		return value;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		label.setText("You pressed: " + KeyEvent.getKeyText(arg0.getKeyCode()) + " is this right?");
		value = arg0.getKeyCode();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	
}
