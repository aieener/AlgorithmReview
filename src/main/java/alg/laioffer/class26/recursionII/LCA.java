package alg.laioffer.class26.recursionII;

import alg.laioffer.class4.bintree.TreeNode;

/**
 * time = O(n)
 * tree traversal from bottom up
 * 三部曲
 */
public class LCA {
  public TreeNode lowestComonAncestor(TreeNode root, TreeNode one, TreeNode two) {
    // base case
    if(root == null || one == root || two == root) return root;

    TreeNode left = lowestComonAncestor(root.left, one, two);
    TreeNode right = lowestComonAncestor(root.right, one, two);

    if(left != null && right != null) {
      return root;
    }
    if(left != null) return left;
    if(right != null) return right;
    return null;
  }
}