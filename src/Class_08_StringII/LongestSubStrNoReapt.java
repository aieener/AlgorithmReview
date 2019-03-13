package Class_08_StringII;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrNoReapt {
    /**
     * This one is very tricky !
     * A Classical Sliding Window Prob
     * Using sliding window!!
     */
    public int longest(String input) {
        int globalMax = 1;
        int f = 0;
        int s = 0;
        char[] array = input.toCharArray();
        Set<Character> set = new HashSet<>();
        while(f < array.length){
            if(set.contains(array[f])){
                set.remove(array[s]);
                s++;
            } else {
                set.add(array[f]);
                f++;
                globalMax = Math.max(globalMax, f - s);
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        LongestSubStrNoReapt ls =new LongestSubStrNoReapt();
        String input = "efhrgsayfkasdanfev";
        int out = ls.longest(input);
        System.out.println(out);
    }
    //-- prac ---
}
