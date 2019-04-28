package Class_05_Heap_GraphSearch;

import Class_04_BinTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS 最最基础的基础题
 */
public class GetKeyinBTreelayerBylayer {
  public List<List<Integer>> layerByLayer(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if(root == null) return res;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> curLevel = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode nodeToExpand = queue.poll();
        curLevel.add(nodeToExpand.key);
        if(nodeToExpand.left != null) {
          queue.offer(nodeToExpand.left);
        }
        if (nodeToExpand.right != null) {
          queue.offer(nodeToExpand.right);
        }
      }
      res.add(curLevel);
    }
    return res;
  }
}
