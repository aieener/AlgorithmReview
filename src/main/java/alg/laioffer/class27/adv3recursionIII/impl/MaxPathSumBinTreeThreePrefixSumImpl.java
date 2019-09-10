package alg.laioffer.class27.adv3recursionIII.impl;

import alg.laioffer.class27.adv3recursionIII.MaxPathSumBinTreeThree;
import alg.laioffer.class5.bintree.TreeNode;

public class MaxPathSumBinTreeThreePrefixSumImpl implements MaxPathSumBinTreeThree {
  @Override
  public int maxPathSum(TreeNode root) {
    if (root == null) return 0;
    int[] max = new int[]{root.key};
    recur(root, max, 0);
    return max[0];
  }

  private void recur(TreeNode root, int[] max, int prefixSum) {
    if (root == null) return;

    int newPrefixSum = prefixSum > 0 ? prefixSum + root.key : root.key;
    max[0] = Math.max(max[0], newPrefixSum);
    recur(root.left, max, newPrefixSum);
    recur(root.right, max, newPrefixSum);
  }
}
