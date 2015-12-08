import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8 {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Day 8");
		String filecont, endstring = "";
		int orglength = 0, endlength = 0;

		File file = new File("D:/java/workspace/Adventcalander/day8.txt");
		Scanner scanner = new Scanner(file);
		

		
		try{
			while(scanner.hasNextLine()) {
				filecont = scanner.nextLine();
				orglength += filecont.length();
			//	System.out.println("length " + orglength + "   " + filecont.length());
				filecont = filecont.substring(1, filecont.length()-1);
				for(int i = 0; i < filecont.length(); i++){
					if(filecont.substring(i, i+1).equals("\\")){
							if(filecont.substring(i+1, i+2).equals("\"")){
								endstring += "\"";
								i++;
							} else if(filecont.substring(i+1, i+2).equals("\\")){
								endstring += "\\";
								i++;
							} else if(filecont.substring(i+1, i+2).equals("x")){
								endstring += convertToString(filecont.substring(i+2, i+4));
								i+=3;
							} 
					} else {
						endstring += filecont.substring(i, i+1);
					}
				}
				endlength += endstring.length();
				System.out.println(endstring);
				endstring = "";
			}
		} finally {
			scanner.close();
		}
		System.out.println(orglength-endlength);
	}
	
	private static String convertToString(String hexValue)
	{
	    StringBuilder output = new StringBuilder("");
	    for (int i = 0; i < hexValue.length(); i += 2)
	    {
	        String str = hexValue.substring(i, i + 2);
	        output.append((char) Integer.parseInt(str, 16));
	    }
	    return output.toString();
	}
}
