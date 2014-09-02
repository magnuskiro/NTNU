package game;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.*;
import java.net.URL;
import javax.swing.JOptionPane;

public class ImportLevel {
	private ArrayList<Level> levels = new ArrayList<Level>();
	private ArrayList<Level> customlevels = new ArrayList<Level>(); 
	private ArrayList<Door> doors = new ArrayList<Door>();
	private ArrayList<Switch> switches = new ArrayList<Switch>(); 
	//This is used to position JOptionPanes that are created here
	private Control control;

	public ImportLevel(Control control) {
		this.control = control;
		readLevelsFromFile(null, false);
	}
	public void importCustomlevels(String newfilename){ 
		this.customlevels.clear();
		readLevelsFromFile(newfilename, true); 
	}
	public void readLevelsFromFile(String newfilename, boolean custom){
		BufferedReader bis; 		
		String temp;  
		int y, x, wx, playerx=0, playery=0;

		try {
			if(newfilename!=null){ // if newfilename not set, use default.
				if(custom) System.out.println("Reading Customlevels");
				if(newfilename.contains("www")||newfilename.contains("http")){
					URL url = new URL(newfilename); 
					bis = new BufferedReader(new InputStreamReader(url.openStream())); 					
				}else{
					File file = new File(newfilename); 
					bis = new BufferedReader(new FileReader(file)); 
				}
			}else{
				//File file = new File("resources/levels");
				//bis = new BufferedReader(new FileReader(file)); 
				//reding levels from jar-file
				InputStream is = ClassLoader.getSystemResourceAsStream("resources/levels");
				bis = new BufferedReader(new InputStreamReader(is));
			}

			temp = bis.readLine(); 
			Static_Object tempSO; 
			Level tempLevel;
			Movable_Object tempMO; 
			String[] signText = new String[3]; 

			while(temp != null){
				//if start level (!--)
				if(temp.contains("!--")){
					playerx=0; 
					playery=0; 
					tempLevel = new Level();
					if(custom){
						customlevels.add(tempLevel);
					}else{
						levels.add(tempLevel);
					}
					y=1; //subtract the number of lines befor the level objects
					int id; 

					temp = bis.readLine();
					//reads the level number from levels, and adds it to the current level.
					if(temp.contains("nr:")){
						int levelnumber = Integer.parseInt(temp.substring(3, temp.length())); 
						tempLevel.setLevelnumber(levelnumber);
						temp = bis.readLine();
					}
					//reads the level code from levels and adds it to the current level. 
					if(temp.contains("code:")){
						String levelcode = temp.substring(5, temp.length());
						tempLevel.setLevelcode(levelcode); 
						tempLevel.setActive(true); // This should be set other where, but for now, its here
						temp = bis.readLine();
					} 

					//set active.
					for(int dx=0; dx<=2; dx++){
						String st = temp.substring(6, temp.length());
						signText[dx] = st;  
						temp = bis.readLine(); 
					}

					//start read a level
					while(!temp.contains("--!")){
						//System.out.println(temp);  //testing output
						x=0;
						wx=0; 
						for(char c:temp.toCharArray()){
							switch (c) {
							case '#':
								tempSO = new Wall(new Rectangle2D.Double(wx*20, y*20, 20, 20), Color.BLACK);
								tempLevel.addStatic_Object(tempSO); 
								break;
							case '@':
								playerx = x; 
								playery = y; 
								break;
							case 'B':
								tempMO = new Box(new Rectangle2D.Double(wx*20, y*20, 20, 20));  
								tempLevel.addMovable_Object(tempMO);
								break; 
							case '$':
								Goal goal = new Goal(new Rectangle2D.Double(wx*20, y*20-20, 20, 40)); 
								tempLevel.addMovable_Object(goal);
								tempLevel.setGoal(goal);
								break; 
							case 'S'://switch
								id = (int)(temp.charAt(x+1)) -48;
								Switch switchn = new Switch(new Rectangle2D.Double(wx*20, y*20, 20, 20), id);
								switches.add(switchn);
								tempLevel.addMovable_Object(switchn);
								wx--;
								break;
							case 'D'://door
								id = (int)(temp.charAt(x+1)) -48;
								Door door = new Door(new Rectangle2D.Double(wx*20, y*20, 20, 20), id);
								doors.add(door); 
								tempLevel.addMovable_Object(door);
								wx--; 
								break;
							case 'P'://wall for ghosts
								//Color color = new Color(0, 255, 0, 150);
								Wall_Player_cross wpc = new Wall_Player_cross(new Rectangle2D.Double(wx*20, y*20, 20, 20), Color.GREEN);  
								tempLevel.addStatic_Object(wpc);
								break;
							case 'G'://wall for player
								//color = new Color(255, 0, 0, 150);
								Wall_Ghost_cross wgc = new Wall_Ghost_cross(new Rectangle2D.Double(wx*20, y*20, 20, 20), Color.BLUE); 
								tempLevel.addStatic_Object(wgc);
								break;
							case 'T':
								id = (int)(temp.charAt(x+1)) -48;
								Sign sign = new Sign(new Rectangle2D.Double(wx*20, y*20, 20, 20), signText[id-1]);
								tempLevel.addStatic_Object(sign);
								wx--;
								break;
							default:
								break;
							}//end switch
							x++; 
							wx++; 
						}//end for char in temp string
						y++; 
						temp = bis.readLine();  
					}  
					playerPosition(tempLevel, playerx, playery); 
					//end read a level

					// connect doors and switches. 
					connectDoorSwitch();

					//Clear the doors and switches arraylists.
					doors.clear();
					switches.clear();

					//check if player and goal is present on the level
					goalIsOnLevel(tempLevel, custom);
				}
				temp=bis.readLine(); 
			}//end of file, temp == null
			bis.close();
		}catch(java.io.FileNotFoundException e){
			JOptionPane.showMessageDialog(control, "Could not find specified file:\n'" + newfilename +"'", 
					"File not found", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.out.println(e);
		}
		//Set level active
		setLevelsActive();
		checkActivety(); 
		System.out.println("Boarding completed");
	}
	public void goalIsOnLevel(Level lvl, boolean custom){
		if(lvl.getGoal()==null){
			if(custom){
				customlevels.remove(lvl);
				System.out.println(levels.get(1).getLevelnumber());
				System.out.println("custmlevel " +lvl.getLevelnumber() + " not added");
				return; 
			}else{
				levels.remove(lvl);
				System.out.println(levels.get(1).getLevelnumber());
				System.out.println("level "+lvl.getLevelnumber() +" not added");
				return;
			}
		}
	}
	public void connectDoorSwitch(){
		for(int i = 0;i < switches.size();i++){
			for(int j = 0;j < doors.size();j++){
				if(switches.get(i).getId() == doors.get(j).getId()){
					switches.get(i).addListener(doors.get(j));
				}
			}
		}
	}
	protected void setLevelsActive() {
		String code = readProgress();
		for(Level lvl : levels){
			if(lvl.getLevelcode().equals(code)){
				lvl.setActive(true);
			}else{
				lvl.setActive(false);
			}
		}
	}
	public void checkActivety(){
		for(Level l:levels){
			if(l.isActive()){
				return; 
			}
		}
		System.out.println("No active levels, setting level1 to active");
		levels.get(0).setActive(true); 
	}
	public String readProgress(){
		try {
			File file = new File("progress.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp = br.readLine();
			System.out.println("progress content " + temp);
			if(temp == null || temp.equals("")){
				temp = levels.get(0).getLevelcode();
			}
			br.close();
			return temp; 
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("progress not saved");
			return null; 
		} 
	}
	private void setActive(String levelCode) {
		for(Level lvl:levels){
			if(lvl.getLevelcode().equals(levelCode)){
				lvl.setActive(true);
				return;
			}
		}
		levels.get(0).setActive(true);
	}
	public void progress(String levelCode){
		System.out.println("update progress");
		System.out.println(levelCode);
		boolean doIt = true;
		int current = 0;
		for(Level lvl:levels){
			if(lvl.getLevelcode().equals(levelCode)){
				current = lvl.getLevelnumber();
				for(int i = levels.size() - 1; i >= 0; i--){
					if(levels.get(i).isActive()){
						doIt = i < current;
						break;
					}
				}
				break;
			}
		}
		if(doIt){
			try {
				File file = new File("progress.txt");
				FileWriter fw = new FileWriter(file);
				fw.write(levelCode);
				fw.close();
				setActive(levelCode); 
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("progress not saved");
			} 
		}
		System.out.println("finished progress update.");
	}
	private void playerPosition(Level level, int inx, int iny){
		if(inx<=0 || iny<=0){
			System.out.println("Player is not on level: "+level.getLevelnumber());
			levels.remove(level);
			return;
		}
		int pixelOffSet = 10,x=0,y=0; 
		for(Static_Object o:level.getStatic_Objects()){
			if(o.shape.getX() == (inx-1)*20 && 	o.shape.getY() == (iny)*20) x=pixelOffSet;
			else if(o.shape.getX() == (inx)*20 && 	o.shape.getY() == (iny-1)*20) y=pixelOffSet; 
			else if(o.shape.getX() == (inx)*20 && 	o.shape.getY() == (iny)*20){
				System.out.println("Illegal player position, your in a wall! Removing the Level!");
				levels.remove(level);
			}
			else if(o.shape.getX() == (inx)*20 &&	o.shape.getY() == (iny+1)*20) y=-pixelOffSet; 
			else if(o.shape.getX() == (inx+1)*20 && 	o.shape.getY() == (iny)*20) x=-pixelOffSet; 
		}
		x=x+(inx*20); 
		y=y+(iny*20); 
		level.setPlayerX(x); 
		level.setPlayerY(y);
	}
	public ArrayList<Level> getLevels() {
		return levels;
	}
	public ArrayList<Level> getCustomLevels() {
		return customlevels;
	}
	public Level  getlevel(int level) {
		return levels.get(level); 
	}
	public Level getCustomlevel(int level){
		return customlevels.get(level);
	}
}