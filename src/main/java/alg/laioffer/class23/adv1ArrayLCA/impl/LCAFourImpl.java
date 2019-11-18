package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.LCAFour;
import alg.laioffer.class5.bintree.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * two case:
 * direct parent
 * undirect parent
 */
public class LCAFourImpl implements LCAFour {
  @Override
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    Set<TreeNode> nodeSets = new HashSet<>(nodes);
    return lcaHelper(root, nodeSets);
  }

  private TreeNode lcaHelper(TreeNode root, Set<TreeNode> nodeSets) {
    if (root == null || nodeSets.contains(root)) return root;
    TreeNode left = lcaHelper(root.left, nodeSets);
    TreeNode right = lcaHelper(root.right, nodeSets);
    if (left != null && right != null) return root;
    else if (left != null) return left;
    else return right;
  }
}
