package alg.oa.microsoftRealOA;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
"aAbBcD" --> B
 */
public class MaxCharBothUpperAndLower {
  public Character find(String input) {
    int diffBetweenLowerAndUpper = 'a' - 'A';
    Character res = 'A' - 1;
    Set<Character> visited = new HashSet<>();
    for (Character val : input.toCharArray()) {
      if (val - 'a' >= 0) {
        // lower
        char upperChar = (char) (val - diffBetweenLowerAndUpper);
        if (visited.contains(upperChar)) {
          if (val - diffBetweenLowerAndUpper - res > 0) {
            res = upperChar;
          }
        }
      } else {
        //upper
        char lowerChar = (char) (val + diffBetweenLowerAndUpper);
        if (visited.contains(lowerChar)) {
          if (val - res > 0) {
            res = val;
          }
        }
      }
      visited.add(val);
    }
    return res;
  }

  public static void main(String[] args) {
    MaxCharBothUpperAndLower engine = new MaxCharBothUpperAndLower();
    System.out.println(engine.find("kaAbBcDdgGcvdewlfaqKkkk"));
  }
}
