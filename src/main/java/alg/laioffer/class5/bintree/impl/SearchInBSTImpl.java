package alg.laioffer.class5.bintree.impl;

import alg.laioffer.class5.bintree.SearchInBST;
import alg.laioffer.class5.bintree.TreeNode;

/**
 * Created by yuding on 1/19/18.
 * Elementary simple problem
 */

public class SearchInBSTImpl implements SearchInBST {
    public TreeNode searchBST(TreeNode root, int target) {
        // base case
        if (root == null) {
            return null;
        }
        if (root.key == target) {
            return root;
        } else if (root.key < target) {
            return searchBST(root.right, target);
        } else {
            return searchBST(root.left, target);
        }
    }

    @Override
    public TreeNode searchBSTIter(TreeNode root, int target) {
        while (root != null) {
            if (root.key > target) {
                root = root.left;
            } else if (root.key < target) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
