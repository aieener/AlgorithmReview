package alg.laioffer.crosstraining2.impl;

import alg.laioffer.class4.bintree.TreeNode;
import alg.laioffer.crosstraining2.LargestNumSmallerInBST;

public class LargestNumSmallestInBSTImpl implements LargestNumSmallerInBST {

  @Override
  public int largestSmaller(TreeNode root, int target) {
    int res = Integer.MIN_VALUE;
    while (root != null) {
      if (root.key >= target) {
        root = root.left;
      } else {
        res = Math.max(res, root.key);
        root = root.right;
      }
    }
    return res;
  }
}
