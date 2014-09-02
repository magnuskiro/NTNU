package game;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VictoryScreen extends JPanel{

	JLabel title, seconds, usedGhosts, level;
	public VictoryScreen() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.title = new JLabel("Victory!");
		this.title.setFont(new Font("Victory!", Font.BOLD, 24));
		this.title.setAlignmentX(CENTER_ALIGNMENT);
	
		this.seconds = new JLabel("Seconds used: ");
		this.usedGhosts = new JLabel("Number of 'Ghosts' used: ");
		this.level = new JLabel("Level defeated");
		
		this.seconds.setFont(new Font("Victory!", Font.PLAIN, 18));
		this.usedGhosts.setFont(new Font("Victory!", Font.PLAIN, 18));
		this.level.setFont(new Font("Victory!", Font.PLAIN, 18));
		
		this.seconds.setAlignmentX(CENTER_ALIGNMENT);
		this.usedGhosts.setAlignmentX(CENTER_ALIGNMENT);
		this.level.setAlignmentX(CENTER_ALIGNMENT);
		
		this.add(Box.createVerticalStrut(50));
		this.add(this.title);
		this.add(Box.createVerticalStrut(25));
		this.add(this.level);
		this.add(Box.createVerticalStrut(10));
		this.add(this.seconds);
		this.add(Box.createVerticalStrut(10));
		this.add(this.usedGhosts);
	}
	public void updateText(int seconds, int usedGhosts, int currentLevel){
		this.seconds.setText("Seconds used: " + seconds);		
		this.usedGhosts.setText("Number of 'Ghosts' used: " + usedGhosts);
		this.level.setText("Level " + currentLevel + " defeated!");
		this.validate();
	}

}
