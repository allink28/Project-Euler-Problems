/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */

/**
 * @author Allen
 *
 */
public class SumOfPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum = 2;
		for(int i = 3; i < 2000000;){
			if (isPrime(i)){
				sum+=i;				
			}
			i+=2;
		}
		System.out.println(sum);

	}
	
	/**
	 * Check if n is a prime number
	 * Could be made faster if you assume that no even numbers will be passed to it.
	 * 	In that case, increment by 2s, only dividing by odds.
	 * @param n 
	 * @return True if n is prime
	 */
	public static boolean isPrime(int n){
		int sqrt = (int) Math.sqrt(n)+1;
		for (int i=3; i < sqrt;){
			if (n % i == 0){
				return false;
			}
			i+=2;
		}
		return true;
	}

}
