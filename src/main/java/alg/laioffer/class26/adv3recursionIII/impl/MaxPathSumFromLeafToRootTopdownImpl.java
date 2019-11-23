package alg.laioffer.class26.adv3recursionIII.impl;

import alg.laioffer.class26.adv3recursionIII.MaxPathSumFromLeafToRoot;
import alg.laioffer.class5.bintree.TreeNode;

/**
 * passdown the prefix sum
 */
public class MaxPathSumFromLeafToRootTopdownImpl implements MaxPathSumFromLeafToRoot {
  @Override
  public int maxPathSumLeafToRoot(TreeNode root) {
    return recur(root, 0);
  }

  private int recur(TreeNode root, int prefixSum) {
    prefixSum += root.key;
    if (root.left == null && root.right == null) {
      // reach leaf
      return prefixSum;
    } else if (root.left == null) {
      return recur(root.right, prefixSum);
    } else if (root.right == null) {
      return recur(root.left, prefixSum);
    }
    return Math.max(recur(root.left, prefixSum), recur(root.right, prefixSum));
  }
}
