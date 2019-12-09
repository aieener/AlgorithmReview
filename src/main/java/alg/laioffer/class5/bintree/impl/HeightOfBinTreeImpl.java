package alg.laioffer.class5.bintree.impl;

import alg.laioffer.class5.bintree.HeightOfBinTree;
import alg.laioffer.class5.bintree.TreeNode;

public class HeightOfBinTreeImpl implements HeightOfBinTree {
    @Override
    public int findHeight(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
