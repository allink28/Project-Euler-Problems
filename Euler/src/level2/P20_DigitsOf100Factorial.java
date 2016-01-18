package level2;

import java.math.BigInteger;

/**
 * n! means n * (n-1) ... 3 * 2 * 1
 * 
 * For example, 10! = 10 9 ... 3 2 1 = 3628800, and the sum of the digits in the
 * number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * @author Allen
 * 
 */
public class P20_DigitsOf100Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger x = new BigInteger("1");
		for(int n = 99; n > 1; --n){//Multiplying by 100 would just add two 0's
			x = x.multiply(new BigInteger(""+n));
		}
		
		String bigNumber = x.toString();
		int length = bigNumber.length();
		int sum = 0;
		for(int i=0; i<length; ++i){
			sum = Integer.parseInt(bigNumber.charAt(i)+"") + sum;
		}
		System.out.println(sum);
	}

}
