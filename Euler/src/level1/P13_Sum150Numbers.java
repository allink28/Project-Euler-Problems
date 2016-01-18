package level1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * (Numbers are in problem13.txt)
 * @author Allen Preville
 *
 */
public class P13_Sum150Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum = 0;
		String str;
		try {
			BufferedReader in = new BufferedReader(new FileReader("problem13.txt"));
			while ((str = in.readLine()) != null) {
				sum = sum + Long.parseLong(str.substring(0, 16));
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}
		System.out.println(sum);
		System.out.println("Just the first 10 digits: "+sum/100000000);
	}
}
