package Class_06_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class AllPermutation {
    // My Sol, idea from NineChapter
    public List<String> permutation(String set){
        List<String> res = new ArrayList<>();
        if(set == null){
            return res;
        }
        if(set == ""){
            res.add("");
            return res;
        }
        StringBuilder list = new StringBuilder();
        HashSet<Character>  hashset = new HashSet<>();
        dfs(set, res, list, hashset);
        return res;
    }

    private void dfs(String set, List<String> res,
                     StringBuilder list, HashSet<Character> hashset){
        // base case
        if(list.length() == set.length()){
            res.add(list.toString());
            return;
        }

        for(int i = 0; i < set.length(); i++) {
            if(hashset.contains(set.charAt(i))){
                continue;
            }
            hashset.add(set.charAt(i));
            list.append(set.charAt(i));
            dfs(set, res, list, hashset);
            hashset.remove(set.charAt(i));
            list.deleteCharAt(list.length() - 1);
        }
    }

    //--------- LaiOfferSol with order --------------
    public List<String> permutationsWithOrder(String set){
        List<String> result = new ArrayList<>();
        if(set == null) {
            return null;
        }
        char [] arraySet = set.toCharArray();
        Arrays.sort(arraySet);

        // record which index has been used in the original arraySet
        boolean[] used = new boolean[arraySet.length];
        StringBuilder cur = new StringBuilder();
        helperWithOrder(arraySet, used, cur, result);
        return result;
    }

    private void helperWithOrder(char[] array, boolean[] used, StringBuilder cur,
                                 List<String> result){
        // term condition
        if(cur.length() == array.length){
            result.add(cur.toString());
            return;
        }
        // when picking the next char, always according to the order
        for(int i = 0; i < array.length; i++){
            if(!used[i]) {
                used[i] = true;
                cur.append(array[i]);
                helperWithOrder(array, used, cur, result);
                // 回溯
                used[i] = false;
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
    //-------------- LaiOffer Sol 2 swap swap---------
    // 需要加强复习此方法
    public List<String> permutationsLai(String set) {
        List<String> result = new ArrayList<>();
        if ( set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    private void helper(char[] array, int idx, List<String> result) {
        if(idx == array.length) {
            result.add(new String(array));
            return;
        }

        // all the possible char could be placed at idx are the char
        // in the subarray (idx, array.length - 1)
        for(int i = idx; i < array.length; i++) {
            swap(array, idx, i);
            helper(array, idx + 1, result);
            // swap back when track to previous level
            swap(array, idx, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        AllPermutation ap = new AllPermutation();
        String input = "abc";
        List<String > res = ap.permutation(input);
        List<String > res2 = ap.permutationsWithOrder(input);
//        List<String > res3 = ap.permutationsLai(input);
        List<String > res3 = ap.permutations2(input);
        System.out.println(res);
        System.out.println(res2);
        System.out.println(res3);
    }

    //--- prac ---
    public List<String> permutations2(String set) {
        List<String > res = new ArrayList<>();
        if(set == null) {
            return res;
        }
        char[] array = set.toCharArray();
        dfs2(res, array, 0 );
        return res;
    }

    private void dfs2(List<String> res, char[] array, int idx) {
        // base case
        if(idx == array.length) {
            return ;
        }
        for(int i = idx ; i < array.length; i++) {
            swap2(array, idx, i);
            dfs2(res, array, idx + 1);
            swap2(array, idx, i);
        }
    }

    private void swap2 (char[] array, int l, int r) {
        char tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }

}
