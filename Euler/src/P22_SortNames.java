import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.TreeSet;

/**
 * Using problem22.txt, a 46K text file
 * containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name
 * score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 * 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 * @author Allen
 * 
 */
public class P22_SortNames {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collection<String> treeSet = fileReader("problem22.txt");
		int total = 0, n = 1;
		for ( String s : treeSet){
			int score = 0;
			for (int i=0; i<s.length();++i){
				score +=(int) s.charAt(i) - 64; //ASCII value of A is 65.								
			}
			score *= n;
			total+=score;
			++n;
		}
		System.out.println(total);
	}

	/**
	 * Read input from file and sort it as it comes in. 
	 * 
	 * @param filename The name of the file (For this particular program, problem11.txt)
	 * @return The sorted contents
	 */
	public static Collection<String> fileReader(String filename) {
		Collection<String> treeSet = new TreeSet<String>();
		String str;
		String[] strings;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while ((str = in.readLine()) != null) {		
				str = str.replaceAll("\"", "");
				strings = str.split(",");	
				for(String s : strings){
					treeSet.add(s);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}

		return treeSet;
	}
}
