package alg.laioffer.class26.adv3recursionIII.impl;

import alg.laioffer.class26.adv3recursionIII.BinTreePathSumToTargetThree;
import alg.laioffer.class5.bintree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class BinTreePathSumToTargetThreeImpl implements BinTreePathSumToTargetThree {
  @Override
  public boolean exist(TreeNode root, int target) {
    Set<Integer> pathPrefixSumSet = new HashSet<>();
    pathPrefixSumSet.add(0); // handle edge case that root == target
    return recur(root, target, 0, pathPrefixSumSet);
  }

  /**
   * total prefix sum = 12
   * xxxxxxxxxxxxxxxxx | XXXXXXXXXXXXXXXX ||end
   * prefix_sum = x       target_section = 17
   * if there exist an x that x + 17 = 12, then we found a solution
   */
  public boolean recur(TreeNode root, int target, int totalPrefixSum, Set<Integer> pathPrefixSumSet) {
    if (root == null) return false;
    totalPrefixSum += root.key;
    if (pathPrefixSumSet.contains(totalPrefixSum - target)) {
      return true;
    }
    boolean needRemove = pathPrefixSumSet.add(totalPrefixSum);
    boolean left = recur(root.left, target, totalPrefixSum, pathPrefixSumSet);
    boolean right = recur(root.right, target, totalPrefixSum, pathPrefixSumSet);
    if (needRemove) pathPrefixSumSet.remove(totalPrefixSum);
    return left || right;
  }
}
