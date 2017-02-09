import java.util.ArrayList;

@SuppressWarnings("serial")
public class SongList extends ArrayList<Song>{
    
    /**
     * sorts the mp3 list by title 
     */
    public void sortByTitle() {
    	int n = this.size();
    	for(int i = 1; i < n; i++){
    		Song temp = this.get(i);
    	    int j = i;
    	    while(j > 0 && temp.getTitle().compareToIgnoreCase(
    	    		this.get(j - 1).getTitle()) < 0) {
    	    	//compares mp3s by their title and keeps shifting items over
    	    	//until it finds the place for the mp3 in arraylist(i) 
    	    	//then sets its location after the while loop
    	    	this.set(j, this.get(j - 1));
    	    	j--;
    	    }
    	    this.set(j, temp); 
    	}
  }
    
    /**
     * sorts the mp3 list by artist 
     */
    public void sortByArtist() {
    	int n = this.size();
    	for(int i = 1; i < n; i++){
    		Song temp = this.get(i);
    	    int j = i;
    	    while(j > 0 && temp.getArtist().compareToIgnoreCase(
    	    		this.get(j - 1).getArtist()) < 0) {
    	    	//compares mp3s by their artist and keeps shifting items over
    	    	//until it finds the place for the mp3 in arraylist(i) 
    	    	//then sets its location after the while loop
    	    	this.set(j, this.get(j - 1));
    	    	j--;
    	    }
    	    this.set(j, temp); 
    	}
    	
  }
    		
    /**
     * prints the list of mp3 files found through buildlist method
     * in FileBrowser.
     */
    public void print() {
        for(int i = 0; i < this.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + this.get(i).toString());
        }
        System.out.println("------------------");
    }
    
    
}