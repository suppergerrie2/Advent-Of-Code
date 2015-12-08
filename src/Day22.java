import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day22 {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Day 2.2");
		String filecont;
		int l = 10, w = 1, h = 1;
		int volume = 0;
		int total = 0;
		
		File file = new File("D:/java/workspace/Adventcalander/day2.txt");
		Scanner scanner = new Scanner(file);

		try{
			while(scanner.hasNextLine()) {
				filecont = scanner.nextLine();
				System.out.println(filecont);
				l = Integer.valueOf(filecont.split("x")[0]);
				w = Integer.valueOf(filecont.split("x")[1]);
				h = Integer.valueOf(filecont.split("x")[2]);

				volume = l * w * h;
				if(l == w && l == h) {
					System.out.println("HELP");
					System.exit(0);
				}
				else if(l < w && l < h) {
					total+=l+l;
					if(w < h) {
						total+=w+w;
						System.out.println("l 1");
					} else if (h < w){
						total+=h+h;
						System.out.println("l 2");
					} else if (w == h) {
						total+=w+w;
						System.out.println("l   w == h");
					}
				}
				else if(w < l && w < h) {
					total+=w+w;
					if(h < l) {
						total+=h+h;
						System.out.println("w1");
					} else if (l < h){
						total+=l+l;
						System.out.println("w2");
					} else if (l == h) {
						total+=l+l;
						System.out.println("w  l == h");
					}
				}
				else if(h < w && h < l) {
					total+=h+h;
					if(w < l) {
						total+=w+w;
						System.out.println("h1");
					} else if (l < w){
						total+=l+l;
						System.out.println("h2");
					} else if (l == w) {
						total+=l+l;
						System.out.println("h   l == w");
					}
				} else if (l == w) {
					total+=l+l+w+w;
					System.out.println("l == w");
				} else if (l == h) {
					total+=l+l+h+h;
					System.out.println("l == h");
				} else if (w == h) {
					total+=w+w+h+h;
					System.out.println("w == h");
				}
				total+=volume;
			}
			
		} finally {
			scanner.close();
		}
		
	
		System.out.println(total);
	}

}