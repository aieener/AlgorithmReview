package alg.laioffer.class27.adv3recursionIII;

import alg.laioffer.class5.bintree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinTreeWPreAndInOrder {
  public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
    Map<Integer, Integer> map = getInValToIndexMap(inOrder);
    return helper(preOrder, map, 0, inOrder.length - 1, 0, preOrder.length - 1);
  }

  private Map<Integer, Integer> getInValToIndexMap(int[] inOrder) {
    Map<Integer, Integer> map  = new HashMap<>();
    for(int i = 0; i < inOrder.length; i++) {
      map.put(inOrder[i], i);
    }
    return map;
  }

  private TreeNode helper(int[] pre, Map<Integer, Integer>inMap,int inLeft, int inRight, int preLeft, int preRight ) {
    // base case
    if(inLeft > inRight) {
      return null;
    }
    TreeNode root = new TreeNode(pre[preLeft]);
    int inMid = inMap.get(root.key);
    root.left = helper(pre, inMap, inLeft, inMid - 1, preLeft + 1, preLeft + (inMid - inLeft));
    root.right = helper(pre, inMap, inMid + 1, inRight,preLeft + (inMid - inLeft) + 1, preRight);
    return root;
  }
}
