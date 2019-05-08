package alg.review.recursionII;

import Class_04_BinTree.TreeNode;

public class MaxPathSumIII {
  public int maxPathSum(TreeNode root) {
    //base case
    if (root == null) return 0;
    int[] max = new int[]{Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }

  private int helper(TreeNode root, int[] max) {
    // base case
    if (root == null) {
      return 0;
    }
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    int res = Math.max(Math.max(left, right), 0) + root.key;
    max[0] = Math.max(res, max[0]);
    return res;
  }
}