package alg.penn.maystreet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by yuding on 2/11/18.
 */
public class condup {
    int cout(int[] num) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(Integer cur : num) {
            if(!map.containsKey(cur)){
                map.put(cur, 1);
            } else{
                res++;
            }
        }
        return res;

    }
    public int deduplication(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }
        int res = 0;
        for(Integer i : set) {
            nums[res++] = i;
        }
        return nums.length - res;
    }

    public static void main(String[] args) {
        condup d = new condup();
        int[] in = new int[]{1,3,1,4,5,6,3,2};
        System.out.println(d.cout(in));
        System.out.println(d.deduplication(in));

    }
}
