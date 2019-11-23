package alg.laioffer.class26.adv3recursionIII.impl;

import alg.laioffer.class26.adv3recursionIII.ReconstructBinTreeWithPreAndIn;
import alg.laioffer.class5.bintree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinTreeWithPreAndInImpl implements ReconstructBinTreeWithPreAndIn {
  /**
   * preOrder [5,3,1,4,8,11] know head
   * inOrder [1,3,4,5,8,11]  know len
   */
  @Override
  public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
    if (inOrder.length == 0) return null;
    Map<Integer, Integer> inOrderIndexMap = getIndexMapForInOrder(inOrder);
    return recur(0, inOrder.length - 1, preOrder, 0, preOrder.length - 1, inOrderIndexMap);
  }

  private TreeNode recur(int inStart, int inEnd, int[] preOrder, int preStart, int preEnd, Map<Integer, Integer> inMap) {
    //base
    if (inStart > inEnd || preStart > preEnd) return null;
    int curHeadVal = preOrder[preStart];
    TreeNode curHead = new TreeNode(curHeadVal);
    int curHeadInOrderIdx = inMap.get(curHeadVal);
    int leftSubTreeLen = curHeadInOrderIdx - inStart;
    curHead.left = recur(inStart, inStart + leftSubTreeLen - 1, preOrder, preStart + 1, preStart + leftSubTreeLen, inMap);
    curHead.right = recur(curHeadInOrderIdx + 1, inEnd, preOrder, preStart + leftSubTreeLen + 1, preEnd, inMap);
    return curHead;
  }

  private Map<Integer, Integer> getIndexMapForInOrder(int[] in) {
    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int idx = 0; idx < in.length; idx++) {
      indexMap.put(in[idx], idx);
    }
    return indexMap;
  }
}
