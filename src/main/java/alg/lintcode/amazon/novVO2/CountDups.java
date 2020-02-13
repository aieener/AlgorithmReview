package alg.lintcode.amazon.novVO2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
lintcode 1794
 */
public class CountDups {
    public List<Integer> CountDuplicates(List<Integer> nums) {
        // 1 2 2 3 3 3
        //       s
        //             f
        List<Integer> res = new ArrayList<>();
        if(nums== null || nums.size() < 2) return res;
        Map<Integer,Integer> seem = new HashMap<>();
        for(Integer val : nums) {
            if(seem.containsKey(val) && seem.get(val) == 1) {
                res.add(val);
            }
            seem.put(val, seem.getOrDefault(val, 0) + 1);
        }
        return res;
    }
}
