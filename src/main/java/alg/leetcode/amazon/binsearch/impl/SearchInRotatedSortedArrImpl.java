package alg.leetcode.amazon.binsearch.impl;

import alg.leetcode.amazon.binsearch.SearchInRotatedSortedArr;

public class SearchInRotatedSortedArrImpl implements SearchInRotatedSortedArr {
  @Override
  public int search(int[] nums, int target) {
    if(nums == null || nums.length == 0) return -1;
    int start = 0;
    int end = nums.length - 1;
    while(start + 1 < end) {
      int mid = start + (end - start ) / 2;
      if(nums[mid] >= nums[start]) {
        // left chunk is sorted
        if(nums[start] <= target && target <= nums[mid]) {
          end = mid;
        } else {
          start = mid;
        }
      } else {
        // right chunk is sorted
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
}
