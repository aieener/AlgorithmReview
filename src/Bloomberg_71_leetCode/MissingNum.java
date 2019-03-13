package Bloomberg_71_leetCode;

public class MissingNum {
    public int missingNumber(int[] nums) {
        long sum = 0;
        long fulSum = 0;
        for(int i = 0; i < nums.length; i++) {
            fulSum += i;
            sum += nums[i];
        }
        fulSum += nums.length;
        return (int) (fulSum - sum);
    }

    /**
     * xor sol
     */
    public int missingNumber2(int[] nums) {
        int res = 0;
        for(int i =0; i < nums.length + 1; i++) {
            res ^= i;
        }

        for(int num : nums) {
            res ^= num;
        }
        return res;
    }

    public int missingNumber3(int[] nums) {
        int res = 0;
        for(int i =0; i < nums.length ; i++) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;

        return res;
    }
}
