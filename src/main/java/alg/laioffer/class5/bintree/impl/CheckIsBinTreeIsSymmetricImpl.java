package alg.laioffer.class5.bintree.impl;

import alg.laioffer.class5.bintree.CheckIfBinTreeIsSymmetric;
import alg.laioffer.class5.bintree.TreeNode;

public class CheckIsBinTreeIsSymmetricImpl implements CheckIfBinTreeIsSymmetric {

    @Override
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSym(root.left, root.right);
    }

    private boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        if (left.key != right.key) return false;
        return isSym(left.right, right.left) && isSym(left.left, right.right);
    }
}
