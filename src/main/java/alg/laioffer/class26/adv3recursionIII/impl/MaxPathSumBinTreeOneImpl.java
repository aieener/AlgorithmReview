package alg.laioffer.class26.adv3recursionIII.impl;

import alg.laioffer.class26.adv3recursionIII.MaxPathSumBinTreeOne;
import alg.laioffer.class5.bintree.TreeNode;

public class MaxPathSumBinTreeOneImpl implements MaxPathSumBinTreeOne {
  @Override
  public int maxPathSum(TreeNode root) {
    int[] max = new int[1];
    max[0] = Integer.MIN_VALUE;
    if (root == null) return max[0];
    recur(root, max);
    return max[0];
  }

  /**
   * @param node root
   * @param max  globalMax
   * @return maxPathSum from Leaf to node
   */
  private int recur(TreeNode node, int[] max) {
    if (node.left == null && node.right == null) {
      return node.key;
    } else if (node.left == null) {
      return node.key + recur(node.right, max);
    } else if (node.right == null) {
      return node.key + recur(node.left, max);
    } else {
      int left = recur(node.left, max);
      int right = recur(node.right, max);
      // update max
      max[0] = Math.max(max[0], node.key + left + right);
      return node.key + Math.max(left, right);
    }
  }
}
