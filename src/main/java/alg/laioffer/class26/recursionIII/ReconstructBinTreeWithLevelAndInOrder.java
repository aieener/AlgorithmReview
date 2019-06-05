package alg.laioffer.class26.recursionIII;

import alg.laioffer.class4.bintree.TreeNode;

import java.util.*;

/**
 * June 2, needs review, very good problem!
 */
public class ReconstructBinTreeWithLevelAndInOrder {
  public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
    Map<Integer, Integer> inMap = getInOrderIndexMap(inOrder);
    List<Integer> lOrder = new ArrayList<>();
    for(int cur : levelOrder) {
      lOrder.add(cur);
    }
    return helper(lOrder, inMap);
  }

  private TreeNode helper(List<Integer>lOrder, Map<Integer, Integer> inMap) {
    // base case
    if (lOrder.isEmpty()) {
      return null;
    }
    TreeNode root = new TreeNode(lOrder.remove(0));
    int rootIdx = inMap.get(root.key);
    List<Integer> leftLOrder = new ArrayList<>();
    List<Integer> rightLOrder = new ArrayList<>();
    for(Integer cur : lOrder) {
      int curIdx = inMap.get(cur);
      if(curIdx > rootIdx) {
        rightLOrder.add(cur);
      } else {
        leftLOrder.add(cur);
      }
    }
    root.left = helper(leftLOrder, inMap);
    root.right = helper(rightLOrder, inMap);
    return root;
  }

  private Map<Integer, Integer> getInOrderIndexMap(int[] inOrder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inOrder.length; i++) {
      map.put(inOrder[i], i);
    }
    return map;
  }
}
