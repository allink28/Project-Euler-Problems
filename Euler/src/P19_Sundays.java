import java.util.Calendar;

/**
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 * 
 * 1 Jan 1900 was a Monday. Thirty days has September, April, June and November.
 * All the rest have thirty-one, Saving February alone, Which has twenty-eight,
 * rain or shine. And on leap years, twenty-nine. A leap year occurs on any year
 * evenly divisible by 4, but not on a century unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 * 
 * @author Allen
 * 
 */
public class P19_Sundays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();		   
	    System.out.println("Today is : " + cal.getTime() +"\n");
	    
	    int sundays = 0;	    
	    for (int year = 1901; year<2001; ++year){
	    	cal.set(year, 0, 1);//Set date to January first of year
	    	for(int m = 0; m<12; ++m){
	    		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
	    	    	++sundays;
	    	    }	    		
	    		cal.roll(Calendar.MONTH, true); //Roll month up
	    	}
	    }
	    System.out.println("Anyways, there were "+sundays+" Sundays that fell on the beginning of a month during the 20th century.");

	}

}
