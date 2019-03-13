package Class_06_DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Subset do i + 1
 * Permutation do idx + 1
 */

public class AllSubsets {
    /**
     * NineChap Sol
     * @param set
     * @return
     */
    public List<String> subSets(String set){
        List<String> res = new ArrayList<>();
        if(set == null){
            return res;
        }
        if(set == ""){
            res.add("");
            return res;
        }
        dfs(set, res, new StringBuilder(),0);
        return res;
    }
    private void dfs(String set, List<String> res, StringBuilder subset,int idx){
        res.add(subset.toString());

        for(int i = idx; i<set.length(); i++){
            // since this is set, as the for loop goes
            // the set became shorter and shorter
            subset.append(set.charAt(i));
            dfs(set, res, subset, i + 1);
            subset.deleteCharAt(subset.length() - 1);
        }
    }

    /**
     * 加Ａ不加Ａ　Sol
     */
    public List<String> subSetAddorNot(String set) {
        List<String> res = new ArrayList<>();
        if(set == null){
            return res;
        }
        char [] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, res);
        return res;
    }

    private void helper(char[] arraySet, StringBuilder sb, int idx, List<String> res) {
        // base case
        if(idx == arraySet.length) {
            res.add(sb.toString()); // 触底了就 add s to res
            return;
        }

        // 1 not pick
        helper(arraySet, sb, idx + 1, res);

        // 2 pick
        helper(arraySet, sb.append(arraySet[idx]), idx + 1, res);

        // trace back
        sb.deleteCharAt(sb.length() - 1);
    }


    /**
     * My way following this method
     * Arvind/jerry's pure recursion method, from buttom to up
     */
    static List<List<Integer>>  result = new ArrayList<>();

    public static List<List<Integer>> powerSet(int[] nums) {

        if(nums == null){
            return result;
        }
        if(nums.length == 0){
            //base case;
            result.add(new ArrayList<>());
            return result;
        }

        // remove first element from original set
        int firstOne = nums[0];
        // create the noFirstnums set
        int [] noFirstnums = new int[nums.length - 1];
        for(int i = 1; i < nums.length; i++){
            noFirstnums[i-1] = nums[i];
        }

        // recursion happens here
        result = powerSet(noFirstnums);
        // add to result
        List<List<Integer>> nofirstElemresult = new ArrayList<>(result);
        for(List<Integer> Subset : nofirstElemresult){
            List<Integer> newSubset = new ArrayList<>(Subset);
            newSubset.add(firstOne);
            result.add(newSubset);
        }

        return result;
    }

    public static void main(String[] args) {
        AllSubsets sl = new AllSubsets();
        String input = "abc";
        List<String> res = sl.subSets2(input);
        System.out.println(res);
    }
    //------ Prac
    public List<String> subSets2(String set) {
        List<String> res = new ArrayList<>();
        if(set == null) {
            return res;
        }
        if(set == "") {
            res.add("");
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs2(res, sb, set, 0);
        return res;
    }

    private void dfs2(List<String> res, StringBuilder sb, String set,int idx){
        res.add(sb.toString());
        for(int i = idx; i < set.length();i++) {
            sb.append(set.charAt(i));
            dfs2(res,sb,set,i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
