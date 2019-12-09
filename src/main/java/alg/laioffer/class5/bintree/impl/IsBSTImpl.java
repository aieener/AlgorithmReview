package alg.laioffer.class5.bintree.impl;

import alg.laioffer.class5.bintree.IsBST;
import alg.laioffer.class5.bintree.TreeNode;

public class IsBSTImpl implements IsBST {
    @Override
    public boolean isBST(TreeNode root) {
        return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isBST(TreeNode root, int max, int min) {
        if(root == null) return true;
        if(root.key >= max || root.key <= min) return false;
        boolean left = isBST(root.left, root.key, min);
        boolean right = isBST(root.right, max, root.key);
        return left && right;
    }
}
