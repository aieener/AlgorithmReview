package alg.imooc.dp.impl;

import alg.imooc.dp.PascalTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleImpl implements PascalTriangle {
    @Override
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        // base case and create list
        res.add(Arrays.asList(1));
        for(int i = 1; i < numRows; i++) {
            int[] curArr = new int[i + 1];
            curArr[0] = 1;
            curArr[i] = 1;
            List<Integer> prevList = res.get(i - 1);
            for(int j = 1; j < i; j++) {
                curArr[j] = prevList.get(j) + prevList.get(j - 1);
            }
            res.add(getList(curArr));
        }
        return res;
    }

    private List<Integer> getList(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
