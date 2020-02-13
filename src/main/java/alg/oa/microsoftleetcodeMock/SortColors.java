package alg.oa.microsoftleetcodeMock;

public class SortColors {
    public void sortColors(int[] nums) {
        // 0 0 1 1 2 2
        //       r
        //     l
        //       m
        if (nums == null || nums.length <= 1) return;
        int l = 0; // to the left of l, not including l are all 0s
        int m = 0; // [l,m) are all 1s, [m, r] unexplored
        int r = nums.length - 1; // to the right of r, not including r are all 2s

        while (m <= r) {
            if (nums[m] == 0) {
                swap(nums, l++, m++);
            } else if (nums[m] == 2) {
                swap(nums, r--, m);
            } else {
                m++;
            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
