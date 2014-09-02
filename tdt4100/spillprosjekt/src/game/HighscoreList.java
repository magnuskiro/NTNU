package game;

import java.awt.Dimension;
import java.io.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;*/


@SuppressWarnings("serial")
public class HighscoreList extends JPanel{

	private Connection db;
	private Statement st;
	private List<Score> highscoreList = new ArrayList<Score>();
	private final String userName = "mikkela_mike";
	private final String password = "pfhsl";
	private final String url = "jdbc:mysql://mysql.stud.ntnu.no/mikkela_highscore";
	private final int x,y;
	private String defaultName;

	/**
	 * 
	 * @throws IOException
	 */
	HighscoreList(int x, int y) throws IOException {
		this.x = x;
		this.y = y;
		this.defaultName = "Defaultplayer";
	}

	/**
	 * Writes the score into the file scores.txt on this format "Player_name time_used ghosts_used"
	 * It is written using an instance of bufferedWriter made in the constructor.
	 * @param timeUsed Represents the time it took the player to clear the map
	 * @param ghostsUsed Represents the number of ghosts the player used to clear the map
	 * @param playerName The name of the player :O
	 * @throws IOException
	 */
	public void addScore(int timeUsed, int ghostsUsed,  int level) throws IOException {

		String playerName = getPlayerName();
		if(playerName != null){
			Score newScore = new Score(timeUsed, ghostsUsed, playerName, level);
			String kommando = "INSERT INTO highscore (tid, playername, ghostsUsed, level, score) VALUES ("+timeUsed+", "+"\'"+playerName+"\'"+", "+ghostsUsed+", " + level + ", " + newScore.calculateScore()+");";

			switch(JOptionPane.showConfirmDialog(null, "Do you want to upload your score to the internets?", "highscore", JOptionPane.YES_NO_OPTION)){
			case 0: pushScoreToDatabase(kommando); pushScoreToFile(newScore); break;
			default: pushScoreToFile(newScore); break;
			}
		}
	}


	private String getPlayerName() {
		boolean continueSearch = true;
		String playerName;
		do{
			playerName = JOptionPane.showInputDialog("What is your name?", defaultName);
			if(playerName != null){
				if(playerName.matches("[a-zA-Z_0-9]*")){
					continueSearch = false;
					defaultName = playerName;
				}
			}
			if(continueSearch){
				JOptionPane.showMessageDialog(this, "Your name was invalid.\nOnly lettes from A to z and numbers are allowed", "Invalid name", JOptionPane.INFORMATION_MESSAGE);
			}
		}while(continueSearch && playerName != null);
		return playerName;
	}


	private void pushScoreToDatabase(String kommando){
		if(connectToServer()){
			try{
				st.executeUpdate(kommando);
			}
			catch(Exception SQL){
				System.err.println(SQL.getLocalizedMessage());
			}
		}
	}

	private boolean connectToServer() {

		try
		{
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			this.db = DriverManager.getConnection(this.url, this.userName, this.password);
			this.st = db.createStatement();

			return true;
		}
		catch (Exception SQL)
		{	
			JOptionPane.showMessageDialog(null, "Connection to database could not be established, all scores will be saved locally");
			System.err.println(SQL.getLocalizedMessage());
			return false;
		}
	}

	private void pushScoreToFile(Score newScore) throws IOException{
		highscoreList.add(newScore);
		importLocalScoresToArray();

		FileWriter fr = new FileWriter("scores.txt");
		BufferedWriter br = new BufferedWriter(fr);

		for (int i = 0; i < highscoreList.size(); i++) {
			br.write(highscoreList.get(i).toString());
			br.newLine();
		}

		br.close();
		highscoreList.clear();
	}

	private void importDatabaseScoresToArray(int level){
		this.highscoreList.clear();
		if(connectToServer()){
			try {
				this.st.execute("SELECT tid, playerName, GhostsUsed, level FROM highscore where level = "+ level +";");
				ResultSet rs = st.getResultSet();
				while (rs.next())
				{
					highscoreList.add(stringToScoreObject(rs.getInt("tid") + " " + rs.getInt("ghostsUsed") + " " + rs.getString("playerName") +  " " + rs.getInt("level")) );
				}
			} catch (SQLException e) {
				System.err.println("Error: Could not fetch highscores from database");
			}
		}
	}

	private void importLocalScoresToArray(){
		try{
			FileReader fr = new FileReader("scores.txt");
			BufferedReader br = new BufferedReader(fr);

			String textFromFile = br.readLine();
			while(textFromFile != null) {
				highscoreList.add(stringToScoreObject(textFromFile));
				textFromFile = br.readLine();
			}

		} catch(Exception IO){
			System.err.println(IO.getLocalizedMessage());
		}
	}

	private Score stringToScoreObject(String inString){
		String[] tempArray = inString.split(" ");
		return new Score(Integer.parseInt(tempArray[0]), Integer.parseInt(tempArray[1]), tempArray[2], Integer.parseInt(tempArray[3]));
	}

	@SuppressWarnings("unchecked")
	public void showHighscore(int level, boolean showDatabaseHighscore){

		if(showDatabaseHighscore){
			importDatabaseScoresToArray(level);
		} else {
			importLocalScoresToArray();
		}
		Collections.sort(highscoreList);

		String[][] scoreString = new String[highscoreList.size()][5];
		int teller = 0;
		if(highscoreList.size() > 0){
			for (Score score : highscoreList) {
				if(score.getLevel() == level){
					scoreString[teller][0] = ""+(teller+1);
					scoreString[teller][1] = "" + score.getScore();
					scoreString[teller][2] = titleCase(score.getPlayerName());
					scoreString[teller][3] = "" + score.getTimeUsed();
					scoreString[teller][4] = "" + score.getGhostsUsed();
					teller++;
				}
			}
		} else {
			System.err.println("Error: Could not find any highscores to be displayed");
		}

		String[] columnNames = {"Placement","Score","Playername", "Time", "Ghosts used"};
		DefaultTableModel deftable = new DefaultTableModel(columnNames, 0);
		JFrame frame = new JFrame();
		frame.setLocation(this.x-325, this.y-150);
		frame.setTitle("Highscore for level #" + level);
		frame.setVisible(true);
		JTable table = new JTable(deftable);
		table.setAutoCreateRowSorter(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(650, 300));
		frame.add(scroll);
		frame.pack();

		ArrayList<String> playerNames = new ArrayList<String>();

		int placement = 0;
		for (int i = 0; i < scoreString.length; i++) {
			if(!playerNames.contains(scoreString[i][2])){
				placement ++;
				scoreString[i][0] = placement + "";
				deftable.addRow(scoreString[i]);
				playerNames.add(scoreString[i][2]);
			}
		}
		playerNames.clear();
		highscoreList.clear();	
	}

	private String titleCase(String playerName) {
		playerName = playerName.toLowerCase();
		String temp = Character.toTitleCase(playerName.charAt(0))+"";
		temp += playerName.subSequence(1, playerName.length());
		return temp;
	}
}


