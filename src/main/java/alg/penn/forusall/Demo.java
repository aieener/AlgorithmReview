package alg.penn.forusall;

import java.util.HashSet;
import java.util.Set;

public class Demo {
    public int solution(int[] A) {
        if(A == null || A.length == 0){
            return 1;
        }
        // find max
        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            if(A[i] > globalMax) {
                globalMax = A[i];
            }
            if(A[i] < globalMin) {
                globalMin = A[i];
            }
            set.add(A[i]);
        }

        globalMin = Math.max(0, globalMin);
        globalMax = Math.max(0, globalMax);
        // create a set that contains globalMin to globalMax
        if(globalMax == 0) {
            return 1;
        }
        for(int i =  globalMin; i <= globalMax; i++) {
            if(!set.contains(i)){
                return i;
            }
        }

        return globalMax + 1;
    }

    public static void main(String[] args) {
        Demo de = new Demo();
//        int [] arr = {1,3,6,4,1,2};
        int [] arr = {-1,-3};
        int res = de.solution(arr);

        System.out.println(res);
    }
}
