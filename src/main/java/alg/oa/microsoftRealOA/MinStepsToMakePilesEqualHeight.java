package alg.oa.microsoftRealOA;

import alg.laioffer.class5.bintree.TreeNode;

import java.util.*;

/*
Alexa is given n piles of equal or unequal heights. In one step, Alexa can remove any number of boxes from the pile which has the
maximum height and try to make it equal to the one which is just lower than the maximum height of the stack. Determine the minimum
number of steps required to make all of the piles equal in height.
Example 1:

Input: piles = [5, 2, 1]
Output: 3
Explanation:
Step 1: reducing 5 -> 2 [2, 2, 1]
Step 2: reducing 2 -> 1 [2, 1, 1]
Step 3: reducing 2 -> 1 [1, 1, 1]
So final number of steps required is 3.
 */
public class MinStepsToMakePilesEqualHeight {

  public int minSteps(int[] piles) {
    int res = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder()); //<val, freq>
    for (int p : piles) {
      map.put(p, map.getOrDefault(p, 0) + 1);
    }
    while (map.size() > 1) {
      Map.Entry<Integer, Integer> maxEntry = map.pollFirstEntry();
      Map.Entry<Integer, Integer> secMaxEntry = map.pollFirstEntry();
      res += maxEntry.getValue();
      map.put(secMaxEntry.getKey(), maxEntry.getValue() + secMaxEntry.getValue());
    }
    return res;
  }

  public int minSteps2(int[] piles) {
    int len = piles.length;
    if (len <= 1) return 0;
    Arrays.sort(piles);
    int res = 0, distinctNums = 0;
    for (int i = 1; i < len; ++i) {
      if (piles[i] == piles[i - 1]) {
        res += distinctNums;
      } else {
        ++distinctNums;
        res += distinctNums;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    MinStepsToMakePilesEqualHeight engine = new MinStepsToMakePilesEqualHeight();
    System.out.println(engine.minSteps(new int[]{5, 2, 1}));
    System.out.println(engine.minSteps(new int[]{4, 5, 5, 4, 2}));
    System.out.println(engine.minSteps2(new int[]{5, 2, 1}));
    System.out.println(engine.minSteps2(new int[]{4, 5, 5, 4, 2}));
  }
}
