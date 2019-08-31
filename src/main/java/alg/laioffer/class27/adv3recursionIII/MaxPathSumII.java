package alg.laioffer.class27.adv3recursionIII;

import alg.laioffer.class5.bintree.TreeNode;

/**
 * May 11, check Sol, need to review all version of maxPathSum
 * from any node to any node (the start node and the end node can be the same).
 * This one is 非直上直下，考虑三部曲：
 * 1. What do you expect from your lchild / rchild
 * 2. What do you want to do in the current layer
 * 3. What do you want to report to your parent
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
