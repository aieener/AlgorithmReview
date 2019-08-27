package alg.laioffer.crosstraining2.impl;

import alg.laioffer.class4.bintree.TreeNode;
import alg.laioffer.crosstraining2.ClosestNumInBST;

public class ClosestNumInBSTRecurImpl implements ClosestNumInBST {
  @Override
  public int closest(TreeNode root, int target) {
    if (root.key > target && root.left != null) {
      // go left
      int leftRes = closest(root.left, target);
      if (Math.abs(root.key - target) < Math.abs(leftRes - target)) {
        return root.key;
      } else {
        return leftRes;
      }
    } else if (root.key < target && root.right != null) {
      // go right
      int rightRes = closest(root.right, target);
      if (Math.abs(root.key - target) < Math.abs(rightRes - target)) {
        return root.key;
      } else {
        return rightRes;
      }
    } else {
      return root.key;
    }
  }
}
