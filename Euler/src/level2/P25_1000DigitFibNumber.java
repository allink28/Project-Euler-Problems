package level2;

import java.math.BigInteger;

public class P25_1000DigitFibNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		P25_1000DigitFibNumber p = new P25_1000DigitFibNumber();
		System.out.println(p.fibonacci());

	}
	
    /**
     * @return Returns the index of the first Fibonacci term that is 1000 digits long.
     */
    public int fibonacci(){
            BigInteger temp;
            BigInteger n_1 = new BigInteger("1");
            BigInteger n = new BigInteger("1");
            int term = 2;
            do{
                    temp = n;
                    n = n_1.add(n);
                    n_1 = temp;
                    ++term;
            } while(n.toString().length() < 1000);
            return term;
    }

}
