package alg.laioffer.class26.recursionII;

import alg.laioffer.class4.bintree.TreeNode;

/**
 * Tree + recur + DP
 * hint : subarray sum from DP
 * 在直上直下的path上
 * both the starting and ending node of the subpath should be
 * on the same path from root to one of the leaf nodes,
 * and the subpath is allowed to contain only one node).
 */
public class MaxPathSumIII {
  public int maxPathSum(TreeNode root) {
    //base case
    if (root == null) return 0;
    int[] max = new int[]{Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }

  // preorder way + DP
  private void helper2(TreeNode root, int[] max, int sum) {
    if(root == null) return;
    if(sum < 0) {
      sum = root.key;
    } else {
      sum += root.key;
    }
    max[0] = Math.max(max[0], sum); // this is preorder
    helper2(root.left, max, sum);
    helper2(root.left, max, sum);
  }
  // 三部曲
  private int helper(TreeNode root, int[] max) {
    // base case
    if (root == null) {
      return 0;
    }
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    int res = Math.max(Math.max(left, right), 0) + root.key; // if smaller then 0, 另起一灶
    max[0] = Math.max(res, max[0]);
    return res;
  }
}