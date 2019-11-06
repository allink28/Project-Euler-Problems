package level4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem:
 * "By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 * <p>
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * <p>
 * That is, 3 + 7 + 4 + 9 = 23.
 * <p>
 * Find the maximum total from top to bottom in triangle.txt (right click and
 * 'Save Link/Target As...'), a 15K text file containing a triangle with
 * one-hundred rows.
 * <p>
 * NOTE: This is a much more difficult version of Problem 18. It is not possible
 * to try every route to solve this problem, as there are 2^99 altogether! If you
 * could check one trillion (10^12) routes every second it would take over twenty
 * billion years to check them all. There is an efficient algorithm to solve it.
 * ;o) "
 *
 *
 * My solution utilizes a dynamic programming (aka memoization) algorithm to
 * keep track of the max number than can be achieved by any position working
 * from top to bottom.
 * The max is recorded in the 'total' array and the results used to determine
 * the max values for the next row down.
 * @author Allen
 */
public class P67_GreatestSumPyramid {
    public static final int arrayWidth = 100;
    public static final int arrayHeight = 100;

    public static void main(String[] args) {
        /*
         * This 2D Array is the array problem to solve
         */
         final int[][] array = fileReader("problem67.txt");
		/*
	 	 * total[x][y] is the max total to reach spot (x,y)
		 */
        int[][] total = new int[arrayWidth][arrayHeight];

//        print2dArray(array);

        //First element base case
        total[0][0] = array[0][0];
        //
        for (int y = 1; y < arrayHeight; ++y) {
            total[0][y] = total[0][y - 1] + array[0][y];
            for (int x = 1; x <= y; ++x) {
                //Choose the largest value of the two above
                total[x][y] =
                        Math.max(total[x - 1][y - 1] + array[x][y], total[x][y - 1] + array[x][y]);
            }
        }
        int max = 0;
        for (int x = 0; x < arrayWidth; ++x) {
            max = Math.max(max, total[x][arrayHeight - 1]);
        }

        System.out.println("The solution is: " + max);
    }

    /**
     * Read input from file
     *
     * @param filename The name of the file (For this particular program, problem11.txt)
     * @return The contents
     */
    public static int[][] fileReader(final String filename) {

        final int[][] array = new int[arrayWidth][arrayHeight];

        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            //One line string of text of the input file
            String line;

            for (int y = 0; y < arrayHeight; ++y) {
                if ((line = in.readLine()) != null) { //Read an entire line in at a time.
                    String[] nodes = line.split("\\s+"); //Use whitespace as delimiter and split up line

                    for (int x = 0; x < nodes.length; ++x ) {
                        array[x][y] = Integer.parseInt(nodes[x]);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File not found. " + e.getMessage() );
        }
        return array;
    }

    /**
     * Print each of the entries of a 'triangle' 2D array
     *
     * @param array Array that has 1 entry at row 0, 2 entries at row 1, etc
     */
    public static void print2dTriangleArray(int[][] array) {
        for(int y=0; y<arrayWidth; ++y){ //Display 2D array of numbers
			for(int x=0; x<y+1; ++x){
				System.out.print(array[x][y] +" ");
			}
			System.out.println();
		}
    }

}
