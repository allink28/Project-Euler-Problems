package level1;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 
 * 1^2 + 2^2 + ... + 10^2 = 385 The square of the sum of the first ten natural
 * numbers is,
 * 
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025 Hence the difference between the sum of the
 * squares of the first ten natural numbers and the square of the sum is 3025 -
 * 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 * 
 * @author Allen
 * 
 */
public class P6_DifferentSquares {

	/**
	 * Calculate difference between sum of squares and square of sums.
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 100;
		int squareOfSums = 0;
		int sumOfSquares = 0;
		int sum = n*(n+1)/2; //Formula for summation 1 to n.
		
		++n;
		for (int i=1; i<n; ++i){
			sumOfSquares += (int) Math.pow(i, 2);
		}
		squareOfSums = (int) Math.pow(sum, 2);
		
		System.out.println("This will explaaaain everything: " + (squareOfSums - sumOfSquares));
		
				

	}

}
