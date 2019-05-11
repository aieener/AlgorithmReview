package alg.laioffer.class4.bintree;

public class CheckSymBinTree {
  // Focus on this one!
  public boolean isSymmetricLaiSol(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSym(root.left,  root.right);
  }

  private boolean isSym(TreeNode left, TreeNode right) {
    // base case
    if(left == null && right == null) {
      return true;
    } else if (left == null || right == null) {
      return false;
    }

    if(left.key != right.key) return false;
    return isSym(left.left, right.right) && isSym(left.right, right.left);
  }
}
