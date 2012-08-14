import java.math.BigInteger;

/**
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * 
 * @author Allen Preville
 * 
 */
public class P16_SumDigitsOfHugeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger number = new BigInteger("2");

		//----------Step 1: Calculate--------------
		//----Easy way to calculate----
		//number = number.pow(1000);
		
		//--- Do it myself way: -------
		for(int i=0; i<9; ++i){ //This a very efficient way of getting 2^512
			number = number.multiply(number);
		}	
		BigInteger number2 = new BigInteger("2");
		for(int i=0; i<488; ++i){
			number = number.multiply(number2);
		}
		
		//----------Step 2: Calculate--------------
		String bigNumber = number.toString();
		int length = bigNumber.length();
		int sum = 0;
		for(int i=0; i<length; ++i){
			sum = Integer.parseInt(bigNumber.charAt(i)+"") + sum;
		}
		
		System.out.println(sum);
	}
}
