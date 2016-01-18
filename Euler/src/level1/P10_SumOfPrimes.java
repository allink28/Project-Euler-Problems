package level1;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * 
 * @author Allen
 *
 */
public class P10_SumOfPrimes {

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
	 * @param n An odd number to be checked for primality.
	 * @return True if n is prime
	 */
	public static boolean isPrime(int n){
		int sqrt = (int) Math.sqrt(n)+1;//Only check up to Square root of number
		for (int i=3; i < sqrt; i+=2){//Numbers being checked will only be odd, so don't divide by evens.
			if (n % i == 0){
				return false;
			}			
		}
		return true;
	}

}
