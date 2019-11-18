package alg.laioffer.class27.adv3recursionIII.impl;

import alg.laioffer.class27.adv3recursionIII.ReconstructBinTreeWithLevelAndIn;
import alg.laioffer.class5.bintree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructBinTreeWithLevelAndInImpl implements ReconstructBinTreeWithLevelAndIn {
  @Override
  public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
    if (inOrder == null || inOrder.length == 0) return null;
    Map<Integer, Integer> inOrderMap = constructInIdxMap(inOrder);
    List<Integer> levelList = new ArrayList<>();
    for (int i : levelOrder) {
      levelList.add(i);
    }
    return recur(inOrderMap, levelList);
  }

  private TreeNode recur(Map<Integer, Integer> inOrder, List<Integer> levelList) {
    if (levelList.isEmpty()) return null;
    TreeNode root = new TreeNode(levelList.get(0));
    int rootInorderIdx = inOrder.get(root.key);

    List<Integer> leftLevelOrder = new ArrayList<>();
    List<Integer> rightLevelOrder = new ArrayList<>();
    for (int i = 1; i < levelList.size(); i++) {
      int curVal = levelList.get(i);
      int curIdx = inOrder.get(curVal);
      if (curIdx < rootInorderIdx) leftLevelOrder.add(curVal);
      else rightLevelOrder.add(curVal);
    }
    root.left = recur(inOrder, leftLevelOrder);
    root.right = recur(inOrder, rightLevelOrder);
    return root;
  }


  private Map<Integer, Integer> constructInIdxMap(int[] inOrder) {
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    for (int idx = 0; idx < inOrder.length; idx++) {
      inOrderMap.put(inOrder[idx], idx);
    }
    return inOrderMap;
  }
}
