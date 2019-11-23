package alg.laioffer.class26.adv3recursionIII;

import alg.laioffer.class5.bintree.TreeNode;

/**
 * Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum(both the
 * starting and ending node of the subpath should be on the same path from root to one of the leaf nodes,
 * and the subpath is allowed to contain only one node).
 * 直上直下
 */
public interface MaxPathSumBinTreeThree {
  int maxPathSum(TreeNode root);
}
