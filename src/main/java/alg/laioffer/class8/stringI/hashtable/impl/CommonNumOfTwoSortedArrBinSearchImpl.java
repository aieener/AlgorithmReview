package alg.laioffer.class8.stringI.hashtable.impl;

import alg.laioffer.class8.stringI.hashtable.CommonNumberOfTwoSortedArrs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonNumOfTwoSortedArrBinSearchImpl implements CommonNumberOfTwoSortedArrs {
    @Override
    public List<Integer> common(int[] A, int[] B) {
        int[] shorter = A.length < B.length ? A : B;
        int[] longer = A == shorter ? B : A;
        List<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (Integer val : shorter) {
            int idx = binSearchFirstOccur(longer, val, visited);
            if (idx != -1 && !visited.contains(idx)) {
                res.add(val);
                visited.add(idx);
            }
        }
        return res;
    }

    private int binSearchFirstOccur(int[] arr, int target, Set<Integer> visited) {
        int start = 0;
        int end= arr.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start ) / 2;
            if(target <= arr[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(arr[start] == target && !visited.contains(start)) return start;
        else if (arr[end] == target && !visited.contains(end)) return end;
        else {
            while(arr[end] == target && visited.contains(end)) {
                end++;
            }
            if(arr[end] == target) return end;
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] A = new int[]{1,3,3,3};
        int[] B = new int[]{1,2,3,4,5,6};
        System.out.println(new CommonNumOfTwoSortedArrBinSearchImpl().common(A, B).toString());
    }
}
