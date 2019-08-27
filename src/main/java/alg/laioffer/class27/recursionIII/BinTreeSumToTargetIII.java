package alg.laioffer.class27.recursionIII;

import alg.laioffer.class4.bintree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 直上直下， 考虑preorder, 并且maintain a path prefix
 * time: O(n * height), n is the number of the nodes
 */
public class BinTreeSumToTargetIII {
  public boolean exist(TreeNode root, int target) {
    // base case
    if (root == null) {
      return false;
    }

    List<TreeNode> path = new ArrayList<>(); // maintain a prefix path
    return helper(root, path, target);
  }

  private boolean helper(TreeNode root, List<TreeNode> path, int target) {
    path.add(root);
    if (checkPath(path, target)) return true;
    if (root.left != null && helper(root.left, path, target)) return true;
    if (root.right != null && helper(root.right, path, target)) return true;
    path.remove(path.size() - 1);
    return false;
  }

  private boolean checkPath(List<TreeNode> path, int target) {
    int sum = 0;
    for (int i = path.size() - 1; i >= 0; i--) {
      sum += path.get(i).key;
      if (sum == target) return true;
    }
    return false;
  }

  // O(n) sol
  public boolean exist2(TreeNode root, int target) {
    if(root == null ) return false;
    Set<Integer> prefixSums = new HashSet<>();
    prefixSums.add(0);
    return helper2(root, target, 0, prefixSums);
  }

  private boolean helper2(TreeNode root, int target, int prevSum, Set<Integer> prefixSums) {
    prevSum += root.key;
    if (prefixSums.contains(prevSum - target)) return true;

    boolean needRemove = prefixSums.add(prevSum);
    if(root.left != null && helper2(root.left, target, prevSum, prefixSums)) return true;
    if(root.right != null && helper2(root.right, target, prevSum, prefixSums)) return true;
    if(needRemove) prefixSums.remove(prevSum);
    return false;
  }
}
