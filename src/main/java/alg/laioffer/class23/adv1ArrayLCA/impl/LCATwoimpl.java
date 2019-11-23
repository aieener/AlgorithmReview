package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.LCATwo;
import alg.laioffer.class26.adv3recursionIII.TreeNodeP;

public class LCATwoimpl implements LCATwo {
  @Override
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    if (one == null || two == null) return null;
    int oneHeight = findHeight(one);
    int twoHeight = findHeight(two);
    int heightDiff = Math.abs(oneHeight - twoHeight);
    TreeNodeP deeperNode = oneHeight > twoHeight ? one : two;
    TreeNodeP shallowerNode = oneHeight > twoHeight ? two : one;
    for (int i = 0; i < heightDiff; i++) {
      deeperNode = deeperNode.parent;
    }
    while (deeperNode != shallowerNode) {
      deeperNode = deeperNode.parent;
      shallowerNode = shallowerNode.parent;
    }
    return deeperNode;
  }

  private int findHeight(TreeNodeP node) {
    int height = 0;
    while (node != null) {
      node = node.parent;
      height++;
    }
    return height;
  }
}
