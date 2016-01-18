package level2;

/**
 * 
 A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012 021 102 120 201 210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 * 
 * @author Allen
 */
public class P24_Permutations {

        /**
         * @param args
         */
        public static void main(String[] args) {
        		P24_Permutations p = new P24_Permutations();
                /*
                 * Starting with 0 as the largest digit (the smallest 10 digit numbers start with 0) there are 9! permutations.
                 * 9! = 362880, So the 1000000th permutation can't start with 0, in fact it can't start with 1 either, so it
                 * must start with 2.
                 *
                 */
                int n = 2 * p.factorial(9) + 6*p.factorial(8) + 6*p.factorial(7) + 2*p.factorial(6) + 5*p.factorial(5) +
                                p.factorial(4) + 2*p.factorial(3) + p.factorial(2);  //2 7 8 3 9 1 5 4 _ _ (06)
                System.out.println("9!: "+p.factorial(9));
                System.out.println(n); // n = 999998, two permutations away from the millionth permutation.
                //2783915460

        }

        public int factorial(int n){
                if(n==2)
                        return 2;
                return n*factorial(n-1);
        }

}
