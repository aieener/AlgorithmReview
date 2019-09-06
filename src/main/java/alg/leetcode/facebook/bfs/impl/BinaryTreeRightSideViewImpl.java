package alg.leetcode.facebook.bfs.impl;

import alg.laioffer.class5.bintree.TreeNode;
import alg.leetcode.facebook.bfs.BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeRightSideViewImpl implements BinaryTreeRightSideView {
  @Override
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int layerWidth = queue.size();
      for (int i = 0; i < layerWidth; i++) {
        TreeNode nodeToExpand = queue.poll();
        if (nodeToExpand.left != null) {
          queue.offer(nodeToExpand.left);
        }
        if (nodeToExpand.right != null) {
          queue.offer(nodeToExpand.right);
        }
        if(i == layerWidth - 1) {
          result.add(nodeToExpand.key);
        }
      }
    }
    return result;
  }
}
