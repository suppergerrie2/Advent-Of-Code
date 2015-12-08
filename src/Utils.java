import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utils {
	public static String getFileT(String path){
		File file = new File("D:/java/workspace/Adventcalander/" + path + ".txt");
		Scanner scanner;
		String filecont = "";
		try {
			scanner = new Scanner(file);
			try{
				while(scanner.hasNextLine()) {
					filecont = scanner.nextLine();
				}
			} finally {
				scanner.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return filecont;
	}
	
	public static boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
}
