package alg.penn.bloomberg;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 387
 * Created by yuding on 2/8/18.
 */
public class FirstUniqCharinString {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            int newFreq = map.getOrDefault(ch, 0);
            map.put(ch, newFreq + 1);
        }

        int res = 0;
        for(char ch : s.toCharArray()) {
            if(map.get(ch) == 1) {
                return res;
            }
            res++;
        }
        return -1;
    }

    //---- prac ----
    

}
