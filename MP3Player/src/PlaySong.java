import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class PlaySong {

	private Player player;
	
	public PlaySong() {
		this.player = null;
	}
	
	/**
	 * checks to see if the player has been created, if 
	 * there's already a player playing, closes the player,
	 * then starts a new thread to play the mp3. Otherwise, 
	 * simply starts a new thread to play the mp3.
	 * @param filepath
	 */
	public void play(String filepath) {
		if(this.player != null) {
			this.player.close();
		}
		 
		FileInputStream is = null;
		try {
			is = new FileInputStream(filepath);
		} catch (FileNotFoundException e2) {
			System.out.println("Couldn't start the player, " +
					"choose another song.");
			return;
		}
		try {
			this.player = new Player(is);
		} catch (JavaLayerException e1) {
			System.out.println("Couldn't start the player, " +
					"choose another song.");
			return;
		}
		Thread t = new Thread() {
			public void run() {
				try {
					player.play();
				} catch(Exception e) {
					System.out.println("Couldn't play the song," +
							" choose another file.");
					return;
				}
			}
		};         
		t.start();
	}
	
	/**
	 * checks to see if the player has been created. If the player isn't null,
	 * closes the player and sets it to null if it is, else does nothing 
	 */
	public void stopPlayback() {
		if(this.player != null) {
			this.player.close();
			this.player = null;		
		}
	}

}
