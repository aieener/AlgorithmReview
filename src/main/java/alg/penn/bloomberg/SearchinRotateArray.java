package alg.penn.bloomberg;


/**
 * LeetCode 33
 */
public class SearchinRotateArray {
    /**
     * Bin search
     * 4 5 6 7 0 1 2
     *       /
     *     /
     *   /
     * /
     *             /
     *           /
     *         /
     */
    public int search(int[] nums, int target) {
        if( nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            // left
            if(nums[mid] == target) {
                return  mid;
            } else if(nums[start] < nums[mid] ) {
                if(nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
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
        } else {
            return -1;
        }
    }
    /**
     * NineChap Sol
     */
    public int search2(int[] nums, int target){
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
        SearchinRotateArray sa = new SearchinRotateArray();
        int[] input = {4,5,6,7,0,1,2};
        System.out.println(sa.search(input, 6));
    }

    //------ prac -------
    public int search5(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        /**
         *
         *    /
         *   /
         *  /
         *       /
         *      /
         */
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) /2;
            if(nums[start] < nums[mid] ) {
                // upper
                if(target >= nums[start] && target <= nums[mid]) {
                    end= mid;
                } else {
                    start = mid;
                }
            } else {
                // lower
                if(target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if(nums[start] == target) {
            return start;
        } else if (nums[end] == target)  {
            return end;
        } else {
            return -1;
        }
    }
}
