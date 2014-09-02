package game;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SelectLocal extends JPanel implements ActionListener {
	private JLabel title;
	private Control control;
	private JPanel mainPanel;
	private boolean local;
	public SelectLocal(JPanel main, Control control){
		this.control = control;
		this.mainPanel = main;
		local = true;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		title = new JLabel("Select Local or Internet");
		title.setFont(new Font("bob", Font.BOLD, 22));
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setAlignmentY(TOP_ALIGNMENT);
		this.add(Box.createVerticalStrut(20));
		this.add(title);
		this.add(Box.createVerticalStrut(20));
		
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(2, 2, 2, 2);
		JPanel layout = new JPanel(new GridBagLayout());
		layout.add(createButton("Local", "View local highscore", "local", 14, Font.BOLD, CENTER_ALIGNMENT, CENTER_ALIGNMENT), c);
		layout.add(createButton("Internet", "View internet highscore", "internet", 14, Font.BOLD, CENTER_ALIGNMENT, CENTER_ALIGNMENT), c);
		
		this.add(layout);
		this.add(Box.createVerticalStrut(20));
		this.add(createButton("Back", "Go back to the main menu", "back", 14, Font.PLAIN, CENTER_ALIGNMENT, CENTER_ALIGNMENT));
		
	}
	public boolean getLocal(){
		return this.local;
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
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout)mainPanel.getLayout();
		if("local".equals(e.getActionCommand())){
			this.local = true;
			cl.show(mainPanel, "gethighscore");
		}else if("internet".equals(e.getActionCommand())){
			this.local = false;
			cl.show(mainPanel, "gethighscore");
		}else if("back".equals(e.getActionCommand())){
			if(control.isPaused()){
				cl.show(mainPanel, "ingamemenu");
			}else{
				cl.show(mainPanel, "mainmenu");
			}
		}
		
	}
}
