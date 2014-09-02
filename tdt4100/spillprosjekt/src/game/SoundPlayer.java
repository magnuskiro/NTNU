package game;

import java.io.IOException;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundPlayer {
	private int gameSongs = 5;
	private String creditsSong = "credits.wav", menuSong = "menu.wav", song, folder = "resources/music/";
	private AudioStream as;
	private boolean inGame, credits, mute;

	public SoundPlayer() {
		playSong(menuSong);
	}

	public void setMusic(boolean inGame, boolean credits) {
		if(this.inGame != inGame || this.credits != credits){
			AudioPlayer.player.stop(as);
			this.inGame = inGame;
			this.credits = credits;
			if(inGame) song = pickSong();
			else if(credits) song = creditsSong;
			else song = menuSong;
			if(!mute) playSong(song);
		}
	}
	
	public void mute(boolean mute){
		this.mute = mute;
		if(mute) AudioPlayer.player.stop(as);
		else AudioPlayer.player.start(as);
	}
	
	public void mute(){
		mute(!mute);
	}
	
	public boolean muted(){
		return mute;
	}

	private String pickSong(){
		return (int)(Math.random()*gameSongs)+".wav";
	}

	private void playSong(String song){
		try {
			as = new AudioStream(ClassLoader.getSystemResourceAsStream(folder+song));
		}catch(java.io.FileNotFoundException e){
			System.out.println("No file by that name\n'" + e.toString() + "'");
		}catch (IOException e) {
			e.printStackTrace();
		}
		AudioPlayer.player.start(as);
	}
	public void stopPlaying(){
		AudioPlayer.player.stop(as);
	}

}
