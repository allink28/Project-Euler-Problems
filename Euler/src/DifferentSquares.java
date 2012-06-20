
public class DifferentSquares {

	/**
	 * Calculate difference between sum of squares and square of sums.
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 100;
		int squareOfSums = 0;
		int sumOfSquares = 0;
		int sum = n*(n+1)/2;
		
		++n;
		for (int i=1; i<n; ++i){
			//numbers[i] = i+1;
			sumOfSquares += (int) Math.pow(i, 2);
		}
		squareOfSums = (int) Math.pow(sum, 2);
		
		System.out.println("This will explaaaain everything: " + (squareOfSums - sumOfSquares));
		
				

	}

}
