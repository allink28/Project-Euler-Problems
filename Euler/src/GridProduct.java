import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */

/**
 * @author Allen
 *
 */
public class GridProduct {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] array = fileReader("problem11.txt");

		for(int i=0; i<20; ++i){ //Display 2D array of numbers
			for(int j=0; j<20; ++j){
				System.out.print(array[i][j] +" ");
			}
			System.out.println();
		}
		
		int max = 0;
		for(int i=0; i<20; ++i){ 
			for(int j=0; j<20; ++j){
				//check down
				if(i<17){
					max = Math.max(max, array[i][j]*array[i+1][j]*array[i+2][j]*array[i+3][j]);
					if(j>2){//check diagonally to the left
						max = Math.max(max, array[i][j]*array[i+1][j-1]*array[i+2][j-2]*array[i+3][j-3]);
					}
				}																
				
				//check to the right
				if(j<17){
					max = Math.max(max, array[i][j]*array[i][j+1]*array[i][j+2]*array[i][j+3]);
					if(i<17){//check diagonally to the right
						max = Math.max(max, array[i][j]*array[i+1][j]*array[i+2][j]*array[i+3][j]);
					}
				}				
			}
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
		int[][] array = new int[20][20];
		String str;
		String[] strings;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			
			for(int i=0; i<20; ++i){
				if((str = in.readLine()) != null){ //Read an entire line in at a time.
					strings = str.split("\\s+"); //Use whitespace as delimiter and split up line
					for(int j=0; j<20; ++j){
						array[i][j]=Integer.parseInt(strings[j]);
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
