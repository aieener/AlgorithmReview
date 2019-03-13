package WeekendPractice;

public class houseRobberII {
    /**
     * run two times:
     *      run without end
     *      run without start
     */
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int[] nums1 = new int[nums.length -1];
        int[] nums2 = new int[nums.length -1];
        for(int i = 0; i < nums.length - 1; i++){
            nums1[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            nums2[i-1] = nums[i];
        }
        int res1 = rob1(nums1);
        int res2 = rob1(nums2);
        return Math.max(res1,res2);
    }

    public int rob1(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int [] prevNo = new int[nums.length];
        int [] prevYes = new int[nums.length];
        prevNo[0] = 0;
        prevYes[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prevYes[i] = prevNo[i-1] + nums[i];
            prevNo[i] = Math.max(prevNo[i-1],prevYes[i-1]);
        }
        return Math.max(prevYes[prevYes.length- 1], prevNo[prevNo.length - 1]);
    }
}
