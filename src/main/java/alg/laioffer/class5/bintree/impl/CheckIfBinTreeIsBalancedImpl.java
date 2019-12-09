package alg.laioffer.class5.bintree.impl;

import alg.laioffer.class4.linkedlist.CheckIfLLHasCycle;
import alg.laioffer.class5.bintree.CheckIfBinTreeIsBalanced;
import alg.laioffer.class5.bintree.TreeNode;

public class CheckIfBinTreeIsBalancedImpl implements CheckIfBinTreeIsBalanced {
    @Override
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int res = check(root);
        return res != -1;
    }

    private int check(TreeNode root) {
        if (root == null) return 0;
        int leftRes = check(root.left);
        if (leftRes == -1) return -1;
        int rightRes = check(root.right);
        if (rightRes == -1) return -1;
        if (Math.abs(leftRes - rightRes) > 1) {
            return -1;
        }
        return Math.max(leftRes, rightRes) + 1;
    }
}
