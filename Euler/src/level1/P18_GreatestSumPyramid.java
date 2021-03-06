package level1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 * 
 * 	 3
 *  7 4
 * 2 4 6
 *8 5 9 3
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom of the triangle below:
 * 
 * @author Allen
 * Dynamic Programming
 */
public class P18_GreatestSumPyramid {

	public static final int arrayWidth = 15;
	public static final int arrayHeight = 15;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] array = fileReader("problem18.txt");
		int[][] total = new int[arrayWidth][arrayHeight]; //total[x][y] is the max total to reach spot (x,y)
		/*for(int y=0; y<arrayWidth; ++y){ //Display 2D array of numbers
			for(int x=0; x<y+1; ++x){
				System.out.print(array[x][y] +" ");
			}
			System.out.println();
		}*/

		total[0][0] = array[0][0];
		for(int y=1; y<arrayHeight; ++y){
			total[0][y] = total[0][y-1]+array[0][y]; 
			for(int x=1; x<=y; ++x){
				total[x][y] = 
						Math.max(total[x-1][y-1]+array[x][y], 
								total[x][y-1]+array[x][y]);
			}
		}
		int max = 0;
		for(int x=0; x<arrayWidth;++x){
			max = Math.max(max, total[x][arrayHeight-1]);
		}
		System.out.println(max);
	}
	
	/**
	 * Read input from file
	 * 
	 * @param filename The name of the file (For this particular program, problem11.txt)
	 * @return The contents
	 */
	public static int[][] fileReader(String filename) {
		//int arrayWidth = 15;
		//int arrayHeight = 15;
		int[][] array = new int[arrayWidth][arrayHeight];
		String str;
		String[] strings;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			
			for(int i=0; i<arrayHeight; ++i){
				if((str = in.readLine()) != null){ //Read an entire line in at a time.
					strings = str.split("\\s+"); //Use whitespace as delimiter and split up line
					int j = 0;
					while(j < strings.length){
						array[j][i]=Integer.parseInt(strings[j]);
						++j;
					}
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}
		return array;
	}

}
