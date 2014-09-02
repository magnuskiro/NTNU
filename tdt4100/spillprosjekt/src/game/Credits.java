package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Credits extends JPanel implements Runnable {

	private Control control;
	private boolean play;
	private int current;
	private Graphics2D g2d;
	private String[][] titles = {{"Team:"}, {"Lead developer:"}, {"Internet connectivity:"}, {"Level design:"}, {"Things that have been","declared war on:"}, {"Thanks to the following for invaluable","lessons on being a team"},{"Team team team team..."}};
	private String[][] content = {{"- Mikkel Antonsen", "- Magnus Kirø", "- Jørgen Nordmoen", "- Ola Martin Støvneng"},{"Ola Martin Støvneng"},
			{"Mikkel Antonsen"},{"Magnus Kirø"},{"-Scrollie", "-Stress"},{"- Denholm Reynholm","- The new justice team","- A-Team"},{""}};
	public Credits(Control control){
		this.control = control;
	}
	public void play(boolean play){
		this.play = play;
		this.g2d = (Graphics2D)control.getBf().getDrawGraphics();
		this.g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		Thread db = new Thread(this);
		db.start();
	}
	public void run(){
		while(play){
			intro();
			control.sleep(2000);
			outtro();
		}
	}
	public void setPlay(boolean value){
		this.play = value;
	}
	protected void intro(){
		for(int i = 0; i < 255; i += 4){
			if(play){
				g2d.clearRect(0, 0, 1280, 720);
				g2d.setColor(new Color(0, 0, 0, i));
				g2d.setFont(new Font("Credits", Font.BOLD, 32));
				for(int j = 0; j < titles[current].length; j++){
					g2d.drawString(titles[current][j], 1280/2 - (150 + (i/10) + titles[current][j].length()*2), (720/2 - (titles[current].length > 1 ? 120 : 90 )) + 30*j);
				}
				g2d.setFont(new Font("Credits", Font.PLAIN, 30));
				for(int k = 0; k < content[current].length; k++){
					g2d.drawString(content[current][k], 1280/2 - 135 - (i/10), (720/2 - 40) + 30*k);
				}
				control.getBf().show();
				Toolkit.getDefaultToolkit().sync();
				control.sleep(25);
			}
		}
		//g2d.dispose();
	}
	protected void outtro(){
		for(int i = 255; i >= 0; i -= 7){
			if(play){
				g2d.setColor(new Color(0, 0, 0, i));
				g2d.setFont(new Font("Credits", Font.BOLD, 32));
				for(int j = 0; j < titles[current].length; j++){
					g2d.drawString(titles[current][j], 1280/2 - (150 + (252/10) + titles[current][j].length()*2), (720/2 - (titles[current].length > 1 ? 120 : 90 )) + 30*j);
				}
				g2d.setFont(new Font("Credits", Font.PLAIN, 30));
				for(int k = 0; k < content[current].length; k++){
					g2d.drawString(content[current][k], 1280/2 - 135 - (252/10), (720/2 - 40) + 30*k);
				}
				control.getBf().show();
				Toolkit.getDefaultToolkit().sync();
				control.sleep(25);
				g2d.clearRect(0, 0, 1280, 720);
			}
		}
		//g2d.dispose();
		if((current + 1) < titles.length){
			current ++;
		}else{
			current = 0;
		}
	}

}
