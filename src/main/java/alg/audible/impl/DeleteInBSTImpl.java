package alg.audible.impl;

import alg.laioffer.class25.adv2.DeleteInBST;
import alg.laioffer.class5.bintree.TreeNode;

/**
 * a Hard one!
 */
public class DeleteInBSTImpl implements DeleteInBST {
  @Override
  public TreeNode deleteTree(TreeNode root, int key) {
    if (root == null) return null;
    if (root.key > key) {
      root.left = deleteTree(root.left, key);
    } else if (root.key < key) {
      root.right = deleteTree(root.right, key);
    } else {
      return deleteRoot(root);
    }
    return root;
  }

  private TreeNode deleteRoot(TreeNode root) {
    if (root.left == null && root.right == null) {
      return null;
    } else if (root.right == null || root.left == null) {
      return root.left == null ? root.right : root.left;
    } else {
      if (root.right.left == null) {
        root.right.left = root.left;
        return root.right;
      } else {
        TreeNode newRoot = deleteSmallest(root.right);
        newRoot.left = root.left;
        newRoot.right = root.right;
        return newRoot;
      }
    }
  }

  private TreeNode deleteSmallest(TreeNode node) {
    while (node.left.left != null) {
      node = node.left;
    }
    TreeNode smallestParent = node;
    TreeNode smallest = smallestParent.left;
    smallestParent.left = smallest.right;
    return smallest;
  }

  //---- simplify impl
  private TreeNode deleteTreeSim(TreeNode root, int key) {
    if (root == null) return null;
    if (root.key < key) {
      root.right = deleteTreeSim(root.right, key);
    } else if (root.key > key) {
      root.left = deleteTreeSim(root.left, key);
    } else {
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.left == null || root.right == null) {
        return root.left == null ? root.right : root.left;
      } else {
        TreeNode rightSmallest = findSmallest(root.right);
        root.key = rightSmallest.key;
        root.right = deleteTreeSim(root.right, rightSmallest.key);
      }
    }
    return root;
  }

  private TreeNode findSmallest(TreeNode node) {
    if (node == null) return null;
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
}
