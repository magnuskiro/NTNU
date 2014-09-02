package game;

import java.awt.CardLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Control extends JFrame implements Runnable{
	private ArrayList<Movable_Object> movables;
	private ArrayList<Static_Object> statics;
	private Player player;
	private JPanel mainPanel, game;
	private final int width = 1280, height = 720;
	private BufferStrategy bf;
	private int usedGhosts, currentLvl;
	private boolean ingame, paused, runningGame, iscustom, goal, showFPS;
	private long cycles;
	private ImportLevel levelImporter;
	private SelectLevelMenu selectLevelMenu;
	private SelectLocal selectLocal;
	private long currentTime, sleepTime = 20;
	private HighscoreList highscoreList;
	private GetHighScore getHigh;
	private Credits credits;
	private Thread db;
	private SoundPlayer audio;
	private VictoryScreen victory;
	private OptionMenu option;

	Control(){
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources/Icon.png")));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("*Working Title*");
		this.pack();
		this.setSize(width, height);
		this.setResizable(false);
		this.setIgnoreRepaint(false);
		levelImporter = new ImportLevel(this);
		mainPanel = new JPanel(new CardLayout());
		game = new JPanel();
		victory = new VictoryScreen();
		audio = new SoundPlayer();
		this.addKeyListener(new GameKeys(this));
		this.option = new OptionMenu(mainPanel, this, (GameKeys) this.getKeyListeners()[0]);
		this.setFocusable(true);
		this.setContentPane(mainPanel);
		this.selectLevelMenu = new SelectLevelMenu(levelImporter.getLevels(), this, mainPanel);
		this.selectLocal = new SelectLocal(mainPanel, this);
		try {
			highscoreList = new HighscoreList((this.width/2), (this.height/2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getHigh = new GetHighScore(levelImporter.getLevels(), this, mainPanel, selectLocal, highscoreList);
		this.credits = new Credits(this);
		mainPanel.add("mainmenu", new MainMenu(mainPanel, this));
		mainPanel.add("option", option);
		mainPanel.add("selectlevel", selectLevelMenu);
		mainPanel.add("ingamemenu", new IngameMenu(mainPanel, this));
		mainPanel.add("customlevel", new SelectCustomLevelMenu(levelImporter.getCustomLevels(), this, mainPanel, levelImporter));
		mainPanel.add("selectlocal", this.selectLocal);
		mainPanel.add("gethighscore", getHigh);
		mainPanel.add("credits", credits);
		mainPanel.add("victory", victory);
		mainPanel.add("game", game);
		this.createBufferStrategy(2);
		bf = this.getBufferStrategy();
		this.setVisible(true);
	}

	public boolean isIscustom() {
		return iscustom;
	}
	public SelectLocal getSelectLocal(){
		return this.selectLocal;
	}
	public void newGame(int level, char costom){
		this.requestFocus();
		currentLvl = level;
		this.goal = false;
		this.cycles = 0;
		System.out.println("NewGame Created");
		db = new Thread(this);
		System.out.println("Made new Thread");
		Level lvl;
		switch(costom){
		case 'c':
			iscustom = true;
			lvl = levelImporter.getCustomlevel(level - 1); break;
		default:
			iscustom = false;
			lvl = levelImporter.getlevel(level - 1); break;
		}
		System.out.println("Imported Level " + currentLvl + " succesfully");
		usedGhosts = 0;
		statics = lvl.getStatic_Objects();
		movables = lvl.getMoveable_Objects();
		System.out.println("Got all static and moveable objects from Level");
		player = new Player(new Rectangle(lvl.getPlayerX(), lvl.getPlayerY(), 25, 25));
		resetMovables();
		System.out.println("Made new Player\nLevel Succesfully initiated");

		db.start();
	}

	public void run(){
		this.sleep(100); 
		System.out.println("Game started");
		((CardLayout)mainPanel.getLayout()).show(mainPanel, "game");
		System.out.println("Setting 'ingame' and 'runningGame' to true");
		this.ingame = true;
		runningGame = true;
		audio.setMusic(true, false);
		this.setIgnoreRepaint(true);
		currentTime = System.currentTimeMillis();
		while(runningGame){
			while(ingame){
				move();
				draw();
				cycles++;
				this.sleep(getSleepTime());
			}
			this.sleep(50);
		}
		this.setIgnoreRepaint(false);
		System.out.println("Game ended succesfully");
	}
	/**
	 * This method Modifies the sleepTime to approximate the fps to the targetFps.
	 */
	long timeDiff;
	private long getSleepTime(){
		timeDiff = System.currentTimeMillis() - currentTime;
		if(timeDiff > 25) sleepTime -= 1;
		else if(timeDiff < 25) sleepTime += 1;
		currentTime = System.currentTimeMillis();
		if(sleepTime < 0){ 
			sleepTime = 0;
			System.err.println("Game slowing down");
		}
		return sleepTime;
	}
	public void restartCurrentLvl(){
		endGame();
		sleep(30);
		if(isIscustom()){				
			newGame(getCurrentLvl(), 'c');
		}else{
			newGame(getCurrentLvl(), 'o');
		}
		setPaused(false);
	}
	public void stopCredits(){
		this.credits.setPlay(false);
		this.sleep(60);
		((CardLayout)mainPanel.getLayout()).show(mainPanel, "mainmenu");
	}
	public void  updateOption() {
		option.update();
	}
	public boolean isIngame(){
		return ingame;
	}
	public Credits getCredits(){
		return this.credits;
	}
	public SelectLevelMenu selectLevelMenu() {
		return selectLevelMenu;
	}
	public void endGame(){
		setIngame(false);
		System.out.println("Ending game");
		runningGame = false;
		sleep(50);
	}
	public void pauseGame(){
		System.out.println("Pausing game");
		setPaused(true);
		setIngame(false);
		sleep(20);
		((CardLayout) mainPanel.getLayout()).show(mainPanel, "ingamemenu");
		System.out.println("Game paused without problems");
	}
	public void sleep(long value){
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void setIngame(boolean value){
		ingame = value;
		audio.setMusic(value, false);
	}
	public void stopAudio(){
		audio.stopPlaying();
	}
	public void setCreditsSound(boolean value){
		audio.setMusic(false, value);
	}
	public void setShowFPS(boolean showFPS) {
		this.showFPS = showFPS;
	}
	public void quit(){
		new JOptionPane();
		int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION);
		if(answer == JOptionPane.YES_OPTION){
			System.out.println("Quiting game");
			System.exit(0);
		}
	}
	//Called by Goal's when Players are at them.
	public void goal(){
		this.goal = true;
		ingame = false;
		runningGame = false;
		sleep(150);
		int time = (int)(cycles/25);
		victory.updateText(time, usedGhosts, currentLvl);
		((CardLayout)mainPanel.getLayout()).show(mainPanel, "victory");
		if(!iscustom){
			try {
				highscoreList.addScore(time, usedGhosts, currentLvl);
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentLvl ++;
			if(currentLvl <= levelImporter.getLevels().size()){
				if(!iscustom){
					System.out.println(currentLvl);
					levelImporter.progress(
							levelImporter.getlevel(currentLvl-1).getLevelcode());			
				}
				newGame(currentLvl, 'o');
			}else{
				((CardLayout)mainPanel.getLayout()).show(mainPanel, "selectlevel");
			}
		}else{
			((CardLayout)mainPanel.getLayout()).show(mainPanel, "customlevel");
		}
	}
	public int getCurrentLvl() {
		return currentLvl;
	}

	public boolean isPaused() {
		return paused;
	}
	public void setPaused(boolean paused) {
		this.paused = paused;
		this.setIgnoreRepaint(!paused);
	}
	/**
	 * This Method is called when a ghost shall be made
	 */
	public void ghost() {
		Rectangle2D ghostRect = (Rectangle2D)player.getShape().clone();
		ghostRect.setRect(player.getStartX(), player.getStartY(), player.getShape().getWidth(), player.getShape().getHeight());
		movables.add(new Ghost((Rectangle2D)ghostRect.clone(), player.getMemLeft(), player.getMemRight(), player.getMemJump(), player.getMemAction()));
		resetMovables();
		usedGhosts ++;
		System.out.println("Used ghosts: " + usedGhosts);
	}

	public void resetMovables(){
		player.fullReset();
		for(int i = 0;i < movables.size();i++){
			movables.get(i).reset();
		}		
	}
	public void move(){
		ArrayList<Item> items = new ArrayList<Item>();
		items.addAll(movables);
		items.addAll(statics);
		items.add(player);
		for(int i = 0;i < movables.size();i++){
			movables.get(i).updatePosition(items);
			if(movables.get(i) instanceof Goal){
				if(((Goal)movables.get(i)).hasWon()){
					if(!this.goal){
						this.goal();
					}
				}
			}
		}
		player.updatePosition(items);
	}
	public void draw(){
		if(!ingame || paused) return;
		bf.getDrawGraphics().clearRect(0, 0, this.width, this.height);
		for(int i = 0;i < movables.size();i++) movables.get(i).draw(bf.getDrawGraphics());
		for(int i = 0;i < statics.size();i++){
			statics.get(i).draw(bf.getDrawGraphics());
		}
		player.draw(bf.getDrawGraphics());
		if(showFPS) bf.getDrawGraphics().drawString((1000/(timeDiff + 1)) + "fps", 25, 55);
		bf.show();
		Toolkit.getDefaultToolkit().sync();
	}
	public Player getPlayer() {
		return player;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public BufferStrategy getBf() {
		return bf;
	}
	public SoundPlayer getAudio() {
		return audio;
	}
	public static void main(String[] args) {
		new Control();
	}
}
