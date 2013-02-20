/**
 * Find the 10 001st prime number
 * 
 * @author Allen
 *
 */
public class P7_PrimeFinder {
	public static long[] primes;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initializeArray(10001);
		long begin = System.nanoTime();
		int n = 5;
		int index = 2;
		while(index != 10001){			
			if(isPrime(n)){
				primes[index] = n;
				++index;
			}			
			n += 2;
		}
		long end = System.nanoTime();
		System.out.println((n-2) + " That took "+ (end - begin));

	}
	
	/**
	 * Check if n is a prime number
	 * @param n An odd number that we wish to know if it is prime or composite.
	 * @return True if n is prime
	 */
	public static boolean isPrime(int n){
		int sqrt = (int) Math.sqrt(n); //Only check up to Square root of number 
		for (int i=1; primes[i] <= sqrt && i < primes.length; ++i){
			if ( n % primes[i] == 0 ){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Initializes the prime array with the first 2 primes. 2,3. 
	 * @param size
	 */
	public static void initializeArray(int size){
		primes = new long[size];
		primes[0]=2;
		primes[1]=3;		
	}

}
