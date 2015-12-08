import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5 {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Day 5");
		String filecont;
		int total = 0;
		int vowels = 0;
		boolean hasDouble = false;
		boolean hasBad = false;
		File file = new File("D:/java/workspace/Adventcalander/day5.txt");
		Scanner scanner = new Scanner(file);

		try{
			while(scanner.hasNextLine()) {
				filecont = scanner.nextLine();
				for(int i = 0; i < filecont.length(); i++){
					if(filecont.substring(i, i+1).equals("a") || filecont.substring(i, i+1).equals("e") || filecont.substring(i, i+1).equals("i") || filecont.substring(i, i+1).equals("o") || filecont.substring(i, i+1).equals("u") ){
						vowels++;
					}
					if(i < filecont.length()-1){
						if(filecont.substring(i, i+2).equals(filecont.substring(i, i+1) + filecont.substring(i, i+1))) {
							hasDouble = true;
						}
						if(filecont.substring(i, i+2).equals("ab") || filecont.substring(i, i+2).equals("cd") || filecont.substring(i, i+2).equals("pq") || filecont.substring(i, i+2).equals("xy")) {
							hasBad = true;
						}
					}
				}
				if(vowels >= 3 && hasDouble && !hasBad) total++;
				hasBad = false;
				hasDouble = false;
				vowels = 0;
			}
		} finally {
			scanner.close();
		}
		System.out.println(total);
	}
}