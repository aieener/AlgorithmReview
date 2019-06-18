package alg.laioffer.crosstraining2;

import alg.laioffer.class4.bintree.TreeNode;

public class LargestNumSmallerInBST {
  public int largestSmaller(TreeNode root, int target) {
    int res = Integer.MIN_VALUE;
    while (root != null) {
      if (root.key < target) {
        res = Math.max(res, root.key);
        root = root.right;
      } else {
        root = root.left;
      }
    }
    return res;
  }
}
