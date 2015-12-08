import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Day 2");
		String filecont;
		int l = 10, w = 1, h = 1;
		int o1, o2, o3;
		int total = 0;
		
		File file = new File("D:/java/workspace/Adventcalander/testorg.txt");
		Scanner scanner = new Scanner(file);

		try{
			while(scanner.hasNextLine()) {
				filecont = scanner.nextLine();
				System.out.println(filecont);
				l = Integer.valueOf(filecont.split("x")[0]);
				w = Integer.valueOf(filecont.split("x")[1]);
				h = Integer.valueOf(filecont.split("x")[2]);

				o1 = 2*l*w; //10
				o2 = 2*w*h; //10
				o3 = 2*h*l; //1
				if(o1 == o2 && o1 == o3) {
					System.out.println("HELP");
					System.exit(0);
					
				}
				else if(o1 < o2 && o1 < o3) {
					total+=o1/2;
					System.out.println("o1");
				}
				else if(o2 < o1 && o2 < o3) {
					total+=o2/2;
					System.out.println("o2");
				}
				else if(o3 < o1 && o3 < o2) {
					total+=o3/2;
					System.out.println("o3");
				} else if (o1 == o2) {
					total+=o1/2;
					System.out.println("o1 == 2");
				} else if (o1 == o3) {
					total+=o1/2;
					System.out.println("o1 == 3");
				} else if (o2 == o3) {
					total+=o2/2;
					System.out.println("o2 == 3");
				}
				total+=o1+o2+o3;
			}
			
		} finally {
			scanner.close();
		}
		
	
		System.out.println(total);
	}

}