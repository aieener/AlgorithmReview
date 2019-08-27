package alg.laioffer.class19.recursionII;

/**
 * Created by yuding on 2/8/18.
 * book --> 1o1k. b3 etc
 *
 * case1: if partern[0] is a letter, pattern[0] matches text[0],
 *          then do match(text[1:], pattern[1:])
 * case2: if pattern[0] is a digit, then read out all contigous digits
 *          to form a number (eg. num = 18) and recurse to match text[num..] pattern[num.len..]
 */
public class StringAbbreMatch {
    public boolean match(String input, String pattern) {
        return helper(input, pattern, 0, 0);
    }
    private boolean helper (String s, String t, int si, int ti) {
        // base case
        if(si == s.length() && ti == t.length()) {
            return true;
        } else if (si >= s.length() || ti >= t.length()) {
            return false;
        }

        // case 1
        if(!isdigit(t.charAt(ti)) ){
            if(s.charAt(si) != t.charAt(ti)) {
                return false;
            }
            return helper(s,t,si+1, ti+1);
        } else {
            int num = 0;
            while(ti < t.length() && isdigit(t.charAt(ti))) {
                num = 10 * num + (t.charAt(ti) - '0');
                ti++;
            }
            return helper(s, t, si + num, ti);
        }
    }

    private boolean isdigit(char i) {
        return i >= '0' && i <= '9';
    }
}
