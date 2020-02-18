package alg.oa.microsoftRealOA;

import javax.print.attribute.standard.MediaSize;

/*
Need to understand this better
 */
public class MinSwapsToGroupRedBalls {
  /*
  S contains only 'R' and 'W' representing Red and White balls
  return min swaps to make all Red ball next to eachother
  Example:
  Input: "RRRWRR"
  Output: 2
  Input:
  "WRRWWR" return 2
  "WWRWWWRWR return 4
  "WWW" return 0
  "RW repeated 100000 times" --> return -1, the res > 10^9

  can only swap a to neighbors
   */

  public int minSwap(String s) {
    int rCount = 0;
    for (char c : s.toCharArray()) {
      if (c == 'R') rCount++;
    }

    int left = 0, right = s.length() - 1, res = 0;
    while (left < right) {
      if (s.charAt(left) == 'R' && s.charAt(right) == 'R') {
        rCount -= 2;
        int chunkLenInbetween = right - left - 1;
        res += chunkLenInbetween - rCount;
        ++left;
        --right;
      } else if (s.charAt(left) != 'R') {
        ++left;
      } else {
        --right;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    MinSwapsToGroupRedBalls engine = new MinSwapsToGroupRedBalls();
    System.out.println(engine.minSwap("RRRWRR"));
    System.out.println(engine.minSwap("WRRWWR"));
    System.out.println(engine.minSwap("WWRWWWRWR"));
    System.out.println(engine.minSwap("WWW"));
  }
}
