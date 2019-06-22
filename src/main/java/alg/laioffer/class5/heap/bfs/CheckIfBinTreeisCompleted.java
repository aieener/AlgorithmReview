package alg.laioffer.class5.heap.bfs;

import alg.laioffer.class4.bintree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A good BFS problem
 * CTCI also has this one, 必须掌握！
 * 然而第一次做任然不会...
 * 需要反复复习！
 */
public class CheckIfBinTreeisCompleted {
  public boolean isCompleted(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean foundLastLeaf = false;
    while (!queue.isEmpty()) {
      TreeNode nodeToExpand = queue.poll();
      if (nodeToExpand.left != null) {
        if (foundLastLeaf) return false;
        queue.offer(nodeToExpand.left);
      } else {
        foundLastLeaf = true;
      }
      if (nodeToExpand.right != null) {
        if (foundLastLeaf) return false;
        queue.offer(nodeToExpand.right);
      } else {
        foundLastLeaf = true;
      }
    }
    return true;
  }
}
