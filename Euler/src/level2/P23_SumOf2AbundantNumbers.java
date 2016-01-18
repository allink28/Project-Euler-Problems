package level2;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 * 
 * @author Allen Preville
 * 
 *         My basic strategy for this problem was to have both a sorted list of
 *         abundant numbers, and a hashset of abundant numbers. Then I would
 *         check every number, n, (Though we know 1 through 23 already) up to
 *         28123 by subtracting every number smaller than n and checking the
 *         hashset for (n - abundantnumber).
 * 
 */
public class P23_SumOf2AbundantNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		HashSet<Integer> set = new HashSet<Integer>(10000);
		ArrayList<Integer> list = findAbundantNumbers(28124);
		
		for (int i = 0; i < list.size(); ++i){
			set.add(list.get(i));
		}
		
		int sum = 0;
		for (int n=1; n < 28124; ++n){
			
			boolean flag = false;
			int j = 0;
			while(list.get(j) < n){
				if( set.contains(n-list.get(j))){
					flag = true;
					break;
				}
				++j;
			}
			if(!flag){
				sum+=n;
			}
		}		
		System.out.println(sum);
		long end = System.currentTimeMillis();
		System.out.println("Time in ms: " + (end-begin));

	}

	/**
	 * Find all abundant numbers below n.
	 * @param n
	 * @return Array of abundant numbers in ascending order.
	 */
	public static ArrayList<Integer> findAbundantNumbers(int n){
		ArrayList<Integer> list = new ArrayList<Integer>(5000);
		for (int i = 12; i < n; ++i){
			if(i < P21_AmicablePairs.sumOfProperDivisors(i)){
				list.add(i);
			}
		}				
		return list;
	}
}
