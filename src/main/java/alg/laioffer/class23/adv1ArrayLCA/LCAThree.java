package alg.laioffer.class23.adv1ArrayLCA;

import alg.laioffer.class5.bintree.TreeNode;

/**
 * given two node, find lca, two node are not guaranteed to be in the tree
 */
public interface LCAThree {
  TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two);
}
