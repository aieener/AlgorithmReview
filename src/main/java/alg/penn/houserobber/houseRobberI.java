package alg.penn.houserobber;

public class houseRobberI {
    /**
     * M[i] represents maxMoney robbing from 0 to i including i
     * M[i] = M[i - 2] + nums[i]
     */
    public int rob2 (int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int [] prevYes = new int[nums.length];
        int [] prevNo = new int[nums.length];
        prevYes[0] = 0; // not rob i
        prevNo[0] = nums[0]; // rob i
        for(int i = 1; i < nums.length; i++) {
            prevNo[i] = prevYes[i-1] + nums[i];
            prevYes[i] = Math.max(prevYes[i-1],prevNo[i-1]);
        }
        return Math.max(prevYes[prevYes.length- 1], prevNo[prevNo.length - 1]);
    }

    public int rob(int[] nums) {
        int prevMax = 0;
        int curMax = 0;

        for(int i = 0; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(prevMax + nums[i], curMax);
            prevMax = temp;
        }
        return curMax;
    }
}
