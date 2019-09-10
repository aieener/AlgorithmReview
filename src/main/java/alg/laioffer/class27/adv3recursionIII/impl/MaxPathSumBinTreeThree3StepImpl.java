package alg.laioffer.class27.adv3recursionIII.impl;

import alg.laioffer.class27.adv3recursionIII.MaxPathSumBinTreeThree;
import alg.laioffer.class5.bintree.TreeNode;

public class MaxPathSumBinTreeThree3StepImpl implements MaxPathSumBinTreeThree {
  @Override
  public int maxPathSum(TreeNode root) {
    //base case
    if (root == null) return 0;
    int[] max = new int[]{Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }

  private int helper(TreeNode node, int[] max) {
    if (node == null) return 0;
    int left = Math.max(0, helper(node.left, max));
    int right = Math.max(0, helper(node.right, max));
    int res = Math.max(left, right) + node.key;
    max[0] = Math.max(res, max[0]);
    return res;
  }
}
