import java.util.Scanner;


public class UI {
	
	private SongList list;
	
	public UI(SongList list) {
		this.list = list;
	}
	
	/**
	 * presents list of choices available in this program 
	 * and gets choice input from the user
	 * @return choice
	 */
	public int getChoice() {
		//prompts and scans for choice
		Scanner scan = new Scanner(System.in);
		int choice;
		System.out.println("Enter a choice: ");
		System.out.println("[1] List all sorted by Title");
		System.out.println("[2] List all sorted by Artist");
		System.out.println("[3] Play an mp3");
		System.out.println("[4] Stop playback");
		System.out.println("[5] Exit");
		choice = scan.nextInt();
		while(choice < 1 || choice > 5) {
			//ensures the choice entered is a valid choice (1-5)
			System.out.println("Please enter a choice from 1-5!");
			choice = scan.nextInt();
		}
		return choice;
	}
	
	/**
	 * prints the list of mp3 files, prompts user for the song 
	 * to be played and returns the file path.
	 * @return filepath
	 */
	public String getSongChoice() {
		//prompts and scans for fileid
		Scanner scan = new Scanner(System.in);
		int fileid;
		this.list.print(); 
		System.out.println("Enter number for the file you want: ");
		fileid = scan.nextInt() - 1;
		while (fileid < 0 || fileid >= list.size()) {
			fileid = scan.nextInt() - 1;
			System.out.println("Choice entered: " + (fileid + 1) + 
					". Please enter a valid choice.");
		}
		String filepath = list.get(fileid).getAbsolutePath();
		return filepath;
	}
	
}
