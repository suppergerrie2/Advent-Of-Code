import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println("Day 4");
		String s = "yzbqklnj";
		//s = Utils.getFileT("day4");
		int number = 0;
		long start = System.nanoTime();
		while(!MD5(s + number).substring(0, 7).equals("1234567")){
			number++;
			System.out.println(number);
		} 
		long timetaken = System.nanoTime() - start;
		System.out.println(s + "   " + MD5(s+number) + "    " + timetaken);
		System.out.println(number);
	}

	public static String MD5(String md5) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; i++) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
		}
		return null;
	}
}