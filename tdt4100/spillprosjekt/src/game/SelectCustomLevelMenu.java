package game;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class SelectCustomLevelMenu extends SelectLevelMenu {

	protected ImportLevel levelImporter;
	protected JFrame frame;
	public SelectCustomLevelMenu(ArrayList<Level> levels, Control control, JPanel main, ImportLevel level) {
		super(levels, control, main);
		this.levelImporter = level;
		super.title.setText("Select Custom Level");
		super.custom.setText("Read custom levels");
		updateEnabled();
	}
	@Override
	public void updateEnabled(){
		for(JButton btn : super.buttons){
			btn.setEnabled(true);
		}
	}
	protected void updateButtons(){
		this.buttons.clear();
		this.buttonLayout = new JPanel(new GridBagLayout());
		this.levels = levelImporter.getCustomLevels();
		buttonLayout.setAlignmentX(CENTER_ALIGNMENT);
		buttonLayout.setAlignmentY(CENTER_ALIGNMENT);
		GridBagConstraints c = new GridBagConstraints();
		int length = (levels.size() > 20) ? 20 : levels.size(); 
		int line = 0;
		c.insets = new Insets(2, 2, 2, 2);
		c.gridy = line++;
		int grid = 0;
		int number = 1;
		c.fill = GridBagConstraints.NONE;
		for(int i = 0; i < length; i++){
			c.gridx = grid;
			grid ++;
			buttonLayout.add(super.makeButton(i + 1, true), c);
			if(number % 5 == 0){
				c.gridy = line++;
				grid = 0;
			}
			number ++;
		}
		this.removeAll();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createVerticalStrut(75));
		this.add(title);
		this.add(Box.createVerticalStrut(15));
		this.add(this.buttonLayout);
		if(levels.size() > 20){
			this.add(super.createButton("More", "See the rest of the custom levels", "more", 14, Font.BOLD, CENTER_ALIGNMENT, CENTER_ALIGNMENT), c);			
		}
		this.add(Box.createVerticalStrut(15));
		this.add(custom);
		this.add(Box.createVerticalStrut(15));
		this.add(back);
		this.validate();
		this.requestFocus();
	}
	protected void makeMore(){
		frame = new JFrame("Custom levels");
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JScrollPane scrolli = new JScrollPane(panel);
		scrolli.setPreferredSize(new Dimension(400, 350));
		int grid = 0;
		int number = 1;
		int line = 0;
		c.gridy = line;
		for(int i = 20; i < levels.size(); i++){
			c.gridx = grid;
			grid ++;
			panel.add(super.makeButton(i + 1, true), c);
			if(number % 6 == 0){
				c.gridy = ++line;
				grid = 0;
			}
			number ++;
		}
		frame.add(scrolli);
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout)control.getMainPanel().getLayout();
		if("back".equals(e.getActionCommand())){
			cl.show(mainPanel, "selectlevel");
		}else if("custom".equals(e.getActionCommand())){
			String path = JOptionPane.showInputDialog(control,"Path or webaddress for cutom levels:");
			if(path != null){
				levelImporter.importCustomlevels(path.trim());
				updateButtons();
				//makeMore();
			}
		}else if("more".equals(e.getActionCommand())){
			if(frame == null){
				makeMore();
			}else{
				frame.setVisible(true);
			}
		}else if(Integer.parseInt(e.getActionCommand()) >= 0 && Integer.parseInt(e.getActionCommand()) <= levels.size()){
			if(frame != null) frame.setVisible(!frame.isVisible());
			cl.show(mainPanel, "game");
			control.newGame(Integer.parseInt(e.getActionCommand()), 'c');
		}
	}

}
