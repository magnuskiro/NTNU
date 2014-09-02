package game;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * 
 * @author Boba Fett
 * <p>
 *This is the general menu which all menus should inherit from. This object has only defined one button
 *which is the button that brings you back to the game screen, this button could be called anything from
 *'resume' to 'New Game', but every menu needs this button
 */
@SuppressWarnings("serial")
public class GeneralMenu extends JPanel implements ActionListener {
	//This panel is the main panel where we can switch Panels
	protected JPanel mainPanel;
	protected JButton startGame;
	public GeneralMenu(JPanel main, String startGameButtonName, String startGameButtonToolTip){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.mainPanel = main;
		this.startGame = new JButton(startGameButtonName);
		this.startGame.setActionCommand("resume");
		this.startGame.setToolTipText(startGameButtonToolTip);
		this.startGame.addActionListener(this);
		
	}
	protected JButton createButton(String name, String toolTip, String actionCommand, int fontSize, int fontType, float xAlignment, float yAlignment){
		JButton newButton = new JButton(name);
		newButton.setToolTipText(toolTip);
		newButton.setActionCommand(actionCommand);
		newButton.addActionListener(this);
		newButton.setFont(new Font("Serif", fontType, fontSize));
		newButton.setAlignmentX(xAlignment);
		newButton.setAlignmentY(yAlignment);
		return newButton;
	}
	/**
	 * This method checks wheter or not a button has been pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if("resume".equals(e.getActionCommand())){
			CardLayout cl = (CardLayout) mainPanel.getLayout();
			cl.show(mainPanel, "game");
		}

	}

}
