package alg.penn.bloomberg;

/**
 * DP 基础题, LaiOffer also has this one
 */
public class MaxSubarray {
    /**
     * My non-optimized version
     * M[i] stands for from 0th to ith the value of the largest sum of the subarray
     *      INCLUDING THE ITH ELEMENT!!!
     * M[0] = nums[0]
     * M[i] = M[i - 1] + nums[i]   , if M[i - 1] > 0
     *        nums[i]              , else
     */
    public int maxSubArray(int [] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] M = new int[nums.length];
        M[0] = nums[0];
        int res = M[0];
        for(int i = 1; i < nums.length; i++) {
            M[i] = Math.max(M[i - 1] + nums[i], nums[i]);
            res = Math.max(res, M[i]);
        }
        return res;
    }

    /**
     * For OPT since we only using M[i - 1], we only need 1 vars
     */
    public int maxSubArrayOpt (int [] nums) {
         if(nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int lastMax = nums[0]; // including curr elem
        for(int i = 0 ;i < nums.length; i++) {
            lastMax = Math.max(nums[i], nums[i] + lastMax);
            maxSum = Math.max(maxSum,lastMax );
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubarray ms = new MaxSubarray();
        int [] input= new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(ms.maxSubArray(input));
    }

    //-------- prac ----------
    public int maxS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int M = nums[0];
        int globalMax = nums[0];
        //M[i] --> represent the maxinum sum at idx i, including i;
//        M[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
                M = Math.max(nums[i],M + nums[i]);
                globalMax = Math.max(M, globalMax);
        }
        return globalMax;
    }
}
