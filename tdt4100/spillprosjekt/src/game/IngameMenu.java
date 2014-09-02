package game;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IngameMenu extends GeneralMenu {

	protected JLabel title;
	protected JButton option, quitToMain, highscore;
	protected Control control;
	protected JPanel main;
	
	public IngameMenu(JPanel main, Control control) {
		super(main, "Resume", "Resume the game");
		this.control = control;
		this.main = main;
		
		super.startGame.setAlignmentX(CENTER_ALIGNMENT);
		super.startGame.setAlignmentY(CENTER_ALIGNMENT);
		super.startGame.setFont(new Font("Serif", Font.PLAIN, 16));	
		
		title = new JLabel("Paused");
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setAlignmentY(CENTER_ALIGNMENT);
		title.setFont(new Font("Serif", Font.BOLD, 20));
		
		highscore = new JButton("Highscore");
		highscore.setActionCommand("highscore");
		highscore.addActionListener(this);
		highscore.setToolTipText("View the global or local highscore list, fresh of the interwebs");
		highscore.setAlignmentX(CENTER_ALIGNMENT);
		highscore.setAlignmentY(CENTER_ALIGNMENT);
		highscore.setFont(new Font("Serif", Font.PLAIN, 16));
		
		option = new JButton("Options");
		option.setActionCommand("option");
		option.addActionListener(this);
		option.setToolTipText("Change various options");
		option.setAlignmentX(CENTER_ALIGNMENT);
		option.setAlignmentY(CENTER_ALIGNMENT);
		option.setFont(new Font("Serif", Font.PLAIN, 16));
		
		quitToMain = new JButton("Quit to menu");
		quitToMain.setActionCommand("quit");
		quitToMain.addActionListener(this);
		quitToMain.setToolTipText("Quit to the main menu");
		quitToMain.setAlignmentX(CENTER_ALIGNMENT);
		quitToMain.setAlignmentY(CENTER_ALIGNMENT);
		quitToMain.setFont(new Font("Serif", Font.PLAIN, 16));
		
		this.add(Box.createVerticalStrut(50));
		this.add(title);
		this.add(Box.createVerticalStrut(35));
		this.add(super.startGame);
		this.add(super.createButton("Restart", "Restart current level", "restart", 16, Font.PLAIN, CENTER_ALIGNMENT, CENTER_ALIGNMENT));
		this.add(option);
		this.add(highscore);
		this.add(Box.createVerticalStrut(30));
		this.add(quitToMain);
	}
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) mainPanel.getLayout();
		if("resume".equals(e.getActionCommand())){
			cl.show(main, "game");
			control.requestFocus();
			control.setIngame(true);
			control.setPaused(false);
		}else if("option".equals(e.getActionCommand())){
			control.updateOption();
			cl.show(main, "option");
		}else if("restart".equals(e.getActionCommand())){
			control.restartCurrentLvl();
		}else if("quit".equals(e.getActionCommand())){
			int answer = new JOptionPane().showConfirmDialog(control, "Do you really want to quit?\n" +
					"Progress on this level will be lost!", "Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(answer == JOptionPane.YES_OPTION){
				cl.show(main, "mainmenu");
				control.setIngame(false);
				control.setPaused(false);
				control.endGame();
			}
		}else if("highscore".equals(e.getActionCommand())){
			cl.show(main, "selectlocal");
		}
	}

}
