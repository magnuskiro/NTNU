package game;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SelectLevelMenu extends JPanel implements ActionListener{

	protected JButton back, custom;
	protected ArrayList<Level> levels;
	protected ArrayList<JButton> buttons;
	protected JPanel mainPanel;
	protected Control control;
	protected JPanel buttonLayout;
	protected JLabel title;
	
	public SelectLevelMenu(ArrayList<Level> levels, Control control, JPanel main) {
		this.control = control;
		this.levels = levels;
		this.mainPanel = main;
		this.buttons = new ArrayList<JButton>();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		GridBagConstraints c = new GridBagConstraints();
		int line = 0;
		back = createButton("Back", "Go back to main menu", "back", 14, Font.PLAIN, CENTER_ALIGNMENT, BOTTOM_ALIGNMENT);
		custom = createButton("Custom", "Go to the custom level select menu", "custom", 14, Font.BOLD, CENTER_ALIGNMENT, BOTTOM_ALIGNMENT);

		title = new JLabel("Select a level:");
		title.setFont(new Font("Serif", Font.BOLD, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setAlignmentY(TOP_ALIGNMENT);
		
		this.add(Box.createVerticalStrut(75));
		this.add(title);
		this.add(Box.createVerticalStrut(15));
		buttonLayout = new JPanel(new GridBagLayout());
		buttonLayout.setAlignmentX(CENTER_ALIGNMENT);
		buttonLayout.setAlignmentY(CENTER_ALIGNMENT);
		c.insets = new Insets(2, 2, 2, 2);
		c.gridy = line++;
		int grid = 0;
		int number = 1;
		c.fill = GridBagConstraints.NONE;
		for(Level lvl : levels){
			c.gridx = grid;
			grid ++;
			buttonLayout.add(makeButton(lvl.getLevelnumber(), lvl.isActive()), c);
			if(number % 5 == 0){
				c.gridy = line++;
				grid = 0;
			}
			number ++;
		}
		this.add(buttonLayout);
		this.add(Box.createVerticalStrut(15));
		this.add(custom);
		this.add(Box.createVerticalStrut(15));
		this.add(back);
		this.updateEnabled();
	}
	protected JButton makeButton(int number, boolean active){
		JButton newButton = new JButton(number + "");
		newButton.setActionCommand(number + "");
		newButton.setFont(new Font("Serif", Font.BOLD, 14));
		newButton.setToolTipText("Select level " + number);
		newButton.addActionListener(this);
		newButton.setEnabled(active);
		newButton.setPreferredSize(new Dimension(60, 60));
		this.buttons.add(newButton);
		return newButton;
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
	public void updateEnabled(){
		for(int i = buttons.size() - 1; i >= 0; i--){
			if(levels.get(i).isActive()){
				for(int k = i; k >= 0; k--){
					buttons.get(k).setEnabled(true);
				}
			}
		}
		this.validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout)control.getMainPanel().getLayout();
		if("back".equals(e.getActionCommand())){
			cl.show(mainPanel, "mainmenu");
		}else if("custom".equals(e.getActionCommand())){
			cl.show(mainPanel, "customlevel");
		}else if(Integer.parseInt(e.getActionCommand()) >= 0 && Integer.parseInt(e.getActionCommand()) <= levels.size()){
			cl.show(mainPanel, "game");
			control.newGame(Integer.parseInt(e.getActionCommand()), 'o');
		}
	}
}
