package alg.laioffer.crosstraining1;

import alg.laioffer.class5.bintree.TreeNode;

import java.util.*;

public class BinTreeZigZagTranversal {
  public List<Integer> zigZag(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offerFirst(root);
    boolean orderSwitch = true;
    while (!queue.isEmpty()) {
      int layerLen = queue.size();
      for (int i = 0; i < layerLen; i++) {
        TreeNode cur = orderSwitch ? queue.pollLast() : queue.pollFirst();
        res.add(cur.key);
        if (orderSwitch) {
          if (cur.right != null) {
            queue.offerFirst(cur.right);
          }
          if (cur.left != null) {
            queue.offerFirst(cur.left);
          }
        } else {
          if (cur.left != null) {
            queue.offerLast(cur.left);
          }
          if (cur.right != null) {
            queue.offerLast(cur.right);
          }
        }
      }
      orderSwitch = !orderSwitch;
    }
    return res;
  }
}
