import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6 {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Day 6");
		boolean[] lights = new boolean[1000*1000];
		int[] lighbrigt = new int[1000*1000];
		int brightness = 0;
		int x1, x2, y1, y2;
		int lightson = 0;
		String filecont;
		
		File file = new File("D:/java/workspace/Adventcalander/day6.txt");
		Scanner scanner = new Scanner(file);
		
		try{
			while(scanner.hasNextLine()) {
				filecont = scanner.nextLine();
				if(filecont.substring(0, 6).equals("toggle")) {
					System.out.println("toggle");
					//first number
					x1 = Integer.valueOf(filecont.split(",")[0].substring(7));
					//second number
					y1 = Integer.valueOf(filecont.split(",")[1].split(" ")[0]);
					//third number
					x2 = Integer.valueOf(filecont.split(",")[1].split(" ")[2]);
					//fourth number
					y2 = Integer.valueOf(filecont.split(",")[2]);
					for(int y = y1; y <= y2; y++){
						for(int x = x1; x <= x2; x++){
							lighbrigt[x + y * 1000] += 2;
							lights[x + y * 1000] = !lights[x + y * 1000];
						}
					}
				}
				if(filecont.substring(0, 8).equals("turn off")){
					System.out.println("turn off");
					//first number
					x1 = Integer.valueOf(filecont.split(",")[0].substring(9));
					//second number
					y1 = Integer.valueOf(filecont.split(",")[1].split(" ")[0]);
					//third number
					x2 = Integer.valueOf(filecont.split(",")[1].split(" ")[2]);
					//fourth number
					y2 = Integer.valueOf(filecont.split(",")[2]);
					//System.out.println(x1 + "  " + x2 + "  " + y1 + "   " + y2);
					for(int y = y1; y <= y2; y++){
						for(int x = x1; x <= x2; x++){
							if(lighbrigt[x + y * 1000] > 0) {
								lighbrigt[x + y * 1000]--;
								//System.out.println("brigh lager");
							} else {
								//System.out.println("brigh on lowest posibble!");
							}
							lights[x + y * 1000] = false;
						}
					}
				}
				if(filecont.substring(0, 7).equals("turn on")){
					System.out.println("turn on");
					//first number
					x1 = Integer.valueOf(filecont.split(",")[0].substring(8));
					//second number
					y1 = Integer.valueOf(filecont.split(",")[1].split(" ")[0]);
					//third number
					x2 = Integer.valueOf(filecont.split(",")[1].split(" ")[2]);
					//fourth number
					y2 = Integer.valueOf(filecont.split(",")[2]);
					//System.out.println(x1 + "  " + x2 + "  " + y1 + "   " + y2);
					for(int y = y1; y <= y2; y++){
						for(int x = x1; x <= x2; x++){
							lighbrigt[x + y * 1000]++;
							lights[x + y * 1000] = true;
						}
					}
				}
			}
			for(int i = 0; i < lights.length; i++){
				if(lights[i]) {
					lightson++;
				}
			}
			
			for(int s = 0; s < lighbrigt.length; s++){
				brightness+=lighbrigt[s];
			}
			
		} finally {
			scanner.close();
		}
		System.out.println("Lichten aan: " + lightson);
		System.out.println("Brightness: " + brightness);
		//14210482 to low
		//19807914 to high
	}

}
