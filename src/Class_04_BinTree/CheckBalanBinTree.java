package Class_04_BinTree;

import javax.swing.text.MaskFormatter;

public class CheckBalanBinTree {
  public boolean isBalanced(TreeNode root) {
    // balanced if left and right differ within one
    if(root == null) {
      return true;
    }
    int res = checkBalance(root);
    return res != -1;
  }

  private int checkBalance(TreeNode root ) {
    // base case
    if(root == null) {
      return 0;
    }
    int leftHeight = checkBalance(root.left);
    if(leftHeight == -1) return -1;
    int rightHeight = checkBalance(root.right);
    if(rightHeight == -1) return -1;

    if(Math.abs(leftHeight - rightHeight) > 1) return -1;
    return Math.max(leftHeight , rightHeight) + 1;
  }


}
