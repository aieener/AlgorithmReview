package Class_08_StringII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsII {
    // time O(n!)
    // space O(n + n-1 + n-2 + ... + 1) = O(n^2)
    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        if(set == null) {
            return res;
        }
        char[] array = set.toCharArray();
        dfs(res, array, 0);
        return res;
    }

    private void dfs(List<String> res, char[] array, int idx) {
        // base case
        if(idx == array.length){
            res.add(new String(array));
            return;
        }

        Set<Character> set = new HashSet<>();
        // this hashSet, every layer need one!!!!
        // not set exist for all node! only exist for one path
        // 剪枝
        for(int i = idx; i < array.length; i++){
            // set record at each layer, which char we have already tried
            if(!set.contains(array[i])){
                set.add(array[i]);
                swap(array, idx, i);
                dfs(res, array, idx + 1);
                swap(array, idx, i);
            }
        }
        return;
    }

    private void swap(char[] array, int l , int r) {
        char temp = array[l];
        array[l] = array[r];
        array[r] = temp;
        return;
    }
}
