import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;


public class Test {
	/*
	 * This file is not used in the project!!! was only used to try out methods!!!!!
	 */
	private static Player player;
	public static void main(String[] args) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
		
		File test = new File(args[0]);
		FileInputStream is = new FileInputStream(test);
		try {
			player = new Player(is);
		} catch (JavaLayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Thread t = new Thread() {
			public void run() {
				try {
					player.play();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};         
		t.start();
		Scanner s = new Scanner(System.in);
		s.nextLine();
		player.close();
	
	
		/*
		MP3File f  = (MP3File)AudioFileIO.read(test);
		Tag tag    = f.getTag();
		ID3v1Tag         v1Tag  = (ID3v1Tag)tag;
		AbstractID3v2Tag v2tag  = f.getID3v2Tag();
		ID3v24Tag        v24tag = (ID3v24Tag)f.getID3v2TagAsv24();
		
		String artist = (v24tag.getFirst(ID3v24Frames.FRAME_ID_ARTIST));
		System.out.println(artist);
		
		*/
	}

}
