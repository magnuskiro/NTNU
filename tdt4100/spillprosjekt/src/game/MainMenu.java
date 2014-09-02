package game;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MainMenu extends GeneralMenu {
	protected JButton contin, option, credits, avslutt, highscore;
	protected JLabel title;
	protected Control control;
	
	public MainMenu(JPanel main, Control control) {
		super(main, "New Game", "Start a new game");
		this.control = control;
		super.startGame.setAlignmentX(CENTER_ALIGNMENT);
		super.startGame.setAlignmentY(CENTER_ALIGNMENT);
		super.startGame.setFont(new Font("Serif", Font.PLAIN, 16));		
		
		title = new JLabel("*Working Title*");
		title.setFont(new Font("Serif", Font.BOLD, 24));
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setAlignmentY(CENTER_ALIGNMENT);
		title.setToolTipText("The title of this beautiful and moving game, the winner of several international awards, including 'Best game evar!'");
		
		String[] buttons = {"Highscore", "Options", "Credits", "Quit"};
		String[] toolTips = {"View the global or local highscore list, fresh of the interwebs", "Changes options", "View the contributers to this project"
				,"Exit the program"};
		String[] actions = {"highscore", "option", "credits", "exit"};
		
		this.add(Box.createVerticalStrut(50));
		this.add(title);
		this.add(Box.createVerticalStrut(55));
		this.add(super.startGame);
		
		for (int i = 0; i < actions.length; i++) {
			this.add(super.createButton(buttons[i], toolTips[i], actions[i], 16, Font.PLAIN, CENTER_ALIGNMENT, CENTER_ALIGNMENT));
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) mainPanel.getLayout();
		if("resume".equals(e.getActionCommand())){
			control.selectLevelMenu().updateEnabled();
			cl.show(mainPanel, "selectlevel");
			control.selectLevelMenu().updateEnabled();
		}else if("option".equals(e.getActionCommand())){
			control.updateOption();
			cl.show(mainPanel, "option");
		}else if("credits".equals(e.getActionCommand())){
			control.getCredits().play(true);
			control.getAudio().setMusic(false, true);
			cl.show(mainPanel, "credits");
		}else if("highscore".equals(e.getActionCommand())){
			cl.show(mainPanel, "selectlocal");
		}else if("exit".equals(e.getActionCommand())){
			control.quit();
		}

	}

}
