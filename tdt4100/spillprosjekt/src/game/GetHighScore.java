package game;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GetHighScore extends SelectLevelMenu {

	private SelectLocal local;
	private HighscoreList show;
	
	public GetHighScore(ArrayList<Level> levels, Control control, JPanel main, SelectLocal local, HighscoreList show) {
		super(levels, control, main);
		this.local = local;
		this.show = show;
		super.title.setText("Select a level to get highscore from:");
		super.custom.setVisible(false);
		super.custom.setEnabled(false);
		updateEnabled();
	}
	@Override
	public void updateEnabled(){
		for(JButton btn : super.buttons){
			btn.setEnabled(true);
		}
	}
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout)control.getMainPanel().getLayout();
		if("back".equals(e.getActionCommand())){
			cl.show(mainPanel, "selectlocal");
		}else if(Integer.parseInt(e.getActionCommand()) >= 0 && Integer.parseInt(e.getActionCommand()) <= levels.size()){
			if(show != null){
				show.showHighscore(Integer.parseInt(e.getActionCommand()), !local.getLocal());
			}
		}
	}
}
