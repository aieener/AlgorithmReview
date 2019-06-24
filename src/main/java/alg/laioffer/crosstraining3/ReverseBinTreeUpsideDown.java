package alg.laioffer.crosstraining3;

import alg.laioffer.class4.bintree.TreeNode;

/**
 * Given a binary tree where all the right nodes are leaf nodes,
 * flip it upside down and turn it into a tree with left leaf nodes as the root.
 */
public class ReverseBinTreeUpsideDown {
  public TreeNode reverse(TreeNode root) {
    // base case
    if (root == null || root.left == null) {
      return root;
    }
    // get leftMost leaf
    TreeNode left = reverse(root.left);
    root.left.right = root.right;
    root.left.left = root;
    root.left = null;
    root.right = null;

    return left;
  }

  public TreeNode reverseMyWay(TreeNode root) {
    // base case
    if (root == null || root.left == null) {
      return root;
    }
    // get leftMost leaf
    TreeNode left = reverse(root.left);
    TreeNode right = reverse(root.right);

    TreeNode leftMostLeaf = findLeftMostLeaf(left);
    leftMostLeaf.left = root;
    leftMostLeaf.right = right;
    root.left = null;
    root.right = null;

    return left;
  }

  private TreeNode findLeftMostLeaf(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
}
