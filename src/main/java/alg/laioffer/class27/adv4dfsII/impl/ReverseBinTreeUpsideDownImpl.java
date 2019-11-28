package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.ReverseBinTreeUpsideDown;
import alg.laioffer.class5.bintree.TreeNode;

public class ReverseBinTreeUpsideDownImpl implements ReverseBinTreeUpsideDown {
    @Override
    public TreeNode reverse(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        TreeNode newRoot = reverse(leftChild);
        leftChild.left = root;
        leftChild.right = rightChild;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
