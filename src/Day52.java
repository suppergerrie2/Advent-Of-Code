import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day52 {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Day 5.2");
		String filecont;
		int total = 0;
		String[] doubles = new String[9000];
		boolean hasDouble = false;
		boolean hasRepeat = false;
		File file = new File("D:/java/workspace/Adventcalander/day5.txt");
		Scanner scanner = new Scanner(file);

		try{
			while(scanner.hasNextLine()) {
				filecont = scanner.nextLine();
				doubles = new String[filecont.length()];
				for(int q = 0; q < filecont.length()-1; q++){
					doubles[q] = filecont.substring(q, q+2);
				}
				for(int i = 0; i < filecont.length(); i++){
					for(int d = 0; d < doubles.length; d++){
						if(d < i-1 || d > i+1){
							if(i < filecont.length()-1 && filecont.substring(i, i+2).equals(doubles[d])){
								hasDouble = true;
							}
						}
					}
					if(i < filecont.length()-2){
						if(filecont.substring(i, i+1).equals(filecont.substring(i+2, i+3))) {
							hasRepeat = true;
						}
					}
				}
				if(hasDouble && hasRepeat) total++;
				hasRepeat = false;
				hasDouble = false;
			}
		} finally {
			scanner.close();
		}
		System.out.println(total);
	}
}