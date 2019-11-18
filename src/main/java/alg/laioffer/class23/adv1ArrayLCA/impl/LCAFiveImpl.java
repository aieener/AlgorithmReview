package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.KnaryTreeNode;
import alg.laioffer.class23.adv1ArrayLCA.LCAFive;

/**
 * only two cases:
 * directly related --> return 'older' root;
 * unDirectly related --> return root
 */
public class LCAFiveImpl implements LCAFive {
  @Override
  public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
    if (root == null || root == a || root == b) return root;
    int counter = 0;
    KnaryTreeNode res = null;
    for (KnaryTreeNode child : root.children) {
      KnaryTreeNode curRes = lowestCommonAncestor(child, a, b);
      if (curRes != null) {
        res = curRes;
        counter++;
      }
      if (counter == 2) return root;
    }
    return res;
  }
}
