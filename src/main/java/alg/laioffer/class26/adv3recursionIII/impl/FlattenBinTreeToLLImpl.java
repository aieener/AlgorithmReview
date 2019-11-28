package alg.laioffer.class26.adv3recursionIII.impl;

import alg.laioffer.class26.adv3recursionIII.FlattenBinTreeToLL;
import alg.laioffer.class5.bintree.TreeNode;

public class FlattenBinTreeToLLImpl implements FlattenBinTreeToLL {
  @Override
  public TreeNode flatten(TreeNode root) {
    if (root == null) return root;
    TreeNode leftFlat = flatten(root.left);
    TreeNode rightFlat = flatten(root.right);
    TreeNode leftRightLeaf = getRightLeaf(leftFlat);
    if (leftFlat != null) {
      root.right = leftFlat;
      leftRightLeaf.right = rightFlat;
    } else {
      root.right = rightFlat;
    }
    root.left = null;

    return root;
  }

  private TreeNode getRightLeaf(TreeNode node) {
    if (node == null) return node;
    while (node.right != null) {
      node = node.right;
    }
    return node;
  }
}
