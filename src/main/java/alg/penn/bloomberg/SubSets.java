package alg.penn.bloomberg;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS 鼻祖题
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        dfs(nums, res, level, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> level,
                    int idx){
        res.add(new ArrayList<Integer>(level));

        for(int i = idx; i < nums.length; i++) {
            level.add(nums[i]);
            dfs(nums,res,level,i + 1);
            level.remove(level.size() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        SubSets sb = new SubSets();
        int [] input = new int[] {1,2,3};
        System.out.println(sb.subsets(input));
    }

    //-------- jia a bu jia a -------
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        helper(res,set, nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res , List<Integer> set, int[] nums, int idx) {
        // base case
        if(idx == nums.length) {
            res.add(new ArrayList<>(set)); // deep cpy
            return ;
        }
        // two cases
        // add a
        set.add(nums[idx]);
        helper(res, set, nums, idx + 1);
        set.remove(set.size() - 1);

        // not add a
        helper(res, set, nums, idx + 1);
    }
}


