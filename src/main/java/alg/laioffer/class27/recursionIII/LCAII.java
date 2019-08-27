package alg.laioffer.class27.recursionIII;

public class LCAII {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    if (one == null || two == null) return null;
    // get length
    int oneLen = getLen(one);
    int twoLen = getLen(two);

    if (oneLen < twoLen) {
      two = moveUp(two, twoLen - oneLen);
    } else {
      one = moveUp(one, oneLen - twoLen);
    }
    return findCA(one, two);
  }

  private TreeNodeP findCA(TreeNodeP one, TreeNodeP two) {
    while (one !=two && two != null) {
      if (one == two) return one;
      one = one.parent;
      two = two.parent;
    }
    return null;
  }

  private TreeNodeP moveUp(TreeNodeP node, int level) {
    while (level != 0) {
      node = node.parent;
      level--;
    }
    return node;
  }

  private int getLen(TreeNodeP node) {
    int len = 0;
    while (node != null) {
      node = node.parent;
      len++;
    }
    return len;
  }
}
