package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.LCAThree;
import alg.laioffer.class5.bintree.TreeNode;

/**
 * case 1 direct
 * cass 2 undirect
 */
public class LCAThreeImpl implements LCAThree {
  @Override
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
    if (lca(root, one, one) != null && lca(root, two, two) != null) return lca(root, one, two);
//    if (lca(root, one, null) != null && lca(root, two, null) != null) return lca(root, one, two);
    return null;
  }

  private TreeNode lca(TreeNode root, TreeNode one, TreeNode two) {
    if (root == null || root == one || root == two) return root;
    TreeNode left = lca(root.left, one, two);
    TreeNode right = lca(root.right, one, two);
    if (left != null && right != null) return root;
    else if (left != null) return left;
    else return right;
  }
}

