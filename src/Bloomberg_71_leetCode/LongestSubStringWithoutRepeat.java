package Bloomberg_71_leetCode;

import Class_08_StringII.LongestSubStrNoReapt;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 3
 * LaiOffer StringII
 */
public class LongestSubStringWithoutRepeat {
    /**
     * Classical Sliding window
     * semantics:
     *  left: statring of a string
     *  right: ending of a string without repeat
     *
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int curMax = 1;

        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
                curMax = Math.max(curMax, right - left );
            }
        }
        return curMax;
    }

    public static void main(String[] args) {
        LongestSubStringWithoutRepeat sr = new LongestSubStringWithoutRepeat();
//        String input = "abcabcbb";
        String input = "dvdf";
        System.out.println(sr.lengthOfLongestSubstring(input));
    }

    //--------- prac ------------
    public int lengthOfLongestSubstring2(String s) {
        if(s== null || s.length() ==0) {
            return 0;
        }
        // sliding window
        int l = 0;
        int r = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while(r < s.length()) {
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
                res = Math.max(res, r-l);
            } else {
                set.remove(s.charAt(l));
                l++;
            }
        }
        return res;
    }
}
