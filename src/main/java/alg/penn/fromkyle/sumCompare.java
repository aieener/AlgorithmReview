package alg.penn.fromkyle;

import java.util.ArrayList;
import java.util.List;

public class sumCompare {
    public int sumCompare(int[] input) {
        List<Integer> curSet = new ArrayList<Integer>();
        int [] res = new int[1];
        helper(input, res, curSet, 0);
        return res[0];
    }

    private void helper(int[] input, int[] res, List<Integer> curSet, int idx) {
        // base case
        if(idx == input.length) {
            int curRes = calSum(curSet);
            if(curRes >= res[0]) {
                System.out.println(res[0]);
                res[0] = curRes;
            }
            return;
        }
        // don't add
        helper(input, res, curSet, idx + 1);
            curSet.add(input[idx]);
            helper(input, res, curSet, idx + 1);
            curSet.remove(curSet.size() - 1);
        return;
    }


    private int calSum(List<Integer> input) {
        if(input.size() == 0) {
            return 0;
        }
        int min = input.get(0);
        int sum = 0;
//        Set<Integer> set = new HashSet<>();
        for(int i : input) {
            if(i <= min) {
                min = i;
            }
//            if(!set.contains(i)) {
            sum += i;
//            }
//            set.add(i);
        }
        return sum * min;
    }

    public static void main(String[] args) {
        sumCompare sc = new sumCompare();
//        int [] input = new int[] {6,2,1};
        int [] input = new int[] {81,87,47,59,81,18,25,40,56};
        System.out.println(sc.sumCompare(input));
    }

}
