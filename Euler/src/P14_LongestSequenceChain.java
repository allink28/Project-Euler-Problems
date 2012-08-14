/**
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n n/2 (n is even) 
 * n 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following
 * sequence:
 * 
 * 13 40 20 10 5 16 8 4 2 1 It can be seen that this sequence (starting at 13
 * and finishing at 1) contains 10 terms. Although it has not been proved yet
 * (Collatz Problem), it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * @author Allen Preville 
 */

public class P14_LongestSequenceChain {
	
	public static void main(String[] args){	
		int[] counts = new int[1000000]; //Memoization. Save already calculated results and reduce problems to them.
		int largestCount = 0;
		int startNumber = 1;
		long n;
		int count;
		
		counts[0]=1;
		for(int i = 2; i < 1000000; ++i){
			n = i;
			count = 0;
			do{
				if(n%2 == 0){
					if(n < i-1){
						count+=counts[(int) (n-1)]; //once we get to a sequence we already solved, add that sequences count to this one.
						break;
					}
					n/=2;
				}else{
					n = 3*n +1;
				}
				++count;
			}while(n!=1);
			//++count //count will be 1 less than it actually should be, but we don't need to know the exact number, just which is biggest.
			counts[i-1]=count;
						
			if(largestCount<count){
				largestCount = count;
				startNumber = i;
			}
		}
		System.out.println("Starting Number: "+startNumber+" with length of "+largestCount);
	}
}