import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 8
 * Find the greatest product of five consecutive digits in the 1000-digit number.
 * 
 * Strategy: Make a queue to hold the 5 digits that you are looking at. Compare sum to the
 *
 * @author Allen Preville
 * 
 */
public class Read1000DigitNumber {

	public static void main(String[] args) {
		String number = fileReader("problem8");

		int maxIndex = 0, maxProduct = 0;
		int length = number.length();
		Queue<Integer> q = new LinkedList<Integer>();		
		
		for (int i = 0; i < 5; ++i) { //Initialize queue with first 5 digits
			q.add(Character.getNumericValue(number.charAt(i)));
		}

		int product;
		for (int i = 4; i < length; ++i) {
			product = 1;
			Iterator<Integer> it = q.iterator();
			while (it.hasNext()) {
				product = product * it.next();
			}
			
			if (product > maxProduct){
				maxIndex = i; //Points to the last character of the 5
				maxProduct = product;
			}
			q.poll(); //Remove first element in queue
			q.add(Character.getNumericValue(number.charAt(i)));
		}
		
		System.out.println("The answer is: " + maxProduct);
		System.out.print("With the sequence: ");
		for(int i = 5; i>0; --i){
			System.out.print(number.charAt(maxIndex-i));	
		}
	}

	/**
	 * Read input from file
	 * 
	 * @param filename
	 *            The name of the file
	 * @return The contents
	 */
	public static String fileReader(String filename) {
		String str;
		String result = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while ((str = in.readLine()) != null) {
				result = result.concat(str);
			}

			in.close();
		} catch (IOException e) {
			System.out.println("File not found");
			result = "Definitely not your string";
		}
		return result;
	}

}
