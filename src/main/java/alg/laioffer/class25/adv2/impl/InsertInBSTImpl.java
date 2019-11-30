package alg.laioffer.class25.adv2.impl;

import alg.laioffer.class25.adv2.InsertInBST;
import alg.laioffer.class5.bintree.TreeNode;

public class InsertInBSTImpl implements InsertInBST {
    @Override
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }
}
