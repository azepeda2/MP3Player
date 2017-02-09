import java.io.File;
import java.io.IOException;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.ID3v24Frames;


public class Song {
	
    private File f;
    private String artist;
    private String title;
    private String album;
    
    public Song(File f) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
        this.f = f;
        MP3File file  = (MP3File)AudioFileIO.read(this.f);
        AbstractID3v2Tag v2tag  = file.getID3v2Tag();
		this.artist = (v2tag.getFirst(ID3v24Frames.FRAME_ID_ARTIST));
		this.title = (v2tag.getFirst(ID3v24Frames.FRAME_ID_TITLE));
		this.album = (v2tag.getFirst(ID3v24Frames.FRAME_ID_ALBUM));
        
    }
    
    public String getArtist() {
        return this.artist;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getAlbum() {
        return this.album;
    }
    
    public String getAbsolutePath() {
        return this.f.getAbsolutePath();
    }
    
    public String toString () {
    	return ("Title: " + this.title + " Artist: " +
    			this.artist + " Album: " + this.album);
    }
    
    
}
