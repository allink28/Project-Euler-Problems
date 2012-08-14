/**
 * Find the 10 001st prime number
 * 
 * @author Allen
 *
 */
public class P7_PrimeFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 3;		//Skip 2, the only even prime.
		int primes = 2; //1 and 2 are primes.
		while(primes != 10001){
			n += 2; //Only check odd numbers
			if(isPrime(n)){
				++primes;
			}			
		}
		System.out.println(n);

	}
	
	/**
	 * Check if n is a prime number
	 * @param n An odd number that we wish to know if it is prime or composite.
	 * @return True if n is prime
	 */
	public static boolean isPrime(int n){
		int sqrt = (int) Math.sqrt(n)+1; //Only check up to Square root of number 
		for (int i=3; i < sqrt; i+=2){ //Numbers being checked will only be odd, so don't divide by evens.
			if (n % i == 0){
				return false;
			}
		}
		return true;
	}

}
