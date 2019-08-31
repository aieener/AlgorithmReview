package alg.laioffer.class19.recursionII.impl;

import alg.laioffer.class19.recursionII.StoreNumOfNodesInLeftSubtree;
import alg.laioffer.class19.recursionII.TreeNodeLeft;

/**
 * Aug 28
 */
public class StoreNumOfNodesInLeftSubtreeImpl implements StoreNumOfNodesInLeftSubtree {
  @Override
  public void numNodesLeft(TreeNodeLeft root) {
    recurHelper(root);
  }

  private int recurHelper(TreeNodeLeft node) {
    // base case
    if (node == null) return 0;
    int leftAmt = recurHelper(node.left);
    int rightAmt = recurHelper(node.right);
    node.numNodesLeft = leftAmt;
    return leftAmt + rightAmt + 1;
  }
}
