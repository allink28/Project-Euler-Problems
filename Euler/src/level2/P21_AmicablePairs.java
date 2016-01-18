package level2;
/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a b, then a and
 * b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10,000.
 * 
 * @author Allen
 * 
 */
public class P21_AmicablePairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] d = new int[100000];
		int amicableSum = 0;
		
		for (int a = 2; a < 10000; ++a){
			int b = sumOfProperDivisors(a);
			
			d[a] = b; //Bin sort
			if( a != b && d[b]==a){
				amicableSum+=a+b;
			}
		}
		System.out.println(amicableSum);		
	}
	
	/**
	 * The sum of proper divisors of n (numbers less than n which divide evenly
	 * into n).
	 * 
	 * @param n Find the number of properdivisors of n.
	 * @return The number of proper divisors, d, of n. E.g. if n=6, d=6 (1+2+3).
	 */
	public static int sumOfProperDivisors(int n){
		int d = 1;
		int sqrtn = (int) Math.sqrt(n)+1;
		for(int i = 2; i<sqrtn; ++i){
			if(n%i == 0){
				d+=i;	//We can get both factors, unless this is a perfect square.
				d+=(n/i);
			}
		}
		if (--sqrtn*sqrtn == n){//Check if perfect square.
			d-=sqrtn;
		}
		return d;
	}

}
