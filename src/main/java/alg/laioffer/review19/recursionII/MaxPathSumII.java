package alg.laioffer.review19.recursionII;

import alg.laioffer.class4.bintree.TreeNode;

/**
 * May 11, check Sol, need to review all version of maxPathSum
 */
public class MaxPathSumII {
  public int maxPathSum(TreeNode root) {
    if (root == null) return 0;
    int [] max = new int[] {Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }

  private int helper(TreeNode node, int[] max) {
    // base
    if(node == null) return 0;
    int left = helper(node.left, max);
    int right = helper(node.right, max);
    left = Math.max(0, left);
    right = Math.max(0, right);
    max[0] = Math.max(node.key+ left + right, max[0]); // the only diff with root to leaf version
    return node.key + Math.max(left, right);

  }

}
