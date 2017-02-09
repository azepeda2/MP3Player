import java.io.File;


public class FileBrowser {
	
	private SongList sl;
	
	public FileBrowser() {
		this.sl = new SongList();
	}
	
	/**
	 * recursively traverses through the directory and uses its helper
	 * method to build the list of files. Returns false if path is not a 
	 * directory, true otherwise
	 * @param path
	 * @return
	 */
	public boolean buildList(String path) {
		// helper method that takes in path and calls buildList 
		// input is a valid path
		File file = new File(path);
		if(!file.isDirectory()) {
			// if path is not a directory, exits program
			System.out.println("Path is not valid. Could not build " +
					"list program now exitting.");
			return false;
		} else {
			buildList(file);
		}
		return true;
	}
	
	/**
	 * recursively traverses through the directory and creates a 
	 * song instance for each file that ends with mp3.
	 * If file is not actually an mp3 or corrupt, it prints error 
	 * message and doesn't include it in the list.
	 * 
	 * @param path
	 * @return
	 */
	private boolean buildList(File path) {
		
		File[] fileList = path.listFiles();
		//creates a array of the items in the current directory
		Song s;
		for(File file: fileList) {
			if(file.isDirectory()) { 
				//if file is a directory, traverses through the directory
				//calling buildList recursively
				buildList(file);
			} else {	
				String name = file.getName();
				if(file.isFile() && 
						(name.substring(name.lastIndexOf('.') + 1).equals("mp3") == true)) { 
					//creates song for file and adds the file to DocumentList
					try {
						s = new Song(file);
						sl.add(s);
					} catch (Exception e) {
						System.out.println(file.getName() + " might not be an mp3 format." +
								" This song was not included.");
					}	
				}
			}
		}
		return true;
	}

	/**
	 * presents the user with possible operations 1-5. continues to loop 
	 * until user chooses 5 to exit program.
	 */
	public void viewSongs() {
		UI ui = new UI(sl);
		PlaySong p = new PlaySong();
		int choice = ui.getChoice();
		while(choice != 5) {
			if(choice == 1) {
				sl.sortByTitle();
				sl.print();
			} else if(choice == 2) {
				sl.sortByArtist();
				sl.print();
			} else if(choice == 3) {
				p.play(ui.getSongChoice());
			} else if(choice == 4) {
				p.stopPlayback();
				
			}
			choice = ui.getChoice();
		}
		System.out.println("Chose exit. Program is now exitting.");
	}

}