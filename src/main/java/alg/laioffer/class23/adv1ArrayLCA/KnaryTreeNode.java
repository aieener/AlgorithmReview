package alg.laioffer.class23.adv1ArrayLCA;

import java.util.ArrayList;
import java.util.List;

public class KnaryTreeNode {
  public int key;
  public List<KnaryTreeNode> children;

  public KnaryTreeNode(int key) {
    this.key = key;
    this.children = new ArrayList<>();
  }
}
