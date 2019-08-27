package alg.laioffer.crosstraining2.impl;

import alg.laioffer.class4.bintree.TreeNode;
import alg.laioffer.crosstraining2.DeleteInBST;

/**
 * a Hard one!
 */
public class DeleteInBSTImpl implements DeleteInBST {
  @Override
  public TreeNode deleteTree(TreeNode root, int key) {
    if (root == null) return null;
    if (key == root.key) {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else if (root.right.left == null) {
        root.right.left = root.left;
        return root.right;
      } else {
        TreeNode newRoot = deleteSmallest(root.right);
        newRoot.left = root.left;
        newRoot.right = root.right;
        return newRoot;
      }
    } else if (key < root.key) {
      root.left = deleteTree(root.left, key);
    } else {
      root.right = deleteTree(root.right, key);
    }
    return root;
  }

  private TreeNode deleteSmallest(TreeNode root) {
    while (root.left.left != null) {
      root = root.left;
    }
    TreeNode smallest = root.left;
    root.left = root.left.right;
    return smallest;
  }
}
