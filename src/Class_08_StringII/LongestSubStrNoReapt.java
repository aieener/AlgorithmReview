package Class_08_StringII;

import org.omg.CORBA.MARSHAL;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrNoReapt {
    /**
     * This one is very tricky !
     * A Classical Sliding Window Prob
     * Using sliding window!!
     *
     * Last review April 14 2019
     */
    public int longest(String input) {
      if(input == null || input.length() == 0) {
          return 0;
      }
      Set<Character> validator = new HashSet<>();
      int res = Integer.MIN_VALUE;
      int slow = 0;
      for(int fast = 0; fast < input.length(); fast++) {
        if (validator.contains(input.charAt(fast))) {
          validator.remove(input.charAt(slow));
          slow++;
        }
        validator.add(input.charAt(fast));
        res = Math.max(res, validator.size());
      }
      return res;
    }


    public static void main(String[] args) {
        LongestSubStrNoReapt ls =new LongestSubStrNoReapt();
        String input = "abcdacef";
        int out = ls.longest(input);
        System.out.println(out);
    }
}
