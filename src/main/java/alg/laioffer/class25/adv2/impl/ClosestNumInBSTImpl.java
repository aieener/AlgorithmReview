package alg.laioffer.class25.adv2.impl;

import alg.laioffer.class25.adv2.ClosestNumInBST;
import alg.laioffer.class5.bintree.TreeNode;

/**
 * T = O(height)
 */
public class ClosestNumInBSTImpl implements ClosestNumInBST {
  @Override
  public int closest(TreeNode root, int target) {
    int res = root.key;
    while (root != null) {
      if (root.key == target) {
        return root.key;
      } else {
        if (Math.abs(root.key - target) < Math.abs(res - target)) {
          res = root.key;
        }
        if (root.key < target) {
          root = root.right;
        } else {
          root = root.left;
        }
      }
    }
    return res;
  }
}
