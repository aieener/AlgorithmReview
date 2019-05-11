package alg.penn.vmware;

public class SearchInRotatedSortedArray {
    /**
     * My Bad Sol
     * A lot of dumb work
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        // first find rotate pivot
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[start] < nums[mid]){
                start = mid;
            } else {
                end = mid;
            }
        }
        int MaxIdx = 0; // this is the MaxIdx
        if(nums[start] > nums[end]){
            MaxIdx = start;
        } else {
            MaxIdx = end;
        }
        System.out.println(MaxIdx);

        int rotateOffset = (MaxIdx + 1 ) % nums.length;
        // now search for the target
        int [] orinums = rotate(nums, rotateOffset);
        start = 0;
        end = orinums.length - 1;
        while(start + 1 < end ) {
            int mid = start + (end - start) /2;
            if(orinums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(orinums[start] == target) {
            return (start + rotateOffset) % nums.length;
        } else if(orinums[end] == target) {
            return (end + rotateOffset) % nums.length;
        }
        return -1;
    }

    private int [] rotate(int[] nums, int pivot) {
        int [] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int idx = (i + pivot) % nums.length;
            res[i] = nums[idx];
        }
        return res;
    }

    public int search2(int[] nums, int target) {
        /**
         * NineChap Sol
         */
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int start =0;
        int end = nums.length - 1;
        int mid;
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            // increase line
            if(nums[start] < nums[mid]) {
                if(nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // decrease line
                if(nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if(nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int [] nums = new int[] {1,3,5};
        int [] nums2 = new int[] {4,5,6,7,0,1,2,3};
        int res = s.search(nums, 3);
        System.out.println(res);

        int res2 = s.search(nums2, 3);
        System.out.println(res2);

    }
}
