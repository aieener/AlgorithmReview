package alg.penn.bloomberg;


import java.util.Arrays;

/**
 * Created by yuding on 2/10/18.
 * LeetCode 283, two pointer same dir
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return ;
        }
        int l = 0;
        int r = 0;
        // 1 3 0 0 12
        //     l
        //          r
        // l : to the left of l, not including l are all non-zero
        // r : to the right or r, not explore
        // between l and r are 0
        while(r < nums.length) {
            if(nums[r] != 0) {
                swap(nums, l, r);
                l++;
            }
            r++;

        }
        return;
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();
//        int[] input = new int[] {0, 1, 0, 3, 12};
        int[] input = new int[] {1};
        mz.moveZeroes(input);
        System.out.print(Arrays.toString(input));
    }
    public void moveZeroes1(int[] nums) {
        if(nums == null || nums.length <=1) {
            return;
        }
        int left = 0;
        int right = 0;
        /**
         *    1 0 0 3 12
         *    l
         *      r
         */
        while(right < nums.length) {
            if(nums[right] == 0 ) {
                right++;
            } else {
                swap2(nums, left,right);
                left++;
                right++;
            }
        }
        return;
    }

    private void swap2(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
