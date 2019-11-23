package alg.laioffer.class26.adv3recursionIII;

import alg.laioffer.class5.bintree.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCAIV {
  /**
   * Needs to revisit, basically the same as classical LCA
   */
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    Set<TreeNode> set = new HashSet<>(nodes);
    return helper(root, set);
  }

  private TreeNode helper(TreeNode root, Set<TreeNode> set) {
    // base case
    if (root == null) return root;
    if (set.contains(root)) {
      return root;
    }

    TreeNode left = helper(root.left, set);
    TreeNode right = helper(root.right, set);
    if (left != null && right != null) {
      return root;
    }
    return left != null ? left : right;
  }

}
