/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 * 
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
 * letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 * 
 * @author Allen
 * 
 * 
 * Author's note: This one is not pretty.
 */
public class P17_CountLetters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] letters = new int[28];
		letters[1]=3;
		letters[2]=3;
		letters[3]=5;
		letters[4]=4;
		letters[5]=4;
		letters[6]=3;
		letters[7]=5;
		letters[8]=5;
		letters[9]=4;
		letters[10]=3;
		letters[11]=6;
		letters[12]=6;
		letters[13]=8;
		letters[14]=8;
		letters[15]=7;
		letters[16]=7;
		letters[17]=9;
		letters[18]=8;
		letters[19]=8;
		letters[20]=6;//Twenty
		letters[21]=6;//Thirty
		letters[22]=5;//Forty
		letters[23]=5;//Fifty
		letters[24]=5;//Sixty
		letters[25]=7;//Seventy
		letters[26]=6;//Eighty
		letters[27]=6;//Ninety
		
					
		//1000
		int total =11; //one thousand
		//100s
		int hundredsColumn = 0;
		for(int i=1; i<10; ++i){
			hundredsColumn = letters[i]+7;//hundred
		}
		hundredsColumn*=900;
		hundredsColumn += 3*99*9; //ands
		
		//10s
		int tens = 0;
		for(int i=20; i<28; ++i){ //20 - 90
			tens+=letters[i];
		}
		tens*=100;
		
		//1 - 19
		int digits = 0; //sum of the letters of the digits 1-9
		for(int i = 1; i<10; ++i){
			digits+=letters[i];
		}
		digits*=90;
		int teens=0;//sum of the letters of the digits 10-19
		for(int i = 10; i<20; ++i){			
			teens+=letters[i];
		}
		teens*=10;
		total+=hundredsColumn+tens+teens+digits;
		System.out.println(total);
	}

}
