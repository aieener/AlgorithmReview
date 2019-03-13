package Bloomberg_71_leetCode;

import java.util.Arrays;

/**
 * LeetCode 287
 * This one is very interesting!
 * Need revisit!!!!
 * Two Ptr + find Cycle
 */
public class findDupNum {
    /**
     * Sol1 zuo bi fa
     * Cant's sort it!!!!!!!!!!!!!!!!!
     * This one doesn't count!!!!!!!!!
     */
    public int findDuplicates(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(prev == nums[i]) {
                return prev;
            }
            prev = nums[i];
        }
        return prev;
    }

    /**
     * Sol 2
     * Two Ptr, slow and fast
     * mapping method
     * since the range is from 1 to n and
     * there are n + 1 of it so index from 0 to n
     *
     * s = num[s]
     * f = nums[nums[f]] --> fast 走两步
     * -->circular list, they must meet because
     *      there is a dup number!
     *
     *          s
     * idx  0 1 2 3 4
     * arr  1 2 3 4 2
     *          f
     * Find circle 的变种！！！
     */
    public int findDuplicate2(int [] nums) {

        if(nums.length<= 1) {
            return -1;
        }
        int slow = nums[0]; // val
        int fast = nums[nums[0]]; // idx
        // do mapping
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]]; // if there is a dp fast will stop
        }

        // reset fast to head
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    /**
     * Sol 3 binSearch
     * idx  0 1 2 3 4
     * arr  1 3 2 4 2
     */
    public int findDuplicate3(int [] nums) {
        int start = 1;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(check_smaller_num(mid,nums) <= mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(check_smaller_num(start,nums) <= start) {
            return end;
        }
        return start;
    }

    private int check_smaller_num(int mid, int [] nums) {
        // check how many num are <= mid
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= mid) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] in = {1,1};
        findDupNum fd = new findDupNum();
        System.out.println(fd.findDuplicates(in));
    }

    //---- prac ---
    public int findDup(int[] nums) {
        if(nums.length <= 1) {
            return -1;
        }
        int fast = nums[nums[0]];
        int slow = nums[0];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // found cycle
        fast = 0;
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
