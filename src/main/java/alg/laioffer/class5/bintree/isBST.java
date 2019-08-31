package alg.laioffer.class5.bintree;

public class isBST {
  /**
   * + 1 - 1 很重要！
   */

  public boolean isBST(TreeNode root) {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBST(TreeNode node, Integer lowerBound, Integer upperBound) {
    // base case
    if (node == null) {
      return true;
    }
    if (node.key >= upperBound || node.key <= lowerBound) return false;
    return isBST(node.left, lowerBound, node.key) && isBST(node.right,node.key, upperBound);
  }
}
