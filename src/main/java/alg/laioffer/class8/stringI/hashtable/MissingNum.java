package alg.laioffer.class8.stringI.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MissingNum {

  /**
   * (a ^ a1) ^ (b ^ b1) ^ (c ^ c1) ^ (d ^ d1) = a^b^c^d^a1^b1^c1^d1
   * a ^ 0 = a
   * a ^ a = 0
   */

  public int missing(int[] array) {
    int res = 0;
    for(Integer num : array) {
      res ^= num;
    }
    for(int i = 1; i <= array.length; i++) {
      res ^= array[i];
    }
    return res;
  }
}
