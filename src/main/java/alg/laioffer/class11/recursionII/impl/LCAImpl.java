package alg.laioffer.class11.recursionII.impl;

import alg.laioffer.class11.recursionII.LCA;
import alg.laioffer.class5.bintree.TreeNode;

public class LCAImpl implements LCA {
  @Override
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
    // base case
    if (root == null || root == one || root == two) return root;
    TreeNode leftLCA = lowestCommonAncestor(root.left, one, two);
    TreeNode rightLCA = lowestCommonAncestor(root.right, one, two);
    if (leftLCA != null && rightLCA != null) return root;
    else if (leftLCA != null) return leftLCA;
    else return rightLCA;
  }
}
