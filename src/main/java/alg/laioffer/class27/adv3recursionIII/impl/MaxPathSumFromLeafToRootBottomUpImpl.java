package alg.laioffer.class27.adv3recursionIII.impl;

import alg.laioffer.class27.adv3recursionIII.MaxPathSumFromLeafToRoot;
import alg.laioffer.class5.bintree.TreeNode;

public class MaxPathSumFromLeafToRootBottomUpImpl implements MaxPathSumFromLeafToRoot {
  @Override
  public int maxPathSumLeafToRoot(TreeNode root) {
    if (root.left == null && root.right == null) return root.key;
    if (root.left == null) return root.key + maxPathSumLeafToRoot(root.right);
    if (root.right == null) return root.key + maxPathSumLeafToRoot(root.left);
    return root.key + Math.max(maxPathSumLeafToRoot(root.left), maxPathSumLeafToRoot(root.right));
  }
}
