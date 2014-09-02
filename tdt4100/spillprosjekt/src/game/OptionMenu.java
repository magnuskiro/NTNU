package game;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class OptionMenu extends JPanel implements ActionListener, ItemListener{
	protected JPanel mainPanel;
	protected JButton left, right, jump, action, ghost, back, muteButton, restart;
	protected JCheckBox mute, fps;
	protected JLabel title;
	protected Control control;
	protected GameKeys listener;

	public OptionMenu(JPanel main, Control control, GameKeys gk){
		this.mainPanel = main;
		this.control = control;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		listener = gk;

		left = new JButton();
		right = new JButton();
		jump = new JButton();
		action = new JButton();
		ghost = new JButton();
		back = new JButton();
		muteButton = new JButton();
		restart = new JButton();

		JButton[] buttons = {left, right, jump, action, ghost, back, muteButton, restart};
		String[] actionCommand = {"left", "right","jump", "action", "ghost", "back", "mute", "restart"};
		String[] toolTips = {"Set the 'Left' key","Set the 'Right' key","Set the 'Jump' key","Set the 'Action' key",
				"Set the 'Ghost' key", "Go back to previous menu", "Set the 'Mute' key", "Set the 'Restart' key"};

		title = new JLabel("Option Menu:");
		title.setFont(new Font("Serif", Font.BOLD, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setAlignmentY(CENTER_ALIGNMENT);
		title.setToolTipText("Here you can set the variouse control keys");

		mute = new JCheckBox("Mute Sound");
		mute.addItemListener(this);

		fps = new JCheckBox("Show FPS");
		fps.setSelected(false);
		fps.addItemListener(this);

		for (int i = 0; i < toolTips.length; i++) {
			buttons[i].setActionCommand(actionCommand[i]);
			buttons[i].setToolTipText(toolTips[i]);
			buttons[i].addActionListener(this);
			buttons[i].setFont(new Font("bob", Font.BOLD, 14));
			buttons[i].setPreferredSize(new Dimension(75, 35));
		}
		update();
		back.setText("Back");
		back.setFont(new Font("bob", Font.PLAIN, 14));

		this.add(Box.createVerticalStrut(30));
		this.add(title);
		this.add(Box.createVerticalStrut(20));
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 4;
		pan1.add(new JLabel("'Go Left' key:"), c);
		pan1.add(left, c);
		pan1.add(new JLabel("'Go Right' key:"), c);
		c.gridwidth = GridBagConstraints.REMAINDER;
		pan1.add(right, c);
		c.gridwidth = 4;
		pan1.add(new JLabel("'Jump' key:"), c);
		pan1.add(jump, c);
		pan1.add(new JLabel("'Action' key:"), c);
		c.gridwidth = GridBagConstraints.REMAINDER;
		pan1.add(action, c);
		c.gridwidth = 4;
		pan1.add(new JLabel("'Mute' key:"), c);
		pan1.add(muteButton, c);
		pan1.add(new JLabel("'Restart' key:"), c);
		c.gridwidth = GridBagConstraints.REMAINDER;
		pan1.add(restart, c);
		c.gridwidth = 2;
		pan1.add(new JLabel("'Ghost' key:"), c);
		c.gridwidth = GridBagConstraints.REMAINDER;
		pan1.add(ghost, c);

		this.add(pan1);
		this.add(fps);
		this.add(mute);
		this.add(Box.createVerticalStrut(40));
		this.add(back);
	}
	public void update(){
		this.left.setText(KeyEvent.getKeyText(listener.getLeft1()));
		this.left.setToolTipText(left.getText());
		this.right.setText(KeyEvent.getKeyText(listener.getRight1()));
		this.right.setToolTipText(right.getText());
		this.jump.setText(KeyEvent.getKeyText(listener.getJump1()));
		this.jump.setToolTipText(jump.getText());
		this.ghost.setText(KeyEvent.getKeyText(listener.getGhost1()));
		this.ghost.setToolTipText(ghost.getText());
		this.action.setText(KeyEvent.getKeyText(listener.getAction1()));
		this.action.setToolTipText(action.getText());
		this.muteButton.setText(KeyEvent.getKeyText(listener.getMute()));
		this.muteButton.setToolTipText(muteButton.getText());
		this.restart.setText(KeyEvent.getKeyText(listener.getRestart()));
		this.restart.setToolTipText(restart.getText());
		this.mute.setSelected(control.getAudio().muted());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) mainPanel.getLayout();
		if("left".equals(e.getActionCommand())){
			new GetKeyDialog(this, listener,listener.getLeft1(), 'l');
		}else if("right".equals(e.getActionCommand())){
			new GetKeyDialog(this, listener,listener.getLeft1(), 'r');

		}else if("jump".equals(e.getActionCommand())){
			new GetKeyDialog(this, listener,listener.getLeft1(), 'j');

		}else if("action".equals(e.getActionCommand())){
			new GetKeyDialog(this, listener,listener.getLeft1(), 'a');

		}else if("ghost".equals(e.getActionCommand())){
			new GetKeyDialog(this, listener,listener.getLeft1(), 'g');

		}else if("mute".equals(e.getActionCommand())){
			new GetKeyDialog(this, listener, listener.getMute(), 'm');

		}else if("restart".equals(e.getActionCommand())){
			new GetKeyDialog(this, listener, listener.getRestart(), 's');
			
		}else if("back".equals(e.getActionCommand())){
			if(control.isPaused()){
				cl.show(mainPanel, "ingamemenu");
			}else{
				cl.show(mainPanel, "mainmenu");
			}
		}

	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		if(source == mute){
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				System.out.println("Unmuting");
				control.getAudio().mute(false);
			}else{
				control.getAudio().mute(true);
				System.out.println("Muting!");
			}
		}else if(source == fps){
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				System.out.println("Not showing FPS");
				control.setShowFPS(false);
			}else{
				control.setShowFPS(true);
				System.out.println("Showing FPS");
			}
		}

	}

}
