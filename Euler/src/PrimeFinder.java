
public class PrimeFinder {

	/**
	 * Find the 10 001st prime number
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 3;		
		int primes = 2;
		while(primes != 10001){
			n += 2;
			if(isPrime(n)){
				++primes;
			}			
		}
		System.out.println(n);

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
