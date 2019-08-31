package alg.laioffer.class25.adv2.impl;

import alg.laioffer.class25.adv2.DeleteInBST;
import alg.laioffer.class5.bintree.TreeNode;

/**
 * Master recursion problem
 */
public class DeleteInBSTSunImpl implements DeleteInBST {
  @Override
  public TreeNode deleteTree(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.key < key) {
      root.right = deleteTree(root.right, key);
    } else if (root.key > key) {
      root.left = deleteTree(root.left, key);
    } else {
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.left == null || root.right == null) {
        return root.left == null ? root.right : root.left;
      } else {
        TreeNode rightSmallest = findSmallest(root.right);
        root.key = rightSmallest.key;
        root.right = deleteTree(root.right, rightSmallest.key);
      }
    }
    return root;
  }

  private TreeNode findSmallest(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
}
