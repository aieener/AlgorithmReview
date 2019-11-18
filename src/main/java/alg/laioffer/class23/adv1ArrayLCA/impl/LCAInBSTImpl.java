package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.LCAInBST;
import alg.laioffer.class5.bintree.TreeNode;

public class LCAInBSTImpl implements LCAInBST {
  @Override
  public TreeNode lca(TreeNode root, int p, int q) {
    if (root == null || root.key == p || root.key == q) return root;
    if (root.key > p && root.key > q) {
      // search left
      return lca(root.left, p, q);
    } else if (root.key < p && root.key < q) {
      // search right
      return lca(root.right, p, q);
    } else {
      return root;
    }
  }
}
