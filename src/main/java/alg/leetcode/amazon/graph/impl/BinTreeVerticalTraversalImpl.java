package alg.leetcode.amazon.graph.impl;

import alg.laioffer.class5.bintree.TreeNode;
import alg.leetcode.amazon.graph.BinTreeVerticalTraversal;

import java.util.*;

/**
 * TreeMap + BFS
 */
public class BinTreeVerticalTraversalImpl implements BinTreeVerticalTraversal {
  @Override
  public List<List<Integer>> verticalOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();
    Map<Integer, List<Integer>> map = map(root);
    return new ArrayList<>(map.values());
  }

  private Map<Integer, List<Integer>> map(TreeNode root) {
    Map<Integer, List<Integer>> map = new TreeMap<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(0, root));

    while (!queue.isEmpty()) {
      Pair nodeToExpand = queue.poll();
      int curX = nodeToExpand.x;
      if (!map.containsKey(curX)) map.put(curX, new ArrayList<>());
      map.get(curX).add(nodeToExpand.node.key);
      if (nodeToExpand.node.left != null) {
        queue.offer(new Pair(curX - 1, nodeToExpand.node.left));
      }
      if (nodeToExpand.node.right != null) {
        queue.offer(new Pair(curX + 1, nodeToExpand.node.right));
      }
    }
    return map;
  }

  private class Pair {
    int x;
    TreeNode node;

    Pair(int x, TreeNode node) {
      this.x = x;
      this.node = node;
    }
  }
}
