package alg.laioffer.class26.adv3recursionIII.impl;

import alg.laioffer.class26.adv3recursionIII.MaxPathSumFromLeafToRoot;
import alg.laioffer.class5.bintree.TreeNode;

/**
 * passdown the prefix sum
 */
public class MaxPathSumFromLeafToRootTopdownImpl implements MaxPathSumFromLeafToRoot {
  @Override
  public int maxPathSumLeafToRoot(TreeNode root) {
    if(root == null) return 0;
    int[] max = new int[]{Integer.MIN_VALUE};
    recur(root, 0, max);
    return max[0];
  }

  /**
   * this preOrder with PrefixSum
   */
  private void recur(TreeNode root, int prefixSum, int[] max) {
    prefixSum += root.key;
    if(root.left == null && root.right == null) {
      // reach leaf, update max because we require from Leaf To Root
      max[0] = Math.max(max[0], prefixSum);
      return;
    }
    if(root.left != null ) recur(root.left, prefixSum, max);
    if(root.right != null ) recur(root.right, prefixSum, max);
  }
}
