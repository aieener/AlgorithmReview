package alg.laioffer.class27.adv3recursionIII.impl;

import alg.laioffer.class27.adv3recursionIII.MaxPathSumBinTreeTwo;
import alg.laioffer.class5.bintree.TreeNode;

/**
 * last Review : Sep 9
 * from any node to any node (the start node and the end node can be the same).
 * This one is 非直上直下，考虑三部曲：
 * 1. What do you expect from your lchild / rchild
 * 2. What do you want to do in the current layer
 * 3. What do you want to report to your parent
 */
public class MaxPathSumBinTreeTwoImpl implements MaxPathSumBinTreeTwo {
  @Override
  public int maxPathSum(TreeNode root) {
    int[] max = new int[1];
    max[0] = root.key;
    recur(root, max);
    return max[0];
  }

  /**
   * @param node root
   * @param max  globalMax
   * @return maxPath from childNode to node (within the path from node to leaf)
   */
  private int recur(TreeNode node, int[] max) {
    // base case reach leaf
    if (node == null) return 0;
    int left = Math.max(0, recur(node.left, max));
    int right = Math.max(0, recur(node.right, max));
    max[0] = Math.max(max[0], node.key + left + right);
    return node.key + Math.max(left, right);
  }
}
