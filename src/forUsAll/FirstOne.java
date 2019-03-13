package forUsAll;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstOne {
    public int solution(int N) {
        if(N == 0) {
            return 1;
        }
        String strN = Integer.toString(N);
        char [] arrN = strN.toCharArray();
        List<String> allPerms = permutations(strN);
        List<String> cpyAllPerms = new ArrayList<>(allPerms);
        System.out.println(allPerms);
        for(String curStr : allPerms) {
            // drop the 0 leading ones
            if(curStr.charAt(0) == '0'){
                cpyAllPerms.remove(curStr);
            }
        }
        return cpyAllPerms.size();
    }

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
        // set is used for dedup
        for(int i = idx; i < array.length; i++){
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

    public static void main(String[] args) {
        FirstOne fo = new FirstOne();
//        int N = 1213;
        int N = 100;
        int res = fo.solution(N);
        System.out.println(res);

    }
}
