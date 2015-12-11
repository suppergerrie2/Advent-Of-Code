import java.io.IOException;

public class Day10 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println("Day 10");
		String startnum = "1113122113";
		String lastnum = "";//startnum.substring(0, 1);
		String endnum = "";
		int times = 1;
		int round = 0;
		int maxrounds = 50;

		while(round < maxrounds){
			System.out.println("Round:  " + round);
			System.out.println("Length: " + startnum.length());
			endnum = "";
			times = 1;
			round++;
			for(int i = 1; i < startnum.length(); i++){
				if(startnum.substring(i, i+1).equals(startnum.substring(i-1, i))) times++;
				if(!startnum.substring(i, i+1).equals(startnum.substring(i-1, i))){
					endnum += times + startnum.substring(i-1, i);
					times=1;
				}
				lastnum=startnum.substring(i, i+1);
			}
			endnum+=times + startnum.substring(startnum.length()-1, startnum.length());
			startnum = endnum;
			if(round == maxrounds){
				try {
					Utils.writeFile("day10out", endnum);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("endnum length:" + endnum.length());
		System.out.println("End time: " + (System.nanoTime()-start)/1000000000);
	}
}
