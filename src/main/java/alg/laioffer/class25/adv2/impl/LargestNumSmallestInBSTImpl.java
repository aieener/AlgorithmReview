package alg.laioffer.class25.adv2.impl;

import alg.laioffer.class25.adv2.LargestNumSmallerInBST;
import alg.laioffer.class5.bintree.TreeNode;

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
