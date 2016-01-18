/**
 * 
 */
package level2;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Problem 26:
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
1/2 =   0.5
1/3 =   0.(3)
1/4 =   0.25
1/5 =   0.2
1/6 =   0.1(6)
1/7 =   0.(142857)
1/8 =   0.125
1/9 =   0.(1)
1/10  =   0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 * @author Allink
 */
public class P26_ReciprocalCycles {

  /**
   * @param args
   */
  public static void main(String[] args) {   
    P26_ReciprocalCycles.solve();
  }
  
  public static void solve() {
    BigDecimal fraction = null;
    String decimal = null;
    int[] longestPattern = {1, 1};
    BigDecimal numerator = new BigDecimal(1000000000);
    
    for (int i = 2; i < 1000; ++i) {
      fraction = numerator.divide(new BigDecimal(i), new MathContext(4096));
      decimal = String.valueOf(fraction).replace(".", "");
      String pattern = findRepeatingPattern(decimal);
      if (pattern.length() > longestPattern[1]) {
        longestPattern[0] = i;
        longestPattern [1] = pattern.length();
        System.out.println(i + ": " + decimal + " pattern: " + pattern);
      }
    }
    
    System.out.println("Longest pattern is 1 / " + longestPattern[0] + " with a pattern length of: " + longestPattern[1]);
  }
  
  /*
   * Use two iterators (i for start point, j for end point of potential pattern)
   *  to go through list and match with the remainder of the list
   */
  private static String findRepeatingPattern(String decimal) {
    for (int i = 1; i < decimal.length() - 1; ++i) {
      for (int j = i +1; j < decimal.length(); ++j) {
        String stringToMatch = decimal.substring(i, j);
        if (decimal.substring(j).startsWith(stringToMatch)) {
          return stringToMatch;
        }
      }      
    }
    return "";
  }
  
}
