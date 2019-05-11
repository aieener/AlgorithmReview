package alg.laioffer.class13.dp2;

public class LargestSubarraySum {
    /**
     * Last review Feb 25 2019
     * My Sol following my Notes without optimization
     * @param array
     */
    public int largestSum(int[] array) {
        if(array== null || array.length == 0) {
            return 0;
        }
        int[] M = new int[array.length];
        M[0] = array[0]; // base case

        int globalMax = Integer.MIN_VALUE;
        for(int i = 1; i < array.length; i++) {
            if(M[i - 1] > 0) {
                M[i] = M[i - 1] + array[i];
            } else {
                M[i] = array[i];
            }
            if(M[i] > globalMax) {
                globalMax = M[i];
            }
        }
        return globalMax;
    }

    /**
     * LaiOffer's Sol
     */

    public static void main(String[] args) {
        LargestSubarraySum ls = new LargestSubarraySum();
        int[] arr = new int[]{-4,-6,-2,-3};
    }

    /**
     * This version gives start and end bounds
     */

    public int[] largestSum2(int[] array) {
        // Write your solution here
        int [] M = new int[array.length];
        M[0] = array[0];
        int [] res = new int[3];
        res[0] = Integer.MIN_VALUE;
        res[1] = 0;
        for(int i = 1; i < array.length; i++){
            if(M[i - 1] > 0){
                M[i] = M[i - 1] + array[i];
            } else {
                M[i] = array[i];
                if(M[i] > res[0]) {
                    res[1] = i;
                }
            }

            if(M[i] > res[0]){
                res[0] = M[i];
                res[2] = i;
            }
        }
        return res;
    }
}
