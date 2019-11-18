package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.KnaryTreeNode;
import alg.laioffer.class23.adv1ArrayLCA.LCASix;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCASixImpl implements LCASix {
  @Override
  public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
    Set<KnaryTreeNode> nodeSets = new HashSet<>(nodes);
    return lcaHelper(root, nodeSets);
  }

  private KnaryTreeNode lcaHelper(KnaryTreeNode root, Set<KnaryTreeNode> nodeSets) {
    if (root == null || nodeSets.contains(root)) return root;
    KnaryTreeNode res = null;
    int counter = 0;
    for (KnaryTreeNode child : root.children) {
      KnaryTreeNode curRes = lcaHelper(child, nodeSets);
      if (curRes != null) {
        counter++;
        res = curRes;
      }
      if (counter == 2) return root;
    }
    return res;
  }
}
