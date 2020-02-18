package alg.oa.microsoftRealOA;

/**
 * leetcode 1306 JumpGame III
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 * Notice that you can not jump outside of the array at any time.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 * Example 2:
 * <p>
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true
 * Explanation:
 * One possible way to reach at index 3 with value 0 is:
 * index 0 -> index 4 -> index 1 -> index 3
 * Example 3:
 * <p>
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 */
public class JumGame {
  public boolean canReach(int[] arr, int st) {
    boolean[] visited = new boolean[arr.length];
    return dfs(arr, st, visited);
  }

  private boolean dfs(int[] arr, int st, boolean[] visited) {
    if (st < 0 || st >= arr.length || visited[st]) return false;
    int jump = arr[st];
    visited[st] = true;
    return jump == 0 || dfs(arr, st + jump, visited) || dfs(arr, st - jump, visited);
  }
}
